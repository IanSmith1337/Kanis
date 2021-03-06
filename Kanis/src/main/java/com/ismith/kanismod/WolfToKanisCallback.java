package com.ismith.kanismod;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public interface WolfToKanisCallback {
     
    Event<WolfToKanisCallback> EVENT = EventFactory.createArrayBacked(WolfToKanisCallback.class,
        (listeners) -> (player, wolf) -> {
            for (WolfToKanisCallback listener : listeners) {
                ActionResult result = listener.interact(player, wolf);
 
                if(result != ActionResult.PASS) {
                    return result;
                }
            }
 
        return ActionResult.PASS;
    });
 
    ActionResult interact(PlayerEntity player, WolfEntity wolf);
}
