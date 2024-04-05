package com.stardewcraft.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
/**
 *
 *  This class implements the status effect for the Stardrop
 *
 * @author  Gabriel Pizarro, Daniel Monferrer
 * @version 0.0.1
 **/
public class MaxHeartUp extends StatusEffect {
    public MaxHeartUp() {
        super(StatusEffectCategory.BENEFICIAL, 0xB982D9); // Color in RGB
    }
    /**
     * Method that returns if the effect continues to be applied
     * @param duration The duration of the effect
     * @param amplifier The level of the effect
     * @return boolean If the effect continues to be applied
     */
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we make it return true so that it applies the effect every tick.
        return true;
    }
    /**
     * Method that applies again the effect
     * @param entity The object of the effect, mob or player
     * @param amplifier The level of the effect
     */
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
