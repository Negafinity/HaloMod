package io.github.hsyyid.halocraft.util;

import com.arisux.airix.AIRIX;
import com.arisux.airix.api.wavefrontapi.WavefrontModel;

import io.github.hsyyid.halocraft.HaloCraft;

public class Models
{
	public static WavefrontModel ASSAULT_RIFLE;
	public static WavefrontModel BATTLE_RIFLE;
	public static WavefrontModel CARBINE_RIFLE;
	public static WavefrontModel BOLTSHOT;
	public static WavefrontModel SMG;
	public static WavefrontModel SHOTGUN;

	public static WavefrontModel PLASMA_ROCKET;
	public static WavefrontModel PURPLE_PLASMA;
	public static WavefrontModel ROCKET;

	public static WavefrontModel GHOST;
	public static WavefrontModel MONGOOSE;
	public static WavefrontModel SCORPION;
	public static WavefrontModel WARTHOG;
	public static WavefrontModel WARTHOG_TURRET;

	public static void loadModels()
	{
		// Weapons
		ASSAULT_RIFLE = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "AssaultRifle", "/assets/halocraft/models/item/AssaultRifle");
		BATTLE_RIFLE = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "BattleRifle", "/assets/halocraft/models/item/BattleRifle");
		CARBINE_RIFLE = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "CarbineRifle", "/assets/halocraft/models/item/CarbineRifle");
		BOLTSHOT = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "Boltshot", "/assets/halocraft/models/item/Boltshot");
		SHOTGUN = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "shotgun", "/assets/halocraft/models/item/shotgun");
		SMG = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "smg", "/assets/halocraft/models/item/smg");

		// Entities
		PLASMA_ROCKET = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "Rod-Plasma", "/assets/halocraft/models/entity/Rod-Plasma");
		PURPLE_PLASMA = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "Needle", "/assets/halocraft/models/entity/Needle");
		ROCKET = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "Rocket", "/assets/halocraft/models/entity/Rocket");

		// Vehicles
		GHOST = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "Ghost", "/assets/halocraft/models/entity/Ghost");
		MONGOOSE = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "Mongoose", "/assets/halocraft/models/entity/Mongoose");
		SCORPION = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "Scorpion", "/assets/halocraft/models/entity/Scorpion");
		WARTHOG = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "Warthog", "/assets/halocraft/models/entity/Warthog");
		WARTHOG_TURRET = AIRIX.wavefrontAPI().loadModel(HaloCraft.class, HaloCraft.MODID, "WarthogTurret", "/assets/halocraft/models/entity/WarthogTurret");
	}
}
