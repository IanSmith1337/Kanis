package com.ismith.kanismod.mixin;

import com.ismith.kanismod.WolfTameCallback;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

@org.spongepowered.asm.mixin.Mixin(WolfEntity.class)
public class WolfTameMixin {
	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/WolfEntity;setSitting(Z)V"), method = "interactMob", cancellable = true)
	private void onTame(final PlayerEntity p, final Hand h, CallbackInfoReturnable<Object> returnable) {
		((WolfEntity) (Object) this).world.sendEntityStatus((WolfEntity) (Object) this, (byte)7);
		ActionResult result = WolfTameCallback.EVENT.invoker().interact(p, (WolfEntity) (Object) this);
 
        if(result == ActionResult.FAIL) {
            returnable.cancel();
        }
	}
}