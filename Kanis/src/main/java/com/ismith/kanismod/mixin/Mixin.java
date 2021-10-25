package com.ismith.kanismod.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import com.ismith.kanismod.ModManager;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@org.spongepowered.asm.mixin.Mixin(TitleScreen.class)
public class Mixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		ModManager.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
