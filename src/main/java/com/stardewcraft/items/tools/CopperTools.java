package com.stardewcraft.items.tools;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 *
 *  This class implements the stats of the different types of copper tools
 *
 * @author  Gabriel Pizarro, Daniel Monferrer
 * @version 0.0.1
 **/
public class CopperTools {

    public static ToolItem COPPER_PICKAXE = new PickaxeItem(CopperMaterial.INSTANCE, 1, -2.8F, new FabricItemSettings());
    public static ToolItem COPPER_AXE = new AxeItem(CopperMaterial.INSTANCE, 7.0F, -3.2F, new FabricItemSettings());
    public static ToolItem COPPER_HOE = new HoeItem(CopperMaterial.INSTANCE, 7, -3.2F, new FabricItemSettings());
    public static ToolItem COPPER_SHOVEL = new ShovelItem(CopperMaterial.INSTANCE, 4, -3F, new FabricItemSettings());

}

