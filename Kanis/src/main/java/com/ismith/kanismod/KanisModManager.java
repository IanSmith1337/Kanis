package com.ismith.kanismod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder ;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KanisModManager implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("kanis");
    public static final EntityType<KanisEntity> KANIS = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("kanis", "kanisentity"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, KanisEntity::new).dimensions(EntityDimensions.fixed(1.275f, 0.9f)).build()
		);
	public static final Item Kanis_Armor = new KanisArmor(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item Kanis_Treat = new KanisTreat(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item Kanis_Weapon = (Item)(new KanisWeapon(new FabricItemSettings().maxDamage(3000), KanisModManager.KANIS, 1));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Arf! Woof! Arf! Starting up!");
		Registry.register(Registry.ITEM, new Identifier("kanis", "kanis_armor"), Kanis_Armor);
		Registry.register(Registry.ITEM, new Identifier("kanis", "kanis_treat"), Kanis_Treat);
		Registry.register(Registry.ITEM, new Identifier("kanis", "kanis_weapon"), Kanis_Weapon);
		FabricDefaultAttributeRegistry.register(KANIS, KanisEntity.createKanisAttributes());

		WolfToKanisCallback.EVENT.register((PlayerEntity player, WolfEntity wolf) -> {
			if(!(wolf instanceof KanisEntity)) {
				KanisEntity e = KanisModManager.KANIS.create(wolf.world);
				e.setTamed(true);
				e.setOwner(player);
				e.setPosition(wolf.getPos());
				e.setSitting(true);
				e.world.spawnEntity(e);
				wolf.discard();
			}
			return ActionResult.PASS;
		});
	}
}
