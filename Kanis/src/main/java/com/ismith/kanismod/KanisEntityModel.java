// Made with Blockbench 4.0.1

package com.ismith.kanismod;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class KanisEntityModel extends EntityModel<KanisEntity> {
	private static final String rhLeg = "rhLeg";
	private static final String lhLeg = "lhLeg";
	private static final String rfLeg = "rfLeg";
	private static final String lfLeg = "lfLeg";
	private static final String rearTip = "rearTip";
	private static final String learTip = "learTip";
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart jaw;
	private final ModelPart mouth;
	private final ModelPart rear;
	private final ModelPart lear;
	private final ModelPart rearTipPart;
	private final ModelPart learTipPart;
	private final ModelPart rhLegPart;
	private final ModelPart lhLegPart;
	private final ModelPart rfLegPart;
	private final ModelPart lfLegPart;
	private final ImmutableList<ModelPart> parts;

	public KanisEntityModel(ModelPart root) {
		this.body = root.getChild(EntityModelPartNames.BODY);
		this.head = root.getChild(EntityModelPartNames.HEAD);
		this.tail = root.getChild(EntityModelPartNames.TAIL);
		this.jaw = head.getChild(EntityModelPartNames.JAW);
		this.mouth = head.getChild(EntityModelPartNames.MOUTH);
		this.rear = head.getChild(EntityModelPartNames.RIGHT_EAR);
		this.lear = head.getChild(EntityModelPartNames.LEFT_EAR);
		this.rearTipPart = rear.getChild(rearTip);
		this.learTipPart = lear.getChild(learTip);
		this.rhLegPart = root.getChild(rhLeg);
		this.lhLegPart = root.getChild(lhLeg);
		this.rfLegPart = root.getChild(rfLeg);
		this.lfLegPart = root.getChild(lfLeg);
		this.parts = ImmutableList.of(body, head, tail, jaw, mouth, rear, lear, rearTipPart, learTipPart, rhLegPart, lhLegPart, rfLegPart, lfLegPart);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData md = new ModelData();
		ModelPartData mpd = md.getRoot();
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-2.575F, -10.225F, -5.925F, 5.0F, 3.0F, 12.0F, new Dilation(1.35F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(lfLeg, ModelPartBuilder.create().uv(0, 0).cuboid(-3.55F, -7.15F, -6.45F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(lhLeg, ModelPartBuilder.create().uv(0, 0).cuboid(-3.55F, -7.15F, 4.675F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(rhLeg, ModelPartBuilder.create().uv(0, 0).cuboid(1.45F, -7.15F, 4.675F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(rfLeg, ModelPartBuilder.create().uv(0, 0).cuboid(1.45F, -7.15F, -6.45F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		ModelPartData mpd2 = mpd.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -14.325F, -12.175F, 6.0F, 6.0F, 5.0F, new Dilation(0.2F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd2.addChild(EntityModelPartNames.JAW, ModelPartBuilder.create().uv(0, 0).cuboid(-1.9125F, -9.4125F, -15.9625F, 4.0F, 1.0F, 5.0F, new Dilation(-0.1F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd2.addChild(EntityModelPartNames.MOUTH, ModelPartBuilder.create().uv(0, 0).cuboid(-3.9758F, -17.1916F, -10.2839F, 4.0F, 6.0F, 3.0F, new Dilation(-0.8F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		ModelPartData mpd3 = mpd2.addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-0.2258F, -17.1916F, -10.2839F, 4.0F, 6.0F, 3.0F, new Dilation(-0.8F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		ModelPartData mpd4 = mpd2.addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-3.9758F, -18.1916F, -10.2839F, 4.0F, 6.0F, 3.0F, new Dilation(-1.0F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd3.addChild(rearTip, ModelPartBuilder.create().uv(0, 0).cuboid(-0.2258F, -18.1916F, -10.2839F, 4.0F, 6.0F, 3.0F, new Dilation(-1.0F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd4.addChild(learTip, ModelPartBuilder.create().uv(0, 0).cuboid(-1.9125F, -12.1625F, -15.9625F, 4.0F, 3.0F, 5.0F, new Dilation(-0.1F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.TAIL, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -7.3257F, -1.1234F, 2.0F, 7.0F, 2.0F, new Dilation(0.01F)), createModelTransform(-0.05F, -8.15F, 5.925F, -1.0036F, 0.0F, 0.0F));
		return TexturedModelData.of(md, 16, 16);
	}
	
	@Override
	public void animateModel(KanisEntity entity, float f, float g, float h) {
		if (entity.hasAngerTime()) {
			this.tail.yaw = 0.0F;
		} else {
			this.tail.yaw = MathHelper.cos(f * 0.6662F) * 1.4F * g;
		}

		if (entity.isInSittingPose()) {
			this.head.pitch = 1.2566371F;
			this.head.yaw = 0.0F;
			this.body.pitch = 0.7853982F;
			this.rhLegPart.pitch = 4.712389F;
			this.lhLegPart.pitch = 4.712389F;
			this.rfLegPart.pitch = 5.811947F;
			this.lfLegPart.pitch = 5.811947F;
		} else {
			this.body.pitch = 1.5707964F;
			this.head.pitch = this.body.pitch;
			this.rhLegPart.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g;
			this.lhLegPart.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g;
			this.rfLegPart.pitch = MathHelper.cos(f * 0.6662F + 3.1415927F) * 1.4F * g;
			this.lfLegPart.pitch = MathHelper.cos(f * 0.6662F) * 1.4F * g;
		}

		this.head.roll = entity.getBegAnimationProgress(h) + entity.getShakeAnimationProgress(h, 0.0F);
		this.head.roll = entity.getShakeAnimationProgress(h, -0.08F);
		this.body.roll = entity.getShakeAnimationProgress(h, -0.16F);
		this.tail.roll = entity.getShakeAnimationProgress(h, -0.2F);
	}
	
	@Override
	public void setAngles(KanisEntity entity, float f, float g, float h, float i, float j){
		this.head.pitch = j * 0.017453292F;
		this.head.yaw = i * 0.017453292F;
		this.tail.pitch = h;
	}
	
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		this.getParts().forEach((modelRenderer) -> {
			modelRenderer.render(matrixStack, buffer, packedLight, packedOverlay);
		});
	}
	
	private ImmutableList<ModelPart> getParts() {
		return this.parts;
	}

	public static ModelTransform createModelTransform(float pivotX, float pivotY, float pivotZ, float pitch, float yaw, float roll) {
		float px = pivotX;
		float py = pivotY;
		float pz = pivotZ;
		float x = pitch;
		float y = yaw;
		float z = roll;
		return ModelTransform.of(px, py, pz, x, y, z);
	}
}