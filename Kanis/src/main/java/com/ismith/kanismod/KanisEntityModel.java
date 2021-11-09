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

	public KanisEntityModel(ModelPart modelPartBody) {
		body = modelPartBody.getChild(EntityModelPartNames.BODY);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData md = new ModelData();
		ModelPartData mpd = md.getRoot();
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -5.6F, -3.5F, 1.0F, 1.0F, 6.0F, new Dilation(1.35f)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.75F, -3.15F, -4.25F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.RIGHT_HIND_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.75F, -3.15F, 2.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.LEFT_HIND_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(0.75F, -3.15F, 2.0F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.LEFT_FRONT_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(0.75F, -3.15F, -4.25F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.TAIL, ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.05F)), createModelTransform(0.0F, -6.1556F, 5.0149F, -1.1694F, 0.0F, 0.0F));
		mpd.getChild(EntityModelPartNames.BODY).addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -7.5F, -7.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.35F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.MOUTH, ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -6.5F, -8.75F, 1.0F, 1.0F, 2.0F, new Dilation(0.175F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.getChild(EntityModelPartNames.BODY).getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(-0.65F)), createModelTransform(0.9111F, -8.0571F, -6.083F, -0.1745F, 0.0F, -0.0873F));
		mpd.getChild(EntityModelPartNames.BODY).getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(-0.65F)), createModelTransform(-0.7607F, -8.0484F, -6.083F, -0.1745F, 0.0F, 0.0873F));
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