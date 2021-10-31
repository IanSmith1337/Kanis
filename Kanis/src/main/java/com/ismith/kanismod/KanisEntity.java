package com.ismith.kanismod;

import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemSteerable;
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
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class KanisEntity extends WolfEntity implements ItemSteerable, Saddleable {
    private static final TrackedData<Boolean> SADDLED;
    private static final TrackedData<Integer> BOOST_TIME;
    private final SaddledComponent saddledComponent;

    public KanisEntity(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
		this.stepHeight = 1.0F;
        this.saddledComponent = new SaddledComponent(this.dataTracker, BOOST_TIME, SADDLED);
    }

    @Nullable
	public Entity getPrimaryPassenger() {
		return this.getFirstPassenger();
	}

    public static DefaultAttributeContainer.Builder createKanisAttributes() {
        return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32).add(EntityAttributes.GENERIC_MAX_HEALTH, 50).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6f).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK);
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
        boolean interaction = itemStack.isOf(KanisModManager.Kanis_Weapon) && this.isTamed() && !this.hasAngerTime();
		if (interaction && this.isSaddled() && !this.hasPassengers() && !player.shouldCancelInteraction()) {
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
        return this.isAlive();
    }

    @Override
    public void saddle(SoundCategory sound) {
        this.saddledComponent.setSaddled(true);
		if (sound != null) {
			this.world.playSoundFromEntity((PlayerEntity)null, this, SoundEvents.ENTITY_HORSE_SADDLE, sound, 0.5F, 1.0F);
		}
		System.out.println("Saddled Successfully.");
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

    public void travel(Vec3d movementInput) {
		if (this.hasPassengers() && this.canBeControlledByRider() && this.isSaddled()) {
			LivingEntity livingEntity = (LivingEntity)this.getPrimaryPassenger();
			this.setYaw(livingEntity.getYaw());
			this.prevYaw = this.getYaw();
			this.setPitch(livingEntity.getPitch() * 0.5F);
			this.setRotation(this.getYaw(), this.getPitch());
			this.bodyYaw = this.getYaw();
			this.headYaw = this.bodyYaw;
			float f = livingEntity.sidewaysSpeed * 0.5F;
			float g = livingEntity.forwardSpeed;

			if (g <= 0.0F) {
				g *= 0.25F;
			}

			this.flyingSpeed = this.getMovementSpeed() * 0.1F;
			if (this.isLogicalSideForUpdatingMovement()) {
				this.setMovementSpeed((float)this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED));
				super.travel(new Vec3d((double)f, movementInput.y, (double)g));
			} else if (livingEntity instanceof PlayerEntity) {
				this.setVelocity(Vec3d.ZERO);
			}
		}
	}
    
    public void setMovementInput(Vec3d movementInput) {
		super.travel(movementInput);
	}

    static {
		SADDLED = DataTracker.registerData(KanisEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
		BOOST_TIME = DataTracker.registerData(KanisEntity.class, TrackedDataHandlerRegistry.INTEGER);
	}

	@Override
	public boolean consumeOnAStickItem() {
		return this.saddledComponent.boost(this.getRandom());
	}

	@Override
	protected void dropInventory() {
		super.dropInventory();
		if (this.isSaddled()) {
			this.dropItem(KanisModManager.Kanis_Armor);
		}
	}
}
