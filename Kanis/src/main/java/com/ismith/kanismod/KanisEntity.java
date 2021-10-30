package com.ismith.kanismod;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.SaddledComponent;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class KanisEntity extends WolfEntity implements Saddleable {
    private static final TrackedData<Boolean> SADDLED;
    private static final TrackedData<Integer> BOOST_TIME;
    private final SaddledComponent saddledComponent;

    public KanisEntity(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
        this.saddledComponent = new SaddledComponent(this.dataTracker, BOOST_TIME, SADDLED);
    }

    @Nullable
	public Entity getPrimaryPassenger() {
		return this.getFirstPassenger();
	}

    public static DefaultAttributeContainer.Builder createKanisAttributes() {
        return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 200).add(EntityAttributes.GENERIC_MAX_HEALTH, 50).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6f).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK);
    }

	public boolean canBeControlledByRider() {
		Entity entity = this.getPrimaryPassenger();
		if (!(entity instanceof PlayerEntity)) {
			return false;
		} else {
			PlayerEntity playerEntity = (PlayerEntity)entity;
			return playerEntity.getMainHandStack().isOf(KanisModManager.Kanis_Weapon)|| playerEntity.getOffHandStack().isOf(KanisModManager.Kanis_Weapon);
		}
	}

	public void onTrackedDataSet(TrackedData<?> data) {
		if (BOOST_TIME.equals(data) && this.world.isClient) {
			this.saddledComponent.boost();
		}

		super.onTrackedDataSet(data);
	}

    protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SADDLED, false);
		this.dataTracker.startTracking(BOOST_TIME, 0);
	}

    public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		this.saddledComponent.writeNbt(nbt);
	}

	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.saddledComponent.readNbt(nbt);
	}

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        super.interactMob(player, hand);
        ItemStack itemStack = player.getStackInHand(hand);
        boolean bl = !itemStack.isOf(Items.BONE) && this.isTamed() && !this.hasAngerTime();
		if (!bl && this.isSaddled() && !this.hasPassengers() && !player.shouldCancelInteraction()) {
			if (!this.world.isClient) {
				player.startRiding(this);
			}

			return ActionResult.success(this.world.isClient);
		} else {
			ActionResult actionResult = super.interactMob(player, hand);
			if (!actionResult.isAccepted()) {
				itemStack = player.getStackInHand(hand);
				return itemStack.isOf(KanisModManager.Kanis_Armor) ? itemStack.useOnEntity(player, this, hand) : ActionResult.PASS;
			} else {
				return actionResult;
			}
		}
	}

    @Override
    public boolean canBeSaddled() {
        return this.isAlive() && !this.isBaby();
    }

    @Override
    public void saddle(SoundCategory sound) {
        this.saddledComponent.setSaddled(true);
		if (sound != null) {
			this.world.playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ENTITY_HORSE_SADDLE, sound, 0.5F, 1.0F);
		}

    }


    public float getSaddledSpeed() {
		return (float)this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED) * 0.4F;
	}

    @Override
    public boolean isSaddled() {
        return this.saddledComponent.isSaddled();
    }
    
    public Vec3d updatePassengerForDismount(LivingEntity passenger) {
        return super.updatePassengerForDismount(passenger);
    }

    public void travel(KanisEntity kanisEntity, SaddledComponent saddledComponent, Vec3d movementInput) {
		this.travel(this, this.saddledComponent, movementInput);
	}
    
    public void setMovementInput(Vec3d movementInput) {
		super.travel(movementInput);
	}

    static {
		SADDLED = DataTracker.registerData(KanisEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
		BOOST_TIME = DataTracker.registerData(KanisEntity.class, TrackedDataHandlerRegistry.INTEGER);
	}
}
