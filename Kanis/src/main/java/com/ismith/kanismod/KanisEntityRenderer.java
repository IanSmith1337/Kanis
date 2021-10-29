package com.ismith.kanismod;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class KanisEntityRenderer<T extends Entity> extends EntityRenderer<KanisEntity> {

    public KanisEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(KanisEntity entity) {
        return new Identifier("kanisentity", "src/main/resources/assets/kanis/kanis.png");
    }
    
}
