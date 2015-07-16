package halocraft.api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector2f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelRotation;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.ForgeBlockStateV1;
import net.minecraftforge.client.model.IColoredBakedQuad.ColoredBakedQuad;
import net.minecraftforge.client.model.IFlexibleBakedModel;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.IModelCustomData;
import net.minecraftforge.client.model.IModelPart;
import net.minecraftforge.client.model.IModelState;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.client.model.IPerspectiveState;
import net.minecraftforge.client.model.IRetexturableModel;
import net.minecraftforge.client.model.ISmartBlockModel;
import net.minecraftforge.client.model.ISmartItemModel;
import net.minecraftforge.client.model.MapModelState;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.common.FMLLog;

import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.BufferUtils;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class OBJModel implements IRetexturableModel, IModelCustomData
{
	private MaterialLibrary matLib;
	private IModelState state;
	private final ResourceLocation location;

	public OBJModel(MaterialLibrary matLib, ResourceLocation location)
	{
		this.matLib = matLib;
		this.location = location;
	}

	public IModelState getModelState()
	{
		return this.state;
	}

	@Override
	public Collection<ResourceLocation> getDependencies()
	{
		return Collections.emptyList();
	}

	@Override
	public Collection<ResourceLocation> getTextures()
	{
		Iterator<Material> materialIterator = this.matLib.materials.values().iterator();
		List<ResourceLocation> textures = new ArrayList<ResourceLocation>();
		while (materialIterator.hasNext())
		{
			Material mat = materialIterator.next();
			ResourceLocation textureLoc = new ResourceLocation(mat.getTexture().getPath());
			if (!textures.contains(textureLoc))
				textures.add(textureLoc);
		}
		return textures;
	}

	@Override
	public IFlexibleBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter)
	{
		ImmutableMap.Builder<String, TextureAtlasSprite> builder = ImmutableMap.builder();
		TextureAtlasSprite missing = bakedTextureGetter.apply(new ResourceLocation("missingno"));
		for (Map.Entry<String, Material> e : matLib.materials.entrySet())
		{
			if (e.getValue().getTexture().getTextureLocation().getResourcePath().startsWith("#"))
			{
				FMLLog.severe("unresolved texture '%s' for obj model '%s'", e.getValue().getTexture().getTextureLocation().getResourcePath(), location);
				builder.put(e.getKey(), missing);
			}
			else
			{
				builder.put(e.getKey(), bakedTextureGetter.apply(e.getValue().getTexture().getTextureLocation()));
			}
		}
		builder.put("missingno", missing);
		return new OBJBakedModel(this, state, format, builder.build());
	}

	public TRSRTransformation getDefaultState()
	{
		return TRSRTransformation.identity();
	}

	public MaterialLibrary getMatLib()
	{
		return this.matLib;
	}

	@Override
	public IModel process(ImmutableMap<String, String> customData)
	{
		// TODO: use for defining different visibility configurations?
		return null;
	}

	private static String getLocation(String path)
	{
		if (path.endsWith(".png"))
			path = path.substring(0, path.length() - ".png".length());
		return path;
	}

	@Override
	public IModel retexture(ImmutableMap<String, String> textures)
	{
		MaterialLibrary lib = this.matLib;
		for (Map.Entry<String, String> e : textures.entrySet())
		{
			//            FMLLog.info("OBJModel: Retexturing: %s with %s", e.getKey(), e.getValue());
			String name = e.getKey();
			String loc = e.getValue();
			if (name.equalsIgnoreCase("all"))
			{
				for (Map.Entry<String, Material> m : lib.materials.entrySet())
				{
					if (!m.getKey().equals(Material.WHITE_NAME))
					{
						m.getValue().getTexture().setPath(loc);
					}
				}
			}
			else if (lib.materials.containsKey(name))
			{
				lib.materials.get(name).getTexture().setPath(loc);
			}
		}
		return new OBJModel(lib, location);
	}

	public static class Parser
	{
		private static Set<String> unknownObjectCommands = new HashSet<String>();
		public MaterialLibrary materialLibrary = new OBJModel(null, null).new MaterialLibrary();
		private IResourceManager manager;
		private InputStreamReader objStream;
		private BufferedReader objReader;
		private ResourceLocation objFrom;

		private List<String> elementList = new ArrayList<String>();
		private List<Vertex> vertices = new ArrayList<Vertex>();
		private List<Normal> normals = new ArrayList<Normal>();
		private List<TextureCoordinate> texCoords = new ArrayList<TextureCoordinate>();

		private float minU = 0f;
		private float maxU = 1f;
		private float minV = 0f;
		private float maxV = 1f;

		public Parser(IResource from, IResourceManager manager) throws IOException
		{
			this.manager = manager;
			this.objFrom = from.getResourceLocation();
			this.objStream = new InputStreamReader(from.getInputStream(), Charsets.UTF_8);
			this.objReader = new BufferedReader(objStream);
		}

		public List<String> getElements()
		{
			return this.elementList;
		}

		public OBJModel parse() throws IOException
		{
			String currentLine = "";
			Material material = new Material();
			int usemtlCounter = 0;

			for (;;)
			{
				currentLine = objReader.readLine();
				if (currentLine == null) break;
				if (currentLine.isEmpty() || currentLine.startsWith("#")) continue;

				String[] fields = currentLine.split(" ", 2);
				String key = fields[0];
				String data = fields[1];

				if (key.equalsIgnoreCase("mtllib"))
					materialLibrary.parseMaterials(manager, data, objFrom);
				else if (key.equalsIgnoreCase("usemtl"))
				{
					material = materialLibrary.materials.get(data);
					usemtlCounter++;
				}
				else if (key.equalsIgnoreCase("v"))
				{
					String[] splitData = data.split(" ");
					float[] floatSplitData = new float[splitData.length];
					for (int i = 0; i < splitData.length; i++)
						floatSplitData[i] = Float.parseFloat(splitData[i]);
					Vector4f pos = new Vector4f(floatSplitData[0], floatSplitData[1], floatSplitData[2], floatSplitData.length == 4 ? floatSplitData[3] : 1);
					Vector4f color = new Vector4f(1f, 1f, 1f, 1f);
					if (material.isWhite()) color = material.getColor();
					Vertex vertex = new Vertex(pos, color);
					this.vertices.add(vertex);
				}
				else if (key.equalsIgnoreCase("vn"))
				{
					String[] splitData = data.split(" ");
					float[] floatSplitData = new float[splitData.length];
					for (int i = 0; i < splitData.length; i++)
						floatSplitData[i] = Float.parseFloat(splitData[i]);
					Normal normal = new Normal(new Vector3f(floatSplitData[0], floatSplitData[1], floatSplitData[2]));
					this.normals.add(normal);
				}
				else if (key.equalsIgnoreCase("vt"))
				{
					String[] splitData = data.split(" ");
					float[] floatSplitData = new float[splitData.length];
					for (int i = 0; i < splitData.length; i++)
						floatSplitData[i] = Float.parseFloat(splitData[i]);
					TextureCoordinate texCoord = new TextureCoordinate(new Vector3f(floatSplitData[0], floatSplitData[1],
							floatSplitData.length == 3 ? floatSplitData[2] : 1));
					if (floatSplitData[0] < this.minU)
					{
						this.minU = floatSplitData[0];
					}
					else if (floatSplitData[0] > this.maxU)
					{
						this.maxU = floatSplitData[0];
					}

					if (floatSplitData[1] < this.minV)
					{
						this.minV = floatSplitData[1];
					}
					else if (floatSplitData[1] > this.maxV)
					{
						this.maxV = floatSplitData[1];
					}
					this.texCoords.add(texCoord);
				}
				else if (key.equalsIgnoreCase("f"))
				{
					String[] splitSpace = data.split(" ");
					String[][] splitSlash = new String[splitSpace.length][];

					int vert = 0;
					int texCoord = 0;
					int norm = 0;

					List<Vertex> v = new ArrayList<Vertex>(splitSpace.length);
					List<TextureCoordinate> t = new ArrayList<TextureCoordinate>(splitSpace.length);
					List<Normal> n = new ArrayList<Normal>(splitSpace.length);

					for (int i = 0; i < splitSpace.length; i++)
					{
						if (splitSpace[i].contains("//"))
						{
							splitSlash[i] = splitSpace[i].split("//");

							vert = Integer.parseInt(splitSlash[i][0]);
							vert = vert < 0 ? this.vertices.size() - 1 : vert - 1;
							norm = Integer.parseInt(splitSlash[i][1]);
							norm = norm < 0 ? this.normals.size() - 1 : norm - 1;

							v.add(this.vertices.get(vert));
							n.add(this.normals.get(norm));
						}
						else if (splitSpace[i].contains("/"))
						{
							splitSlash[i] = splitSpace[i].split("/");

							vert = Integer.parseInt(splitSlash[i][0]);
							vert = vert < 0 ? this.vertices.size() - 1 : vert - 1;
							texCoord = Integer.parseInt(splitSlash[i][1]);
							texCoord = texCoord < 0 ? this.texCoords.size() - 1 : texCoord - 1;
							if (splitSlash[i].length > 2)
							{
								norm = Integer.parseInt(splitSlash[i][2]);
								norm = norm < 0 ? this.normals.size() - 1 : norm - 1;
							}

							v.add(this.vertices.get(vert));
							t.add(this.texCoords.get(texCoord));
							if (splitSlash[i].length > 2) n.add(this.normals.get(norm));
						}
						else
						{
							splitSlash[i] = splitSpace[i].split("");

							vert = Integer.parseInt(splitSlash[i][0]);
							vert = vert < 0 ? this.vertices.size() - 1 : vert - 1;

							v.add(this.vertices.get(vert));
						}
					}

					Vertex[] va = new Vertex[v.size()];
					v.toArray(va);
					TextureCoordinate[] ta = new TextureCoordinate[t.size()];
					t.toArray(ta);
					Normal[] na = new Normal[n.size()];
					n.toArray(na);
					Face face = new Face(va, na, ta);
					if (usemtlCounter < this.vertices.size())
					{
						for (Vertex ver : face.getVertices())
						{
							ver.setColor(material.getColor());
						}
						this.materialLibrary.library.put(face, material);
					}
					else
					{
						this.materialLibrary.library.put(face, this.materialLibrary.materials.get(Material.WHITE_NAME));
					}

					if (elementList.isEmpty())
					{
						if (this.materialLibrary.getGroups().containsKey(Group.DEFAULT_NAME))
						{
							this.materialLibrary.getGroups().get(Group.DEFAULT_NAME).addFace(face);
						}
						else
						{
							Group def = new Group(Group.DEFAULT_NAME, null);
							def.addFace(face);
							this.materialLibrary.getGroups().put(Group.DEFAULT_NAME, def);
						}
					}
					else
					{
						for (String s : elementList)
						{
							if (this.materialLibrary.getGroups().containsKey(s))
							{
								this.materialLibrary.getGroups().get(s).addFace(face);
							}
							else
							{
								Group e = new Group(s, null);
								e.addFace(face);
								this.materialLibrary.getGroups().put(s, e);
							}
						}
					}
				}
				else if (key.equalsIgnoreCase("g") || key.equalsIgnoreCase("o"))
				{
					elementList.clear();
					if (key.equalsIgnoreCase("g"))
					{
						String[] splitSpace = data.split(" ");
						for (String s : splitSpace)
							elementList.add(s);
					}
					else
					{
						elementList.add(data);
					}
				}
				else
				{
					if (!unknownObjectCommands.contains(key))
					{
						unknownObjectCommands.add(key);
						FMLLog.info("OBJLoader.Parser: command '%s' (model: '%s') is not currently supported, skipping", key, objFrom);
					}
				}
			}
			OBJModel model = new OBJModel(this.materialLibrary, this.objFrom);
			model.getMatLib().setUVBounds(minU, maxU, minV, maxV);
			return model;
		}
	}

	public class MaterialLibrary
	{
		private Set<String> unknownMaterialCommands = new HashSet<String>();
		private Map<String, Material> materials = new HashMap<String, Material>();
		private Map<Face, Material> library = new HashMap<Face, Material>();
		private Map<String, Group> groups = new HashMap<String, Group>();
		private InputStreamReader mtlStream;
		private BufferedReader mtlReader;
		private float minU = 0f;
		private float maxU = 1f;
		private float minV = 0f;
		private float maxV = 1f;

		public MaterialLibrary()
		{
			this.groups.put(Group.DEFAULT_NAME, new Group(Group.DEFAULT_NAME, null));
		}

		public float getMinU()
		{
			return this.minU;
		}

		public float getMaxU()
		{
			return this.maxU;
		}

		public float getMinV()
		{
			return this.minV;
		}

		public float getMaxV()
		{
			return this.maxV;
		}

		public void setUVBounds(float minU, float maxU, float minV, float maxV)
		{
			this.minU = minU;
			this.maxU = maxU;
			this.minV = minV;
			this.maxV = maxV;
		}

		public Map<String, Group> getGroups()
		{
			return this.groups;
		}

		public void replaceFaceInLibrary(Face from, Face to)
		{
			Material mat = this.library.get(from);
			if (mat != null)
			{
				this.library.remove(from);
				this.library.put(to, mat);
			}
		}

		public void parseMaterials(IResourceManager manager, String path, ResourceLocation from) throws IOException
		{
			this.materials.clear();
			boolean hasSetTexture = false;
			boolean hasSetColor = false;
			String domain = from.getResourceDomain();
			if (!path.contains("models/block/") && !path.contains("models/item/"))
			{
				if (from.getResourcePath().contains("models/block/")) path = "models/block/" + path;
				else if (from.getResourcePath().contains("models/item/")) path = "models/item/" + path;
			}
			mtlStream = new InputStreamReader(manager.getResource(new ResourceLocation(domain, path)).getInputStream(), Charsets.UTF_8);
			mtlReader = new BufferedReader(mtlStream);

			String currentLine = "";
			Material material = new Material();
			material.setName(Material.WHITE_NAME);
			material.setTexture(Texture.White);
			this.materials.put(Material.WHITE_NAME, material);

			for (;;)
			{
				currentLine = mtlReader.readLine();
				if (currentLine == null) break;
				if (currentLine.isEmpty() || currentLine.startsWith("#")) continue;

				String[] fields = currentLine.split(" ", 2);
				String key = fields[0];
				String data = fields[1];

				if (key.equalsIgnoreCase("newmtl"))
				{
					hasSetColor = false;
					hasSetTexture = false;
					material = new Material();
					material.setName(data);
					this.materials.put(data, material);
				}
				else if (key.equalsIgnoreCase("Ka") || key.equalsIgnoreCase("Kd") || key.equalsIgnoreCase("Ks"))
				{
					//TODO make these colors not override each other, either by doing different things or by only accepting one
					if (!hasSetColor)
					{
						String[] rgbStrings = data.split(" ", 3);
						Vector4f color = new Vector4f(Float.parseFloat(rgbStrings[0]), Float.parseFloat(rgbStrings[1]), Float.parseFloat(rgbStrings[2]), 1.0f);
						hasSetColor = true;
						material.setColor(color);
					}
					else
					{
						//TODO prevent this from triggering on the second reload at launch
						FMLLog.info("OBJModel: A color has already been defined for material '%s' in '%s'. The color defined by key '%s' will not be applied!", material.getName(), new ResourceLocation(domain, path).toString(), key);
					}
				}
				else if (key.equalsIgnoreCase("map_Ka") || key.equalsIgnoreCase("map_Kd") || key.equalsIgnoreCase("map_Ks"))
				{
					//TODO make these colors not override each other, either by doing different things or by only accepting one
					if (!hasSetTexture)
					{
						if (data.contains(" "))
						{
							String[] mapStrings = data.split(" ");
							String texturePath = mapStrings[mapStrings.length - 1];
							Texture texture = new Texture(texturePath);
							hasSetTexture = true;
							material.setTexture(texture);
						}
						else
						{
							Texture texture = new Texture(data);
							hasSetTexture = true;
							material.setTexture(texture);
						}
					}
					else
					{
						//TODO prevent this from triggering on the second reload at launch
						FMLLog.info("OBJModel: A texture has already been defined for material '%s' in '%s'. The texture defined by key '%s' will not be applied!", material.getName(), new ResourceLocation(domain, path).toString(), key);
					}
				}
				else
				{
					if (!unknownMaterialCommands.contains(key))
					{
						unknownMaterialCommands.add(key);
						FMLLog.info("OBJLoader.MaterialLibrary: command '%s' (model: '%s') is not currently supported, skipping", key, new ResourceLocation(
								domain, path));
					}
				}
			}
		}
	}

	public static class Material
	{
		public static final String WHITE_NAME = "OBJModel.White.Texture.Name";
		public static final String DEFAULT_NAME = "OBJModel.Default.Texture.Name";
		private Vector4f color;
		private Texture texture = Texture.White;
		private String name = DEFAULT_NAME;

		public Material()
		{
			this(new Vector4f(1f, 1f, 1f, 1f));
		}

		public Material(Vector4f color)
		{
			this(color, Texture.White, WHITE_NAME);
		}

		public Material(Texture texture)
		{
			this(new Vector4f(1, 1, 1, 1), texture, DEFAULT_NAME);
		}

		public Material(Vector4f color, Texture texture, String name)
		{
			this.color = color;
			this.texture = texture;
			this.name = name != null ? name : DEFAULT_NAME;
		}

		public void setName(String name)
		{
			this.name = name != null ? name : DEFAULT_NAME;
		}

		public String getName()
		{
			return this.name;
		}

		public void setColor(Vector4f color)
		{
			this.color = color;
		}

		public Vector4f getColor()
		{
			return this.color;
		}

		public void setTexture(Texture texture)
		{
			this.texture = texture;
		}

		public Texture getTexture()
		{
			return this.texture;
		}

		public boolean isWhite()
		{
			return this.texture.equals(Texture.White);
		}
	}

	public static class Texture
	{
		public static Texture White = new Texture("builtin/white", new Vector2f(0, 0), new Vector2f(1, 1), 0);
		private String path;
		private Vector2f position;
		private Vector2f scale;
		private float rotation;

		public Texture(String path)
		{
			this(path, new Vector2f(0, 0), new Vector2f(1, 1), 0);
		}

		public Texture(String path, Vector2f position, Vector2f scale, float rotation)
		{
			this.path = path;
			this.position = position;
			this.scale = scale;
			this.rotation = rotation;
		}

		public ResourceLocation getTextureLocation()
		{
			ResourceLocation loc = new ResourceLocation(this.path);
			return loc;
		}

		public void setPath(String path)
		{
			this.path = path;
		}

		public String getPath()
		{
			return this.path;
		}

		public void setPosition(Vector2f position)
		{
			this.position = position;
		}

		public Vector2f getPosition()
		{
			return this.position;
		}

		public void setScale(Vector2f scale)
		{
			this.scale = scale;
		}

		public Vector2f getScale()
		{
			return this.scale;
		}

		public void setRotation(float rotation)
		{
			this.rotation = rotation;
		}

		public float getRotation()
		{
			return this.rotation;
		}
	}

	public static class Face
	{
		private Vertex[] verts = new Vertex[4];
		private Normal[] norms = new Normal[4];
		private TextureCoordinate[] texCoords = new TextureCoordinate[4];

		public Face(Vertex[] verts)
		{
			this(verts, new Normal[0], new TextureCoordinate[0]);
		}

		public Face(Vertex[] verts, Normal[] norms)
		{
			this(verts, norms, null);
		}

		public Face(Vertex[] verts, TextureCoordinate[] texCoords)
		{
			this(verts, null, texCoords);
		}

		public Face(Vertex[] verts, Normal[] norms, TextureCoordinate[] texCoords)
		{
			this.verts = verts;
			this.verts = this.verts != null && this.verts.length > 0 ? this.verts : null;
			this.norms = norms;
			this.norms = this.norms != null && this.norms.length > 0 ? this.norms : null;
			this.texCoords = texCoords;
			this.texCoords = this.texCoords != null && this.texCoords.length > 0 ? this.texCoords : null;
			ensureQuads();
		}

		private void ensureQuads()
		{
			if (this.verts != null && this.verts.length == 3)
			{
				this.verts = new Vertex[]{this.verts[0], this.verts[1], this.verts[2], this.verts[2]};
			}

			if (this.norms != null && this.norms.length == 3)
			{
				this.norms = new Normal[]{this.norms[0], this.norms[1], this.norms[2], this.norms[2]};
			}

			if (this.texCoords != null && this.texCoords.length == 3)
			{
				this.texCoords = new TextureCoordinate[]{this.texCoords[0], this.texCoords[1], this.texCoords[2], this.texCoords[2]};
			}
		}

		public boolean setVertices(Vertex[] verts)
		{
			if (verts == null) return false;
			else this.verts = verts;
			return true;
		}

		public Vertex[] getVertices()
		{
			return this.verts;
		}

		public boolean setNormals(Normal[] norms)
		{
			if (norms == null) return false;
			else this.norms = norms;
			return true;
		}

		public Normal[] getNormals()
		{
			return this.norms;
		}

		public boolean setTextureCoordinates(TextureCoordinate[] texCoords)
		{
			if (texCoords == null) return false;
			else this.texCoords = texCoords;
			return true;
		}

		public TextureCoordinate[] getTextureCoordinates()
		{
			return this.texCoords;
		}

		public boolean areUVsNormalized()
		{
			for (TextureCoordinate t : this.texCoords)
			{
				if (!(t.getPosition().getX() > 0.0f && t.getPosition().getX() < 1.0f && t.getPosition().getY() > 0.0f && t.getPosition().getY() < 1.0f))
				{
					return false;
				}
			}
			return true;
		}

		public Face bake(TRSRTransformation transform)
		{
			Matrix4f t = new Matrix4f();
			if (transform == TRSRTransformation.identity())
			{
				t.setIdentity();
			}

			for (int i = 0; i < verts.length; i++)
			{
				t = transform.getMatrix();
				Vertex v = verts[i];
				TextureCoordinate tc = texCoords != null ? texCoords[i] : null;
				Normal n = norms != null ? norms[i] : null;

				Vector4f pos = new Vector4f(v.getPosition()), newPos = new Vector4f();
				pos.w = 1;
				t.transform(pos, newPos);
				Vector4f rPos = new Vector4f(newPos.x, newPos.y, newPos.z, newPos.w);
				//                Vector4f rPos = new Vector4f(newPos.x / newPos.w, newPos.y / newPos.w, newPos.z / newPos.w, newPos.w);
				//                Vector4f rPos = new Vector4f(pos.x / pos.w, pos.y / pos.w, pos.z / pos.w, pos.w);
				verts[i] = new Vertex(rPos, v.getColor());

				if (n != null)
				{
					t.invert();
					t.transpose();
					Vector4f normal = new Vector4f(n.getNormal()), newNormal = new Vector4f();
					normal.w = 1;
					t.transform(normal, newNormal);
					Vector3f rNormal = new Vector3f(newNormal.x / newNormal.w, newNormal.y / newNormal.w, newNormal.z / newNormal.w);
					rNormal.normalize();
					norms[i] = new Normal(rNormal);
				}

				//texCoords TODO
			}
			return new Face(verts, norms, texCoords);
		}

		public Normal getNormal()
		{
			if (norms == null)
			{ // use vertices to calculate normal
				Vector3f v1 = new Vector3f(this.verts[0].getPosition().x, this.verts[0].getPosition().y, this.verts[0].getPosition().z);
				Vector3f v2 = new Vector3f(this.verts[1].getPosition().x, this.verts[1].getPosition().y, this.verts[1].getPosition().z);
				Vector3f v3 = new Vector3f(this.verts[2].getPosition().x, this.verts[2].getPosition().y, this.verts[2].getPosition().z);
				Vector3f v4 = this.verts.length > 3 ? new Vector3f(this.verts[3].getPosition().x, this.verts[3].getPosition().y, this.verts[3].getPosition().z)
				: null;

				if (v4 == null)
				{
					Vector3f v2c = new Vector3f(v2.x, v2.y, v2.z);
					Vector3f v1c = new Vector3f(v1.x, v1.y, v1.z);
					v1c.sub(v2c);
					Vector3f v3c = new Vector3f(v3.x, v3.y, v3.z);
					v3c.sub(v2c);
					Vector3f c = new Vector3f();
					c.cross(v1c, v3c);
					c.normalize();
					Normal normal = new Normal(c);
					return normal;
				}
				else
				{
					Vector3f v2c = new Vector3f(v2.x, v2.y, v2.z);
					Vector3f v1c = new Vector3f(v1.x, v1.y, v1.z);
					v1c.sub(v2c);
					Vector3f v3c = new Vector3f(v3.x, v3.y, v3.z);
					v3c.sub(v2c);
					Vector3f c = new Vector3f();
					c.cross(v1c, v3c);
					c.normalize();

					v1c = new Vector3f(v1.x, v1.y, v1.z);
					v3c = new Vector3f(v3.x, v3.y, v3.z);

					Vector3f v4c = new Vector3f(v4.x, v4.y, v4.z);
					v1c.sub(v4c);
					v3c.sub(v4c);
					Vector3f d = new Vector3f();
					d.cross(v1c, v3c);
					d.normalize();

					Vector3f avg = new Vector3f();
					avg.x = (c.x + d.x) * 0.5f;
					avg.y = (c.y + d.y) * 0.5f;
					avg.z = (c.z + d.z) * 0.5f;
					avg.normalize();
					Normal normal = new Normal(avg);
					return normal;
				}
			}
			else
			{ // use normals to calculate normal
				Vector3f n1 = this.norms[0].getNormal();
				Vector3f n2 = this.norms[1].getNormal();
				Vector3f n3 = this.norms[2].getNormal();
				Vector3f n4 = this.norms.length > 3 ? this.norms[3].getNormal() : null;

				if (n4 == null)
				{
					Vector3f n2c = new Vector3f(n2.x, n2.y, n2.z);
					Vector3f n1c = new Vector3f(n1.x, n1.y, n1.z);
					n1c.sub(n2c);
					Vector3f n3c = new Vector3f(n3.x, n3.y, n3.z);
					n3c.sub(n2c);
					Vector3f c = new Vector3f();
					c.cross(n1c, n3c);
					c.normalize();
					Normal normal = new Normal(c);
					return normal;
				}
				else
				{
					Vector3f n2c = new Vector3f(n2.x, n2.y, n2.z);
					Vector3f n1c = new Vector3f(n1.x, n1.y, n1.z);
					n1c.sub(n2c);
					Vector3f n3c = new Vector3f(n3.x, n3.y, n3.z);
					n3c.sub(n2c);
					Vector3f c = new Vector3f();
					c.cross(n1c, n3c);
					c.normalize();

					n1c = new Vector3f(n1.x, n1.y, n1.z);
					n3c = new Vector3f(n3.x, n3.y, n3.z);

					Vector3f n4c = new Vector3f(n4.x, n4.y, n4.z);
					n1c.sub(n4c);
					n3c.sub(n4c);
					Vector3f d = new Vector3f();
					d.cross(n1c, n3c);
					d.normalize();

					Vector3f avg = new Vector3f();
					avg.x = (c.x + d.x) * 0.5f;
					avg.y = (c.y + d.y) * 0.5f;
					avg.z = (c.z + d.z) * 0.5f;
					avg.normalize();
					Normal normal = new Normal(avg);
					return normal;
				}
			}
		}
	}

	public static class Vertex
	{
		private Vector4f position;
		private Vector4f color;

		public Vertex(Vector4f position, Vector4f color)
		{
			this.position = position;
			this.color = color;
		}

		public void setPos(Vector4f position)
		{
			this.position = position;
		}

		public Vector4f getPosition()
		{
			return this.position;
		}

		public void setColor(Vector4f color)
		{
			this.color = color;
		}

		public Vector4f getColor()
		{
			return this.color;
		}

		public Vertex bake(TRSRTransformation transform)
		{
			Matrix4f t = new Matrix4f();
			if (transform == TRSRTransformation.identity())
			{
				t.setIdentity();
			}
			else
			{
				t.add(transform.getMatrix());
			}

			Vector4f pos = new Vector4f(this.position), newPos = new Vector4f();
			pos.w = 1;
			t.transform(pos, newPos);
			//TODO: should i be dividing here?
			Vector4f rPos = new Vector4f(newPos.x / newPos.w, newPos.y / newPos.w, newPos.z / newPos.w, newPos.w);
			return new Vertex(rPos, this.color);
		}

		@Override
		public String toString()
		{
			StringBuilder builder = new StringBuilder();
			builder.append(String.format("v:%n"));
			builder.append(String.format("    position: %s %s %s%n", position.x, position.y, position.z));
			builder.append(String.format("    color: %s %s %s %s%n", color.x, color.y, color.z, color.w));
			return builder.toString();
		}
	}

	public static class Normal
	{
		private Vector3f normal;

		public Normal(Vector3f normal)
		{
			this.normal = normal;
		}

		public void setNormal(Vector3f normal)
		{
			this.normal = normal;
		}

		public Vector3f getNormal()
		{
			return this.normal;
		}
	}

	public static class TextureCoordinate
	{
		private Vector3f position;

		public TextureCoordinate(Vector3f position)
		{
			this.position = position;
		}

		public void setPosition(Vector3f position)
		{
			this.position = position;
		}

		public Vector3f getPosition()
		{
			return this.position;
		}
	}
	public static class Group implements IModelPart
	{
		public static final String DEFAULT_NAME = "OBJModel.Default.Element.Name";
		public static final String ALL = "OBJModel.Group.All.Key";
		public static final String ALL_EXCEPT = "OBJModel.Group.All.Except.Key";
		private String name = DEFAULT_NAME;
		private TRSRTransformation transform = TRSRTransformation.identity();
		private LinkedHashSet<Face> faces = new LinkedHashSet<Face>();
		private boolean visible = true;

		public Group(String name, LinkedHashSet<Face> faces)
		{
			this(name, TRSRTransformation.identity(), faces);
		}

		public Group(String name, TRSRTransformation transform, LinkedHashSet<Face> faces)
		{
			this.name = name != null ? name : DEFAULT_NAME;
			this.transform = transform;
			this.faces = faces == null ? new LinkedHashSet<Face>() : faces;
		}

		public void applyTransform()
		{
			LinkedHashSet<Face> faceSet = new LinkedHashSet<Face>();
			for (Face f : this.faces)
			{
				faceSet.add(f.bake(this.transform));
			}
			this.faces = faceSet;
		}

		public String getName()
		{
			return this.name;
		}

		public void setTransform(TRSRTransformation transform)
		{
			this.transform = transform == null ? TRSRTransformation.identity() : transform;
		}

		public TRSRTransformation getTransform()
		{
			return this.transform;
		}

		public LinkedHashSet<Face> getFaces()
		{
			return this.faces;
		}

		public void setFaces(LinkedHashSet<Face> faces)
		{
			this.faces = faces;
		}

		public void addFace(Face face)
		{
			this.faces.add(face);
		}

		public void addFaces(List<Face> faces)
		{
			this.faces.addAll(faces);
		}

		public void setVisible(boolean visible)
		{
			this.visible = visible;
		}

		public boolean getVisible()
		{
			return this.visible;
		}
	}

	public static class OBJState implements IModelState
	{
		private OBJModel model;
		private Map<String, Boolean> visibilityMap = new HashMap<String, Boolean>();
		public IModelState parent;

		public OBJState(IModelState parent, List<String> visibleGroups, boolean visibility)
		{
			this.parent = getParent(parent);
			for (String s : visibleGroups)
			{
				visibilityMap.put(s, visibility);
			}
		}

		//        public OBJState(OBJModel model, IModelState parent, List<String> visibleGroups, boolean visibility)
		//        {
		//            this.model = model;
		//            this.parent = getParent(parent);
		//            for (String s : visibleGroups)
		//            {
		//                visibilityMap.put(s, visibility);
		//            }
		//            applyVisibilities();
		//        }

		public OBJModel getModel()
		{
			return this.model;
		}

		public void setModel(OBJModel model)
		{
			this.model = model;
		}

		private IModelState getParent(IModelState parent)
		{
			if (parent == null) return TRSRTransformation.identity();
			else if (parent instanceof OBJState) return ((OBJState) parent).parent;
			return parent;
		}

		public TRSRTransformation apply(IModelPart part)
		{
			TRSRTransformation ret = TRSRTransformation.identity();
			if (parent != null)
			{
				ret = parent.apply(part).compose(composePart(part));
			}
			return ret;
		}

		private TRSRTransformation composePart(IModelPart part)
		{
			TRSRTransformation ret = TRSRTransformation.identity();
			if (part instanceof Group)
			{
				Group element = (Group) part;
				ret = ret.compose(element.getTransform());
				Matrix4f matrix = ret.getMatrix();
				matrix.invert();
				ret = ret.compose(new TRSRTransformation(matrix));
			}
			return ret;
		}

		public Map<String, Boolean> getVisibilityMap()
		{
			return this.visibilityMap;
		}

		public List<String> getGroupsWithVisibility(boolean visibility)
		{
			List<String> ret = new ArrayList<String>();
			for (Map.Entry<String, Boolean> e : this.visibilityMap.entrySet())
			{
				if (e.getValue().booleanValue() == visibility)
				{
					ret.add(e.getKey());
				}
			}
			return ret;
		}

		public List<String> getGroupNamesFromMap()
		{
			List<String> ret = new ArrayList<String>();
			ret.addAll(this.visibilityMap.keySet());
			return ret;
		}

		public void changeGroupVisibilities(List<String> names, Operation operation)
		{
			if (names == null || names.isEmpty()) return;
			if (names.get(0).equals(Group.ALL))
			{
				for (String s : this.visibilityMap.keySet())
				{
					if (operation == Operation.SET_TRUE) this.visibilityMap.put(s, true);
					else if (operation == Operation.SET_FALSE) this.visibilityMap.put(s, false);
					else if (operation == Operation.TOGGLE) this.visibilityMap.put(s, !this.visibilityMap.get(s));
				}
			}
			else if (names.get(0).equals(Group.ALL_EXCEPT))
			{
				List exceptList = names.subList(1, names.size());
				for (String e : this.visibilityMap.keySet())
				{
					if (!exceptList.contains(e))
					{
						if (operation == Operation.SET_TRUE) this.visibilityMap.put(e, true);
						else if (operation == Operation.SET_FALSE) this.visibilityMap.put(e, false);
						else if (operation == Operation.TOGGLE) this.visibilityMap.put(e, !this.visibilityMap.get(e));
					}
				}
			}
			else
			{
				for (String s : names)
				{
					if (operation == Operation.SET_TRUE) this.visibilityMap.put(s, true);
					else if (operation == Operation.SET_FALSE) this.visibilityMap.put(s, false);
					else if (operation == Operation.TOGGLE) this.visibilityMap.put(s, !this.visibilityMap.get(s));
				}
			}
			applyVisibilities();
		}

		private void applyVisibilities()
		{
			if (this.model != null)
			{
				for (String s : this.visibilityMap.keySet())
				{
					if (this.model.getMatLib().getGroups().containsKey(s))
					{
						this.model.getMatLib().getGroups().get(s).setVisible(this.visibilityMap.get(s));
					}
				}
			}
		}

		public static enum Operation
		{
			SET_TRUE,
			SET_FALSE,
			TOGGLE;

			private Operation(){}
		}
	}

	public enum OBJProperty implements IUnlistedProperty<OBJState>
	{
		instance;
		public String getName()
		{
			return "OBJPropery";
		}

		@Override
		public boolean isValid(OBJState value)
		{
			return value instanceof OBJState;
		}

		@Override
		public Class<OBJState> getType()
		{
			return OBJState.class;
		}

		@Override
		public String valueToString(OBJState value)
		{
			return value.toString();
		}
	}

	private class OBJBakedModel implements IFlexibleBakedModel, ISmartBlockModel, ISmartItemModel, IPerspectiveAwareModel
	{
		private final OBJModel model;
		private final IModelState state;
		private final VertexFormat format;
		private final ByteBuffer buffer;
		private LinkedHashSet<BakedQuad> quads;
		private static final int BYTES_IN_INT = Integer.SIZE / Byte.SIZE;
		private static final int VERTICES_IN_QUAD = 4;
		private Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter;
		private ImmutableMap<String, TextureAtlasSprite> textures;

		public OBJBakedModel(OBJModel model, IModelState state, VertexFormat format, ImmutableMap<String, TextureAtlasSprite> textures)
		{
			this.model = model;
			this.state = state;
			this.format = format;
			this.textures = textures;
			buffer = BufferUtils.createByteBuffer(VERTICES_IN_QUAD * format.getNextOffset());
		}

		@Override
		public List<BakedQuad> getFaceQuads(EnumFacing side)
		{
			return Collections.emptyList();
		}

		@Override
		public List<BakedQuad> getGeneralQuads()
		{
			if (quads == null)
			{
				quads = new LinkedHashSet<BakedQuad>();
				LinkedHashSet<Face> faces = new LinkedHashSet<Face>();
				//                if (this.state instanceof OBJState)
				//                {
				//                    FMLLog.info("OBJBakedModel: state is OBJState");
				//                    if (((OBJState) this.state).parent != null && ((OBJState) this.state).parent instanceof TRSRTransformation)
				//                    {
				//                        FMLLog.info("OBJBakedModel: state parent is a TRSRTransformation");
				//                        TRSRTransformation parent = (TRSRTransformation) ((OBJState) this.state).parent;
				//                        FMLLog.info("%n%s", parent.getMatrix());
				//                    }
				//                }
				for (Group e : this.model.getMatLib().getGroups().values())
				{
					LinkedHashSet<Face> fromSet = Sets.newLinkedHashSet(e.getFaces());
					LinkedHashSet<Face> toSet = new LinkedHashSet<Face>();
					if (e.getVisible())
					{
						e.applyTransform();
						toSet.addAll(e.getFaces());
						faces.addAll(e.getFaces());
					}
					Iterator<Face> fromIterator = fromSet.iterator();
					Iterator<Face> toIterator = toSet.iterator();
					while (fromIterator.hasNext() && toIterator.hasNext())
					{
						Face from = fromIterator.next();
						Face to = toIterator.next();
						this.model.getMatLib().replaceFaceInLibrary(from, to);
					}
				}
				for (Face f : faces)
				{
					buffer.clear();
					String texture = this.model.getMatLib().library.get(f).getName();
					if (this.state instanceof OBJState)
					{
						if (((OBJState) this.state).parent != null && ((OBJState) this.state).parent instanceof TRSRTransformation)
						{
							f = f.bake((TRSRTransformation) (((OBJState) this.state).parent));
						}
					}
					else if (this.state instanceof TRSRTransformation)
					{
						texture = this.model.getMatLib().library.get(f).getName();
						f = f.bake((TRSRTransformation) this.state);
					}
					TextureAtlasSprite sprite = this.textures.get("missingno");
					if (this.model.getMatLib().materials.get(texture).isWhite()) sprite = ModelLoader.White.instance;
					else sprite = this.textures.get(texture);

					float minU = 0.0f;
					float maxU = 1.0f;
					float minV = 0.0f;
					float maxV = 1.0f;

					if (f.texCoords != null && !f.areUVsNormalized())
					{
						for (TextureCoordinate t : f.texCoords)
						{
							minU = t.getPosition().getX() < minU ? t.getPosition().getX() : minU;
							maxU = t.getPosition().getX() > maxU ? t.getPosition().getX() : maxU;
							minV = t.getPosition().getY() < minV ? t.getPosition().getY() : minV;
							maxV = t.getPosition().getY() > maxV ? t.getPosition().getY() : maxV;
						}

						for (int i = 0; i < f.texCoords.length; i++)
						{
							TextureCoordinate t = f.texCoords[i];
							float U = (t.getPosition().getX() - minU) / (maxU - minU);
							float V = (t.getPosition().getY() - minV) / (maxV - minV);
							Vector3f normPos = new Vector3f(U, V, t.getPosition().getZ());
							f.texCoords[i] = new TextureCoordinate(normPos);
						}
					}

					TextureCoordinate def1 = new TextureCoordinate(new Vector3f(minU, minV, 1));
					TextureCoordinate def2 = new TextureCoordinate(new Vector3f(maxU, minV, 1));
					TextureCoordinate def3 = new TextureCoordinate(new Vector3f(maxU, maxV, 1));
					TextureCoordinate def4 = new TextureCoordinate(new Vector3f(minU, maxV, 1));
					//                    putVertexData(f.verts[0], f.texCoords != null ? f.texCoords[0] : null, f.norms != null ? f.norms[0] : f.getNormal(), sprite);
					//                    putVertexData(f.verts[1], f.texCoords != null ? f.texCoords[1] : null, f.norms != null ? f.norms[1] : f.getNormal(), sprite);
					//                    putVertexData(f.verts[2], f.texCoords != null ? f.texCoords[2] : null, f.norms != null ? f.norms[2] : f.getNormal(), sprite);
					//                    putVertexData(f.verts[3], f.texCoords != null ? f.texCoords[3] : null, f.norms != null ? f.norms[3] : f.getNormal(), sprite);
					putVertexData(f.verts[0], f.texCoords != null ? f.texCoords[0] : def1, f.norms != null ? f.norms[0] : f.getNormal(), sprite);
					putVertexData(f.verts[1], f.texCoords != null ? f.texCoords[1] : def2, f.norms != null ? f.norms[1] : f.getNormal(), sprite);
					putVertexData(f.verts[2], f.texCoords != null ? f.texCoords[2] : def3, f.norms != null ? f.norms[2] : f.getNormal(), sprite);
					putVertexData(f.verts[3], f.texCoords != null ? f.texCoords[3] : def4, f.norms != null ? f.norms[3] : f.getNormal(), sprite);
					buffer.flip();
					int[] data = new int[VERTICES_IN_QUAD * format.getNextOffset() / BYTES_IN_INT];
					buffer.asIntBuffer().get(data);
					quads.add(new ColoredBakedQuad(data, -1, EnumFacing.getFacingFromVector(f.getNormal().normal.x, f.getNormal().normal.y, f.getNormal().normal.z)));
				}
			}
			List<BakedQuad> quadList = new ArrayList<BakedQuad>();
			quadList.addAll(quads);
			return quadList;
		}

		private void put(ByteBuffer buffer, VertexFormatElement e, Float... fs)
		{
			Attributes.put(buffer, e, true, 0f, fs);
		}

		@SuppressWarnings("unchecked")
		private final void putVertexData(Vertex v, TextureCoordinate t, Normal n, TextureAtlasSprite sprite)
		{
			int oldPos = buffer.position();
			Number[] ns = new Number[16];
			for (int i = 0; i < ns.length; i++)
				ns[i] = 0f;
			for (VertexFormatElement e : (List<VertexFormatElement>) format.getElements())
			{
				switch (e.getUsage())
				{
				case POSITION:
					put(buffer, e, v.position.x, v.position.y, v.position.z, 1f);
					break;
				case COLOR:
					if (v.color != null)
						put(buffer, e, v.color.x, v.color.y, v.color.z, v.color.w);
					else
						put(buffer, e, 1f, 1f, 1f, 1f);
					break;
				case UV:
					if (t != null)
					{
						put(buffer, e, sprite.getInterpolatedU(t.getPosition().x * 16), sprite.getInterpolatedV(t.getPosition().y * 16), 0f, 1f);
					}
					else
						put(buffer, e, 0f, 0f, 0f, 1f);
					break;
				case NORMAL:
					put(buffer, e, n.normal.x, n.normal.y, n.normal.z, 1f);
					break;
				case GENERIC:
					put(buffer, e, 0f, 0f, 0f, 0f);
					break;
				default:
					break;
				}
			}
			buffer.position(oldPos + format.getNextOffset());
		}

		@Override
		public boolean isAmbientOcclusion()
		{
			return true;
		}

		@Override
		public boolean isGui3d()
		{
			return true;
		}

		@Override
		public boolean isBuiltInRenderer()
		{
			return false;
		}

		@Override
		public TextureAtlasSprite getTexture()
		{
			return this.textures.get(0);
		}

		@Override
		public ItemCameraTransforms getItemCameraTransforms()
		{
			return ItemCameraTransforms.DEFAULT;
		}

		@Override
		public VertexFormat getFormat()
		{
			return format;
		}

		@Override
		public IBakedModel handleItemState(ItemStack stack)
		{
			return this;
		}

		@Override
		public OBJBakedModel handleBlockState(IBlockState state)
		{
			//            if (state instanceof TRSRTransformation)
			//            {
			//                FMLLog.info("state is TRSRTransformation", new Object[0]);
			//                TRSRTransformation trans = (TRSRTransformation) state;
			//                if (!cache.containsKey(trans))
			//                {
			//                    cache.put(trans, new OBJBakedModel(this.model, trans, this.format, this.textures));
			//                }
			//                return cache.get(trans);
			//            }
			//            FMLLog.info("state not trans, returning this", new Object[0]);
			//            return this;
			if (state instanceof IExtendedBlockState)
			{
				//                FMLLog.info("handleBlockState: %s has an extended state", state.getBlock().getUnlocalizedName());
				IExtendedBlockState exState = (IExtendedBlockState) state;
				if (exState.getUnlistedNames().contains(OBJProperty.instance))
				{
					//                    TRSRTransformation s = (TRSRTransformation) exState.getValue(OBJProperty.instance);
					OBJState s = (OBJState) exState.getValue(OBJProperty.instance);
					//                    FMLLog.info("handleBlockState: s is equal to: %s", s);
					if (s != null)
					{
						return getCachedModel(s);
					}
				}
			}
			return this;
		}

		private final Map<IModelState, OBJBakedModel> cache = new HashMap<IModelState, OBJBakedModel>();

		public OBJBakedModel getCachedModel(IModelState state)
		{
			if (!cache.containsKey(state))
			{
				//                FMLLog.info("state is not in cache, returning new obj model", new Object[0]);
				//                FMLLog.info("state with rotation left: %s, right: %s, is not in cache", ((TRSRTransformation) state).getLeftRot(), ((TRSRTransformation) state).getRightRot());
				cache.put(state, new OBJBakedModel(this.model, state, this.format, this.textures));
				//                cache.put(state, new OBJBakedModel(this.model, this.state, this.format, this.textures));
				//                cache.put(state, new OBJBakedModel(this.model, new OBJState(((OBJState) state).getVisibleElementNames(), this.model, this.state), this.format, this.textures));
			}
			//            FMLLog.info("returning model from cache", new Object[0]);
			return cache.get(state);
		}

		public OBJModel getModel()
		{
			return this.model;
		}

		public IModelState getState()
		{
			return this.state;
		}

		public OBJBakedModel getBakedModel()
		{
			return new OBJBakedModel(this.model, this.state, this.format, this.textures);
			//            return new OBJBakedModel(model, new OBJState(visibleElements, this.model, this.state), format, this.textures);
		}

		@Override
		public Pair<IBakedModel, Matrix4f> handlePerspective(TransformType cameraTransformType)
		{
			if (state instanceof IPerspectiveState)
			{
				return Pair.of((IBakedModel) this, TRSRTransformation.blockCornerToCenter(((IPerspectiveState) state).forPerspective(cameraTransformType).apply(model)).getMatrix());
			}
			return Pair.of((IBakedModel) this, null);
		}

		@Override
		public String toString()
		{
			return this.model.location.toString();
		}
	}
}
