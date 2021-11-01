package com.ismith.kanismod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class KanisArmor extends Item {
    public KanisArmor(Settings settings) {
        super(settings);
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		System.out.println("Attempting to use on entity.");
		if (entity instanceof Saddleable && entity.isAlive() && entity instanceof KanisEntity) {
			Saddleable saddleable = (Saddleable)entity;
			System.out.println(!saddleable.isSaddled() && saddleable.canBeSaddled());
			if (!saddleable.isSaddled() && saddleable.canBeSaddled()) {
				if (!user.world.isClient) {
					saddleable.saddle(SoundCategory.NEUTRAL);
					stack.decrement(1);
				}

				return ActionResult.success(user.world.isClient);
			}
		}

		return ActionResult.PASS;
	}
}