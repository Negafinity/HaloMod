package halocraft;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMongoose extends ModelBase
{
	//fields
	ModelRenderer Left;
	ModelRenderer Front;
	ModelRenderer WheelLeftPopout;
	ModelRenderer AxelFront;
	ModelRenderer Back;
	ModelRenderer WheelRight;
	ModelRenderer WheelRightPopout;
	ModelRenderer WheelRightTop;
	ModelRenderer WheelRightBack;
	ModelRenderer WheelRightFront;
	ModelRenderer WheelRightBottom;
	ModelRenderer Windscreen;
	ModelRenderer LightLeft;
	ModelRenderer LightRight;
	ModelRenderer SteeringStem;
	ModelRenderer SteeringWheel;
	ModelRenderer SeatBottom;
	ModelRenderer SeatBack;
	ModelRenderer SeatRight;
	ModelRenderer SeatLeft;
	ModelRenderer SeatBottomBack;
	ModelRenderer BackAxel;
	ModelRenderer WheelBackLeft;
	ModelRenderer WheelBackLeftPopout;
	ModelRenderer WheelBackLeftTop;
	ModelRenderer WheelBackLeftFront;
	ModelRenderer WheelBackLeftBottom;
	ModelRenderer WheelBackLeftBack;
	ModelRenderer WheelBackRight;
	ModelRenderer WheelBackRightPopout;
	ModelRenderer WheelBackRightTop;
	ModelRenderer WheelBackRightFront;
	ModelRenderer WheelBackRightBack;
	ModelRenderer WheelBackRightBottom;
	ModelRenderer Right;
	ModelRenderer RightPopout;
	ModelRenderer LeftPopout;
	ModelRenderer WheelFrontLeft;
	ModelRenderer Bottom;
	ModelRenderer WheelLeftTop;
	ModelRenderer WheelLeftBack;
	ModelRenderer WheelLeftFront;
	ModelRenderer WheelLeftBottom;

	public ModelMongoose()
	{
		textureWidth = 256;
		textureHeight = 128;

		Left = new ModelRenderer(this, 80, 0);
		Left.addBox(0F, 0F, 0F, 1, 12, 24);
		Left.setRotationPoint(7F, 7F, -10F);
		Left.setTextureSize(256, 128);
		Left.mirror = true;
		setRotation(Left, 0F, 0F, 0F);
		Front = new ModelRenderer(this, 20, 80);
		Front.addBox(0F, 0F, 0F, 14, 12, 1);
		Front.setRotationPoint(-7F, 7F, -11F);
		Front.setTextureSize(256, 128);
		Front.mirror = true;
		setRotation(Front, 0F, 0F, 0F);
		WheelLeftPopout = new ModelRenderer(this, 200, 0);
		WheelLeftPopout.addBox(0F, 0F, 0F, 1, 4, 4);
		WheelLeftPopout.setRotationPoint(10F, 18F, -7F);
		WheelLeftPopout.setTextureSize(256, 128);
		WheelLeftPopout.mirror = true;
		setRotation(WheelLeftPopout, 0F, 0F, 0F);
		AxelFront = new ModelRenderer(this, 120, 100);
		AxelFront.addBox(0F, 0F, 0F, 17, 1, 1);
		AxelFront.setRotationPoint(-8F, 20F, -6F);
		AxelFront.setTextureSize(256, 128);
		AxelFront.mirror = true;
		setRotation(AxelFront, 0F, 0F, 0F);
		Back = new ModelRenderer(this, 20, 40);
		Back.addBox(0F, 0F, 0F, 14, 12, 1);
		Back.setRotationPoint(-7F, 7F, 14F);
		Back.setTextureSize(256, 128);
		Back.mirror = true;
		setRotation(Back, 0F, 0F, 0F);
		WheelRight = new ModelRenderer(this, 200, 40);
		WheelRight.addBox(0F, 0F, 0F, 1, 6, 6);
		WheelRight.setRotationPoint(-10F, 17F, -7F);
		WheelRight.setTextureSize(256, 128);
		WheelRight.mirror = true;
		setRotation(WheelRight, 0F, 0F, 0F);
		WheelRightPopout = new ModelRenderer(this, 200, 0);
		WheelRightPopout.addBox(0F, 0F, 0F, 1, 4, 4);
		WheelRightPopout.setRotationPoint(-11F, 18F, -6F);
		WheelRightPopout.setTextureSize(256, 128);
		WheelRightPopout.mirror = true;
		setRotation(WheelRightPopout, 0F, 0F, 0F);
		WheelRightTop = new ModelRenderer(this, 20, 100);
		WheelRightTop.addBox(0F, 0F, 0F, 1, 1, 4);
		WheelRightTop.setRotationPoint(-10F, 16F, -6F);
		WheelRightTop.setTextureSize(256, 128);
		WheelRightTop.mirror = true;
		setRotation(WheelRightTop, 0F, 0F, 0F);
		WheelRightBack = new ModelRenderer(this, 40, 100);
		WheelRightBack.addBox(0F, 0F, 0F, 1, 4, 1);
		WheelRightBack.setRotationPoint(-10F, 18F, -1F);
		WheelRightBack.setTextureSize(256, 128);
		WheelRightBack.mirror = true;
		setRotation(WheelRightBack, 0F, 0F, 0F);
		WheelRightFront = new ModelRenderer(this, 40, 100);
		WheelRightFront.addBox(0F, 0F, 0F, 1, 4, 1);
		WheelRightFront.setRotationPoint(-10F, 18F, -8F);
		WheelRightFront.setTextureSize(256, 128);
		WheelRightFront.mirror = true;
		setRotation(WheelRightFront, 0F, 0F, 0F);
		WheelRightBottom = new ModelRenderer(this, 20, 100);
		WheelRightBottom.addBox(0F, 0F, 0F, 1, 1, 4);
		WheelRightBottom.setRotationPoint(-10F, 23F, -6F);
		WheelRightBottom.setTextureSize(256, 128);
		WheelRightBottom.mirror = true;
		setRotation(WheelRightBottom, 0F, 0F, 0F);
		Windscreen = new ModelRenderer(this, 80, 100);
		Windscreen.addBox(0F, 0F, 0F, 14, 6, 1);
		Windscreen.setRotationPoint(-7F, 2F, -7F);
		Windscreen.setTextureSize(256, 128);
		Windscreen.mirror = true;
		setRotation(Windscreen, -0.5576792F, 0F, 0F);
		LightLeft = new ModelRenderer(this, 40, 60);
		LightLeft.addBox(0F, 0F, -2F, 4, 4, 1);
		LightLeft.setRotationPoint(2F, 13F, -10F);
		LightLeft.setTextureSize(256, 128);
		LightLeft.mirror = true;
		setRotation(LightLeft, 0F, 0F, 0F);
		LightRight = new ModelRenderer(this, 40, 60);
		LightRight.addBox(0F, 0F, 0F, 4, 4, 1);
		LightRight.setRotationPoint(-6F, 13F, -12F);
		LightRight.setTextureSize(256, 128);
		LightRight.mirror = true;
		setRotation(LightRight, 0F, 0F, 0F);
		SteeringStem = new ModelRenderer(this, 50, 20);
		SteeringStem.addBox(0F, 0F, 0F, 1, 6, 1);
		SteeringStem.setRotationPoint(0F, 5F, -6F);
		SteeringStem.setTextureSize(256, 128);
		SteeringStem.mirror = true;
		setRotation(SteeringStem, -0.8922867F, 0F, 0F);
		SteeringWheel = new ModelRenderer(this, 50, 33);
		SteeringWheel.addBox(0F, 0F, 0F, 3, 3, 1);
		SteeringWheel.setRotationPoint(-1F, 5F, -7F);
		SteeringWheel.setTextureSize(256, 128);
		SteeringWheel.mirror = true;
		setRotation(SteeringWheel, 0.6320364F, 0F, 0F);
		SeatBottom = new ModelRenderer(this, 140, 0);
		SeatBottom.addBox(0F, 0F, 0F, 14, 1, 10);
		SeatBottom.setRotationPoint(-7F, 18F, -2F);
		SeatBottom.setTextureSize(256, 128);
		SeatBottom.mirror = true;
		setRotation(SeatBottom, 0F, 0F, 0F);
		SeatBack = new ModelRenderer(this, 0, 0);
		SeatBack.addBox(0F, 0F, 0F, 14, 12, 2);
		SeatBack.setRotationPoint(-7F, 7F, 8F);
		SeatBack.setTextureSize(256, 128);
		SeatBack.mirror = true;
		setRotation(SeatBack, 0F, 0F, 0F);
		SeatRight = new ModelRenderer(this, 140, 50);
		SeatRight.addBox(0F, 0F, 0F, 1, 2, 10);
		SeatRight.setRotationPoint(-7F, 16F, -2F);
		SeatRight.setTextureSize(256, 128);
		SeatRight.mirror = true;
		setRotation(SeatRight, 0F, 0F, 0F);
		SeatLeft = new ModelRenderer(this, 140, 50);
		SeatLeft.addBox(0F, 0F, 0F, 1, 2, 10);
		SeatLeft.setRotationPoint(6F, 16F, -2F);
		SeatLeft.setTextureSize(256, 128);
		SeatLeft.mirror = true;
		setRotation(SeatLeft, 0F, 0F, 0F);
		SeatBottomBack = new ModelRenderer(this, 37, 0);
		SeatBottomBack.addBox(0F, 0F, 0F, 14, 2, 1);
		SeatBottomBack.setRotationPoint(-7F, 16F, 7F);
		SeatBottomBack.setTextureSize(256, 128);
		SeatBottomBack.mirror = true;
		setRotation(SeatBottomBack, 0F, 0F, 0F);
		BackAxel = new ModelRenderer(this, 120, 100);
		BackAxel.addBox(0F, 0F, 0F, 18, 1, 1);
		BackAxel.setRotationPoint(-9F, 20F, 8.5F);
		BackAxel.setTextureSize(256, 128);
		BackAxel.mirror = true;
		setRotation(BackAxel, 0F, 0F, 0F);
		WheelBackLeft = new ModelRenderer(this, 200, 40);
		WheelBackLeft.addBox(0F, 0F, 0F, 1, 6, 6);
		WheelBackLeft.setRotationPoint(9F, 17F, 6F);
		WheelBackLeft.setTextureSize(256, 128);
		WheelBackLeft.mirror = true;
		setRotation(WheelBackLeft, 0F, 0F, 0F);
		WheelBackLeftPopout = new ModelRenderer(this, 200, 0);
		WheelBackLeftPopout.addBox(0F, 0F, 0F, 1, 4, 4);
		WheelBackLeftPopout.setRotationPoint(10F, 18F, 7F);
		WheelBackLeftPopout.setTextureSize(256, 128);
		WheelBackLeftPopout.mirror = true;
		setRotation(WheelBackLeftPopout, 0F, 0F, 0F);
		WheelBackLeftTop = new ModelRenderer(this, 20, 100);
		WheelBackLeftTop.addBox(0F, 0F, 0F, 1, 1, 4);
		WheelBackLeftTop.setRotationPoint(9F, 16F, 7F);
		WheelBackLeftTop.setTextureSize(256, 128);
		WheelBackLeftTop.mirror = true;
		setRotation(WheelBackLeftTop, 0F, 0F, 0F);
		WheelBackLeftFront = new ModelRenderer(this, 40, 100);
		WheelBackLeftFront.addBox(0F, 0F, -1F, 1, 4, 1);
		WheelBackLeftFront.setRotationPoint(9F, 18F, 6F);
		WheelBackLeftFront.setTextureSize(256, 128);
		WheelBackLeftFront.mirror = true;
		setRotation(WheelBackLeftFront, 0F, 0F, 0F);
		WheelBackLeftBottom = new ModelRenderer(this, 20, 100);
		WheelBackLeftBottom.addBox(0F, 0F, 0F, 1, 1, 4);
		WheelBackLeftBottom.setRotationPoint(9F, 23F, 7F);
		WheelBackLeftBottom.setTextureSize(256, 128);
		WheelBackLeftBottom.mirror = true;
		setRotation(WheelBackLeftBottom, 0F, 0F, 0F);
		WheelBackLeftBack = new ModelRenderer(this, 40, 100);
		WheelBackLeftBack.addBox(0F, 0F, 0F, 1, 4, 1);
		WheelBackLeftBack.setRotationPoint(9F, 18F, 12F);
		WheelBackLeftBack.setTextureSize(256, 128);
		WheelBackLeftBack.mirror = true;
		setRotation(WheelBackLeftBack, 0F, 0F, 0F);
		WheelBackRight = new ModelRenderer(this, 200, 40);
		WheelBackRight.addBox(0F, 0F, 0F, 1, 6, 6);
		WheelBackRight.setRotationPoint(-10F, 17F, 6F);
		WheelBackRight.setTextureSize(256, 128);
		WheelBackRight.mirror = true;
		setRotation(WheelBackRight, 0F, 0F, 0F);
		WheelBackRightPopout = new ModelRenderer(this, 200, 0);
		WheelBackRightPopout.addBox(0F, 0F, 0F, 1, 4, 4);
		WheelBackRightPopout.setRotationPoint(-11F, 18F, 7F);
		WheelBackRightPopout.setTextureSize(256, 128);
		WheelBackRightPopout.mirror = true;
		setRotation(WheelBackRightPopout, 0F, 0F, 0F);
		WheelBackRightTop = new ModelRenderer(this, 20, 100);
		WheelBackRightTop.addBox(0F, 0F, 0F, 1, 1, 4);
		WheelBackRightTop.setRotationPoint(-10F, 16F, 7F);
		WheelBackRightTop.setTextureSize(256, 128);
		WheelBackRightTop.mirror = true;
		setRotation(WheelBackRightTop, 0F, 0F, 0F);
		WheelBackRightFront = new ModelRenderer(this, 40, 100);
		WheelBackRightFront.addBox(0F, 0F, 0F, 1, 4, 1);
		WheelBackRightFront.setRotationPoint(-10F, 18F, 5F);
		WheelBackRightFront.setTextureSize(256, 128);
		WheelBackRightFront.mirror = true;
		setRotation(WheelBackRightFront, 0F, 0F, 0F);
		WheelBackRightBack = new ModelRenderer(this, 40, 100);
		WheelBackRightBack.addBox(0F, 0F, 0F, 1, 4, 1);
		WheelBackRightBack.setRotationPoint(-10F, 18F, 12F);
		WheelBackRightBack.setTextureSize(256, 128);
		WheelBackRightBack.mirror = true;
		setRotation(WheelBackRightBack, 0F, 0F, 0F);
		WheelBackRightBottom = new ModelRenderer(this, 20, 100);
		WheelBackRightBottom.addBox(0F, 0F, 0F, 1, 1, 4);
		WheelBackRightBottom.setRotationPoint(-10F, 23F, 7F);
		WheelBackRightBottom.setTextureSize(256, 128);
		WheelBackRightBottom.mirror = true;
		setRotation(WheelBackRightBottom, 0F, 0F, 0F);
		Right = new ModelRenderer(this, 80, 0);
		Right.addBox(0F, 0F, 0F, 1, 12, 24);
		Right.setRotationPoint(-8F, 7F, -10F);
		Right.setTextureSize(256, 128);
		Right.mirror = true;
		setRotation(Right, 0F, 0F, 0F);
		RightPopout = new ModelRenderer(this, 80, 50);
		RightPopout.addBox(0F, 0F, 0F, 1, 11, 22);
		RightPopout.setRotationPoint(-9F, 8F, -9F);
		RightPopout.setTextureSize(256, 128);
		RightPopout.mirror = true;
		setRotation(RightPopout, 0F, 0F, 0F);
		LeftPopout = new ModelRenderer(this, 80, 50);
		LeftPopout.addBox(0F, 0F, 0F, 1, 11, 22);
		LeftPopout.setRotationPoint(8F, 8F, -9F);
		LeftPopout.setTextureSize(256, 128);
		LeftPopout.mirror = true;
		setRotation(LeftPopout, 0F, 0F, 0F);
		WheelFrontLeft = new ModelRenderer(this, 200, 40);
		WheelFrontLeft.addBox(0F, 0F, 0F, 1, 6, 6);
		WheelFrontLeft.setRotationPoint(9F, 17F, -8F);
		WheelFrontLeft.setTextureSize(256, 128);
		WheelFrontLeft.mirror = true;
		setRotation(WheelFrontLeft, 0F, 0F, 0F);
		Bottom = new ModelRenderer(this, 150, 70);
		Bottom.addBox(0F, 0F, 0F, 14, 1, 24);
		Bottom.setRotationPoint(-7F, 19F, -10F);
		Bottom.setTextureSize(256, 128);
		Bottom.mirror = true;
		setRotation(Bottom, 0F, 0F, 0F);
		WheelLeftTop = new ModelRenderer(this, 20, 100);
		WheelLeftTop.addBox(0F, 0F, 0F, 1, 1, 4);
		WheelLeftTop.setRotationPoint(9F, 16F, -7F);
		WheelLeftTop.setTextureSize(256, 128);
		WheelLeftTop.mirror = true;
		setRotation(WheelLeftTop, 0F, 0F, 0F);
		WheelLeftBack = new ModelRenderer(this, 40, 100);
		WheelLeftBack.addBox(0F, 0F, 0F, 1, 4, 1);
		WheelLeftBack.setRotationPoint(9F, 18F, -2F);
		WheelLeftBack.setTextureSize(256, 128);
		WheelLeftBack.mirror = true;
		setRotation(WheelLeftBack, 0F, 0F, 0F);
		WheelLeftFront = new ModelRenderer(this, 40, 100);
		WheelLeftFront.addBox(0F, 0F, 0F, 1, 4, 1);
		WheelLeftFront.setRotationPoint(9F, 18F, -9F);
		WheelLeftFront.setTextureSize(256, 128);
		WheelLeftFront.mirror = true;
		setRotation(WheelLeftFront, 0F, 0F, 0F);
		WheelLeftBottom = new ModelRenderer(this, 20, 100);
		WheelLeftBottom.addBox(0F, 0F, 0F, 1, 1, 4);
		WheelLeftBottom.setRotationPoint(9F, 23F, -7F);
		WheelLeftBottom.setTextureSize(256, 128);
		WheelLeftBottom.mirror = true;
		setRotation(WheelLeftBottom, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Left.render(f5);
		Front.render(f5);
		WheelLeftPopout.render(f5);
		AxelFront.render(f5);
		Back.render(f5);
		WheelRight.render(f5);
		WheelRightPopout.render(f5);
		WheelRightTop.render(f5);
		WheelRightBack.render(f5);
		WheelRightFront.render(f5);
		WheelRightBottom.render(f5);
		Windscreen.render(f5);
		LightLeft.render(f5);
		LightRight.render(f5);
		SteeringStem.render(f5);
		SteeringWheel.render(f5);
		SeatBottom.render(f5);
		SeatBack.render(f5);
		SeatRight.render(f5);
		SeatLeft.render(f5);
		SeatBack.render(f5);
		BackAxel.render(f5);
		WheelBackLeft.render(f5);
		WheelBackLeftPopout.render(f5);
		WheelBackLeftTop.render(f5);
		WheelBackLeftFront.render(f5);
		WheelBackLeftBottom.render(f5);
		WheelBackLeftBack.render(f5);
		WheelBackRight.render(f5);
		WheelBackRightPopout.render(f5);
		WheelBackRightTop.render(f5);
		WheelBackRightFront.render(f5);
		WheelBackRightBack.render(f5);
		WheelBackRightBottom.render(f5);
		Right.render(f5);
		RightPopout.render(f5);
		LeftPopout.render(f5);
		WheelFrontLeft.render(f5);
		Bottom.render(f5);
		WheelLeftTop.render(f5);
		WheelLeftBack.render(f5);
		WheelLeftFront.render(f5);
		WheelLeftBottom.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}