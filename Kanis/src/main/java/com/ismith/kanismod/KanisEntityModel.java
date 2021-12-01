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
	private final ModelPart rh_leg;
	private final ModelPart lh_leg;
	private final ModelPart rf_leg;
	private final ModelPart lf_leg;
	private final ImmutableList<ModelPart> parts;

	public KanisEntityModel(ModelPart root) {
		this.body = root.getChild(EntityModelPartNames.BODY);
		this.head = root.getChild(EntityModelPartNames.HEAD);
		this.tail = root.getChild(EntityModelPartNames.TAIL);
		this.jaw = this.head.getChild(EntityModelPartNames.JAW);
		this.mouth = this.head.getChild(EntityModelPartNames.MOUTH);
		this.rear = this.head.getChild(EntityModelPartNames.RIGHT_EAR);
		this.lear = this.head.getChild(EntityModelPartNames.LEFT_EAR);
		this.rearTipPart = this.rear.getChild(rearTip);
		this.learTipPart = this.lear.getChild(learTip);
		this.rh_leg = root.getChild(rhLeg);
		this.lh_leg = root.getChild(lhLeg);
		this.rf_leg = root.getChild(rfLeg);
		this.lf_leg = root.getChild(lfLeg);
		this.parts = ImmutableList.of(body, head, tail, jaw, mouth, rear, lear, rearTipPart, learTipPart, rh_leg, lh_leg, rf_leg, lf_leg);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData md = new ModelData();
		ModelPartData body = md.getRoot();
		body = body.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -1.5F, -6.0F, 5.0F, 3.0F, 12.0F, new Dilation(1.35F)), createModelTransform(-0.075F, 15.275F, 0.075F, 0, 0, 0));
		ModelPartData rf_leg = body.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.1F, -0.65F, -0.95F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(-2.45F, -6.5F, -5.5F, 0, 0, 0));
		ModelPartData lf_leg = body.addChild(EntityModelPartNames.LEFT_FRONT_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.65F, -0.95F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(2.45F, -6.5F, -5.5F, 0, 0, 0));
		ModelPartData lb_leg = body.addChild(EntityModelPartNames.LEFT_HIND_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.65F, -0.825F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(2.45F, -6.5F, 5.5F, 0, 0, 0));
		ModelPartData rb_leg = body.addChild(EntityModelPartNames.RIGHT_HIND_LEG, ModelPartBuilder.create().uv(0, 0).cuboid(-1.1F, -0.65F, -0.825F, 2.0F, 7.0F, 2.0F, new Dilation(0.15F)), createModelTransform(-2.45F, -6.5F, 5.5F, 0, 0, 0));
		ModelPartData tail = body.addChild(EntityModelPartNames.TAIL, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -5.6127F, -0.8543F, 2.0F, 7.0F, 2.0F, new Dilation(0.01F)), createModelTransform(0.0F, -0.5F, 0.25F, -1.0472F, 0.0F, 0.0F));
		ModelPartData head = body.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -5.0F, -5.5F, 6.0F, 6.0F, 5.0F, new Dilation(0.2F)), createModelTransform(0.075F, -0.6F, -6.75F, 0, 0, 0));
		ModelPartData rear = head.addChild(EntityModelPartNames.RIGHT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(-0.8F)), createModelTransform(-1.9758F, -4.8666F, -2.1089F, 0, 0, 0));
		rear.addChild(rearTip, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(-1.0F)), createModelTransform(0, 0, 0, 0, 0, 0));
		ModelPartData lear = head.addChild(EntityModelPartNames.LEFT_EAR, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -3.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(-0.8F)), createModelTransform(1.7742F, -4.8666F, -2.1089F, 0, 0, 0));
		lear.addChild(learTip, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -4.0F, -1.5F, 4.0F, 4.0F, 3.0F, new Dilation(-1.0F)), createModelTransform(0, 0, 0, 0, 0, 0));
		ModelPartData snout = head.addChild(EntityModelPartNames.MOUTH, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -2.25F, -3.75F, 4.0F, 3.0F, 5.0F, new Dilation(-0.1F)), createModelTransform(0.0875F, -0.5875F, -5.5375F, 0, 0, 0));
		ModelPartData Jaw = snout.addChild(EntityModelPartNames.JAW, ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -0.5F, -3.5F, 4.0F, 1.0F, 5.0F, new Dilation(-0.1F)), createModelTransform(0.0F, 1.0F, -0.25F, 0, 0, 0));
		return TexturedModelData.of(md, 16, 16);
	}
	
	@Override
	public void animateModel(KanisEntity entity, float f, float g, float h) {
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