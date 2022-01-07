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
	private static final String rearTip = "rearTip";
	private static final String learTip = "learTip";
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart snout;
	private final ModelPart jaw;
	private final ImmutableList<ModelPart> parts;

	public KanisEntityModel(ModelPart root) {
		this.body = root;
		this.head = this.body.getChild(EntityModelPartNames.HEAD);
		this.tail = this.body.getChild(EntityModelPartNames.TAIL);
		this.snout = this.head.getChild(EntityModelPartNames.MOUTH);
		this.jaw = this.snout.getChild(EntityModelPartNames.JAW);
		this.parts = ImmutableList.of(body, head, tail, snout, jaw);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData md = new ModelData();
		ModelPartData body = md.getRoot();
		body.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, 0F, -6.0F, 5.0F, 3.0F, 12.0F, new Dilation(1.35F)), ModelTransform.NONE);
		ModelPartData rf_leg = body.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.1F, 0.85F, -0.95F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(-2.375F, 2.225F, -5.575F, 0, 0, 0));
		ModelPartData lf_leg = body.addChild(EntityModelPartNames.LEFT_FRONT_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.85F, -0.95F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(2.525F, 2.225F, -5.575F, 0, 0, 0));
		ModelPartData lh_leg = body.addChild(EntityModelPartNames.LEFT_HIND_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 0.85F, -0.825F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(2.525F, 2.225F, 5.425F, 0, 0, 0));
		ModelPartData rh_leg = body.addChild(EntityModelPartNames.RIGHT_HIND_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.1F, 0.85F, -0.825F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(-2.475F, 2.575F, 5.6F, 0, 0, 0));
		ModelPartData tail = body.addChild(EntityModelPartNames.TAIL, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -4.1127F, -0.8543F, 2.0F, 7.0F, 2.0F, new Dilation(0.01F)), createModelTransform(-0.05F, -3.8873F, 6.6043F, -0.959931F, 0.0F, 0.0F));
		ModelPartData head = body.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.5F, -5.5F, 6.0F, 6.0F, 5.0F, new Dilation(0.2F)), createModelTransform(0.075F, -0.6F, -6.75F, 0, 0, 0));
		ModelPartData rear = head.addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.5F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(-0.8F)), createModelTransform(-1.9758F, -4.8666F, -2.1089F, 0, 0, 0)).addChild(rearTip, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(-1.0F)), ModelTransform.NONE);
		ModelPartData lear = head.addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.5F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(-0.8F)), createModelTransform(1.7742F, -4.8666F, -2.1089F, 0, 0, 0)).addChild(learTip, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(-1.0F)), ModelTransform.NONE);
		ModelPartData snout = head.addChild(EntityModelPartNames.MOUTH, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -0.75F, -3.75F, 4.0F, 3.0F, 5.0F, new Dilation(-0.1F)), createModelTransform(0.0875F, -0.5875F, -5.5375F, 0, 0, 0));
		ModelPartData jaw = snout.addChild(EntityModelPartNames.JAW, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 1.0F, -3.5F, 4.0F, 1.0F, 5.0F, new Dilation(-0.1F)), createModelTransform(0.0F, 1.0F, -0.25F, 0, 0, 0));
		return TexturedModelData.of(md, 16, 16);
	}
	
	@Override
	public void animateModel(KanisEntity entity, float f, float g, float h) {
	}
	
	@Override
	public void setAngles(KanisEntity entity, float f, float g, float h, float i, float j){
	}
	
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.translate(0d, 0.85f, 0d);
		this.getParts().forEach((modelRenderer) -> {
			modelRenderer.render(matrixStack, buffer, packedLight, packedOverlay);
		});
	}
	
	private ImmutableList<ModelPart> getParts() {
		return this.parts;
	}

	public static ModelTransform createModelTransform(float px, float py, float pz, float x, float y, float z) {
		return ModelTransform.of(px, py, pz, x, y, z);
	}
}