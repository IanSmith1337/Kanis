package com.ismith.kanismod.mixin;

import com.ismith.kanismod.KanisArmor;
import com.ismith.kanismod.WolfToKanisCallback;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

@org.spongepowered.asm.mixin.Mixin(WolfEntity.class)
public class WolfToKanisMixin {
	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/WolfEntity;isTamed()V"), method = "interactMob", cancellable = true)
	private void transform(final PlayerEntity p, final Hand h, ItemStack itemStack, Item item, CallbackInfoReturnable<Object> returnable) {
		if(item instanceof KanisTreat) {
			ActionResult result = WolfToKanisCallback.EVENT.invoker().interact(p, (WolfEntity) (Object) this);
	
			if(result == ActionResult.FAIL) {
				returnable.cancel();
			}
		}
	}
}