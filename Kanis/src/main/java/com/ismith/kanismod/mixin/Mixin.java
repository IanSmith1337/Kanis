package com.ismith.kanismod.mixin;

import net.minecraft.entity.passive.WolfEntity;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@org.spongepowered.asm.mixin.Mixin(WolfEntity.class)
public class Mixin {
	@Inject(method = "interactMob(Lnet.minecraft.entity.player.PlayerEntityLnet.minecraft.util.Hand)Lnet/minecraft/util/ActionResult", at = @At("TAIL"))
	private void func(CallbackInfo info) {
		System.out.println("Successfully called mixin.");
	}
}
