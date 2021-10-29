package com.ismith.kanismod.mixin;

import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import com.ismith.kanismod.KanisEntity;
import com.ismith.kanismod.KanisModManager;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@org.spongepowered.asm.mixin.Mixin(WolfEntity.class)
public class Mixin {
	@Inject(at = @At("HEAD"), method = "interactMob", cancellable = true)
	private void test(PlayerEntity p, Hand h, CallbackInfoReturnable<Object> returnable) {
		WolfEntity currentEntity = (WolfEntity) (Object) this;
		World world = currentEntity.world;
		if (currentEntity.isTamed() && !world.isClient) {
			KanisEntity e = new KanisEntity(KanisModManager.KANIS, world);
			e.setTamed(true);
			e.setOwner(p);
			e.setSitting(true);
			e.setHealth(50);
			currentEntity.discard();
			world.spawnEntity(e);
		}
	}
}