package com.ismith.kanismod;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class KanisEntityRenderer extends MobEntityRenderer<KanisEntity, KanisEntityModel> {

    public KanisEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new KanisEntityModel(context.getPart(KanisClient.KANIS_MODEL)), 0.5f);
    }

    @Override
    public Identifier getTexture(KanisEntity entity) {
        return new Identifier("kanisentity", "src/main/resources/assets/kanis/kanis.png");
    }
    
}
