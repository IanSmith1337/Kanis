package com.ismith.kanismod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@net.fabricmc.api.Environment(EnvType.CLIENT)
public class KanisClient implements ClientModInitializer {
    public static final EntityModelLayer KANIS_MODEL = new EntityModelLayer(new Identifier("kanis", "kanisentity"), "main");
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(KanisModManager.KANIS, (context) -> {
            return new KanisEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(KANIS_MODEL, KanisEntityModel::getTexturedModelData);
    }
}
