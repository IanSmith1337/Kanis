package com.ismith.kanismod.mixin;

import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

import com.ismith.kanismod.ModManager;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@org.spongepowered.asm.mixin.Mixin(WolfEntity.class)
public class Mixin {
	@Inject(at = @At("HEAD"), method = "interactMob", cancellable = true)
	private void test(PlayerEntity p, Hand h, CallbackInfoReturnable<Object> returnable) {
		WolfEntity currentEntity = (WolfEntity) (Object) this;
		if (currentEntity.isTamed()) {
			ModManager.LOGGER.info("This is " + currentEntity.getEntityName() + " owned by " +  currentEntity.getOwner());
		}
	}
}