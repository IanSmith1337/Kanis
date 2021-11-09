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

public class KanisEntityModel extends EntityModel<KanisEntity> {
	private final ModelPart body;

	public KanisEntityModel(ModelPart modelPart) {
		body = modelPart.getChild(EntityModelPartNames.BODY);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData md = new ModelData();
		ModelPartData mpd = md.getRoot();
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new Dilation(1.35f)), createModelTransform(0.0F, 18.9F, -0.5F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)), createModelTransform(-1.25F, 3.45F, -3.25F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.RIGHT_HIND_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)), createModelTransform(-1.25F, 3.45F, 3.0F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.LEFT_HIND_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)), createModelTransform(1.25F, 3.45F, 3.0F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.LEFT_FRONT_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)), createModelTransform(1.25F, 3.45F, -3.25F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.TAIL, ModelPartBuilder.create().uv(0, 0).cuboid(-0.515F, -9.4062F, 1.0039F, 1.0F, 4.0F, 1.0F, new Dilation(0.05F)), createModelTransform(0.015F, 1.5095F, -7.405F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0376F, -0.3486F, -0.521F, 2.0F, 2.0F, 2.0F, new Dilation(0.35F)), createModelTransform(0.0376F, -2.0514F, -5.979F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.MOUTH, ModelPartBuilder.create().uv(0, 0).cuboid(-0.5376F, 0.6514F, -2.271F, 1.0F, 1.0F, 2.0F, new Dilation(0.175F)), createModelTransform(0.0376F, -2.0514F, -5.979F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-1.4762F, -4.2631F, -5.2371F, 2.0F, 3.0F, 2.0F, new Dilation(-0.65F)), createModelTransform(-0.0226F, 2.5053F, 4.0889F, -0.1745F, 0.0F, -0.0873F));
		mpd.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-0.4047F, -4.282F, -5.2404F, 2.0F, 3.0F, 2.0F, new Dilation(-0.65F)), createModelTransform(-0.0226F, 2.5053F, 4.0889F, -0.1745F, 0.0F, 0.0873F));
		return TexturedModelData.of(md, 16, 16);
	}

	@Override
	public void setAngles(KanisEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
			//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		ImmutableList.of(this.body).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStack, buffer, packedLight, packedOverlay);
		});
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