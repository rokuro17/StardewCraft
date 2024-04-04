package com.stardewcraft;

import com.stardewcraft.effects.MaxHeartUp;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("stardewcraft");
	public static final StatusEffect MAXHEARTUP_EFFECT = new MaxHeartUp();

	static StatusEffectInstance MaxHeartUpInstance = new StatusEffectInstance(MAXHEARTUP_EFFECT, 20, 0);

	public static final Item STARDROP =
			Registry.register(Registries.ITEM, new Identifier("stardewcraft", "stardrop"),
					new Item(new FabricItemSettings().maxCount(13).food(new FoodComponent.Builder().alwaysEdible().hunger(10).saturationModifier(0.5f).statusEffect(MaxHeartUpInstance, 1.0f).build())));

	public static final RegistryKey<ItemGroup> STARDEWCRAFT =
			RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("stardewcraft", "stardewcraft"));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM_GROUP, STARDEWCRAFT, FabricItemGroup.builder()
				.icon(() -> new ItemStack(STARDROP))
				.displayName(Text.translatable("StardewCraft"))
						.entries(((displayContext, entries) -> {
							entries.add(STARDROP);
						}))
				.build()); // build() no longer registers by itself

		LOGGER.info("Hello Fabric world!");

		Registry.register(Registries.STATUS_EFFECT, new Identifier("stardewcraft", "heartboosteffect"), MAXHEARTUP_EFFECT);
	}
}