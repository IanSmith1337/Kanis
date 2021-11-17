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
	private final ModelPart root;

	public KanisEntityModel(ModelPart modelPartBody) {
		root = modelPartBody.getChild(EntityModelPartNames.BODY);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData md = new ModelData();
		ModelPartData mpd = md.getRoot();
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-2.575F, -10.225F, -5.925F, 5.0F, 3.0F, 12.0F, new Dilation(1.35F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-3.55F, -7.15F, -6.45F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-3.55F, -7.15F, 4.675F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(1.45F, -7.15F, 4.675F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(1.45F, -7.15F, -6.45F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -14.325F, -12.175F, 6.0F, 6.0F, 5.0F, new Dilation(0.2F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-1.9125F, -9.4125F, -15.9625F, 4.0F, 1.0F, 5.0F, new Dilation(-0.1F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-3.9758F, -17.1916F, -10.2839F, 4.0F, 6.0F, 3.0F, new Dilation(-0.8F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-0.2258F, -17.1916F, -10.2839F, 4.0F, 6.0F, 3.0F, new Dilation(-0.8F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-3.9758F, -18.1916F, -10.2839F, 4.0F, 6.0F, 3.0F, new Dilation(-1.0F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-0.2258F, -18.1916F, -10.2839F, 4.0F, 6.0F, 3.0F, new Dilation(-1.0F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-1.9125F, -12.1625F, -15.9625F, 4.0F, 3.0F, 5.0F, new Dilation(-0.1F)), createModelTransform(0.0F, 24.0F, 0.0F, 0, 0, 0));
		mpd.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -7.3257F, -1.1234F, 2.0F, 7.0F, 2.0F, new Dilation(0.01F)), createModelTransform(-0.05F, -8.15F, 5.925F, -1.0036F, 0.0F, 0.0F));
		return TexturedModelData.of(md, 16, 16);
	}
	
	@Override
	public void setAngles(KanisEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}
	
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		ImmutableList.of(this.root).forEach((modelRenderer) -> {
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