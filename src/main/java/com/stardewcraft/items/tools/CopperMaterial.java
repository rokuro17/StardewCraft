package com.stardewcraft.items.tools;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CopperMaterial implements ToolMaterial {

    public static final CopperMaterial INSTANCE = new CopperMaterial();

    @Override
    public int getDurability() {
        return 190;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return  5.0f;
    }
    @Override
    public float getAttackDamage() {
        return 0.0f;
    }
    @Override
    public int getMiningLevel() {
        return 2;
    }
    @Override
    public int getEnchantability() {
        return 15;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }
}
