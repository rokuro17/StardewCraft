package com.stardewcraft.items.tools;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
/**
 *
 *  This class implements the main stats of the copper tool material
 *
 * @author  Gabriel Pizarro, Daniel Monferrer
 * @version 0.0.1
 **/
public class CopperMaterial implements ToolMaterial {
    public static final CopperMaterial INSTANCE = new CopperMaterial();

    /**
     * Method to get the max durability of a copper tool
     * @return int This returns the max durability
     */
    @Override
    public int getDurability() {
        return 190;
    }
    /**
     * Method to get the mining speed multiplier of a tool breaking its appropiate block type
     * @return int This returns the speed multiplier of said tool
     */
    @Override
    public float getMiningSpeedMultiplier() {
        return  5.0f;
    }
    /**
     * Method to get the attack damage bonus of a weapon or tool used as a weapon made of copper
     * @return float This returns the attack bonus multiplier of said weapon
     */
    @Override
    public float getAttackDamage() {
        return 1.0f;
    }
    /**
     * Method to get the mining level of the tool. Currently level 2 (IRON)
     * @return int This returns the mining level of the tool
     */
    @Override
    public int getMiningLevel() {
        return 2;
    }
    /**
     * Method to get the enchantability of the tool, the probability to get better enchants
     * @return int This returns the enchantability of the tool
     */
    @Override
    public int getEnchantability() {
        return 12;
    }/**
     * Method to get the ingredient required for repairing the tool
     * @return Ingredient This returns the Ingredient required for tool reparation
     */
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }
}
