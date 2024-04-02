package com.stardewcraft.mixin.client;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ExampleItemClient implements ModInitializer {

    public static final Item STARDROP =
            Registry.register(Registries.ITEM, new Identifier("stardewcraft", "stardrop"),
                    new Item(new FabricItemSettings()));

    @Override
    public void onInitialize() {

    }
}
