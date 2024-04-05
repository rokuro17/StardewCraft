package com.stardewcraft.items.tools;
import com.stardewcraft.items.tools.CopperMaterial;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CopperTools {

    public static ToolItem COPPER_PICKAXE = new PickaxeItem(CopperMaterial.INSTANCE, 4, -2.8F, new FabricItemSettings());
    public static ToolItem COPPER_AXE = new AxeItem(CopperMaterial.INSTANCE, 7.0F, -3.2F, new FabricItemSettings());
    public static ToolItem COPPER_HOE = new HoeItem(CopperMaterial.INSTANCE, 7, -3.2F, new FabricItemSettings());

}
