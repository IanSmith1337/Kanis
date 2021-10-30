package com.ismith.kanismod;

import net.minecraft.entity.EntityType;
import net.minecraft.item.OnAStickItem;

public class KanisWeapon extends OnAStickItem<KanisEntity> {
    public KanisWeapon(Settings settings, EntityType<KanisEntity> target, int damagePerUse) {
        super(settings, target, damagePerUse);
    }
}
