package com.stardewcraft.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class MaxHeartUp extends StatusEffect {
    public MaxHeartUp() {
        super(StatusEffectCategory.BENEFICIAL, 0xB982D9); // Color in RGB
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we make it return true so that it applies the effect every tick.
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            EntityAttributeInstance maxHealthAttribute = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

            if (maxHealthAttribute != null) {
                double currentMaxHealth = maxHealthAttribute.getValue();
                double newMaxHealth = currentMaxHealth + 0.1; // Increase by 1 heart

                // Set the modified max health
                maxHealthAttribute.setBaseValue(newMaxHealth);
            }
        }
    }
}
