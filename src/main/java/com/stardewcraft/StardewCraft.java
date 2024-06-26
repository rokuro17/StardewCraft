package com.stardewcraft;

import com.stardewcraft.blockentities.SafeBoxBlockEntity;
import com.stardewcraft.effects.MaxHeartUp;


import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 *  This class implements the main features of the mod
 *
 * @author  Gabriel Pizarro, Daniel Monferrer
 * @version 0.0.1
 **/
public class StardewCraft implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("stardewcraft");
	public static final StatusEffect MAXHEARTUP_EFFECT = new MaxHeartUp();

	static StatusEffectInstance MaxHeartUpInstance = new StatusEffectInstance(MAXHEARTUP_EFFECT, 20, 0);

	public static final Item STARDROP =
			Registry.register(Registries.ITEM, new Identifier("stardewcraft", "stardrop"),
					new Item(new FabricItemSettings()
							.maxCount(1)
							.food(new FoodComponent.Builder()
									.alwaysEdible().hunger(10)
									.saturationModifier(0.5f)
									.statusEffect(MaxHeartUpInstance, 1.0f)
									.build())));

	public static final Item PARSNIP =
			Registry.register(Registries.ITEM, new Identifier("stardewcraft", "parsnip"),
					new Item(new FabricItemSettings()
							.maxCount(64)
							.food(new FoodComponent.Builder()
									.hunger(2)
									.saturationModifier(0.1f)
									.build())));

	public static final Block SAFE_BOX_BLOCK  = new Block(FabricBlockSettings.create().strength(4.0f));
	public static final BlockEntityType<SafeBoxBlockEntity> SAFE_BOX_BLOCK_ENTITY =
			Registry.register(Registries.BLOCK_ENTITY_TYPE,
					new Identifier("stardewcraft", "safe_box_block_entity"),
					FabricBlockEntityTypeBuilder.create(SafeBoxBlockEntity::new, StardewCraft.SAFE_BOX_BLOCK).build());

	public static final RegistryKey<ItemGroup> STARDEWCRAFT =
			RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier("stardewcraft", "stardewcraft"));

	public static final CropBlock PARSNIP_CROP = new CropBlock(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item PARSNIP_SEEDS = new AliasedBlockItem(PARSNIP_CROP, new Item.Settings());



	//Register zone of tools
	public static final Item COPPER_PICKAXE =
			Registry.register(Registries.ITEM, new Identifier("stardewcraft", "copper_pickaxe"),
					new Item(new FabricItemSettings()));
	public static final Item COPPER_AXE =
			Registry.register(Registries.ITEM, new Identifier("stardewcraft", "copper_axe"),
					new Item(new FabricItemSettings()));
	public static final Item COPPER_HOE =
			Registry.register(Registries.ITEM, new Identifier("stardewcraft", "copper_hoe"),
					new Item(new FabricItemSettings()));
	/**
	 * Method that regulates the behavior of the mod on initialization
	 */
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//Register of custom Item Group for the mod
		Registry.register(Registries.ITEM_GROUP, STARDEWCRAFT, FabricItemGroup.builder()
				.icon(() -> new ItemStack(STARDROP))
				.displayName(Text.translatable("StardewCraft"))
						.entries(((displayContext, entries) -> {
							entries.add(STARDROP);
							entries.add(PARSNIP);
							entries.add(PARSNIP_SEEDS);
						}))
				.build()); // build() no longer registers by itself

		LOGGER.info("StardewCraft");

		//Register zone of effects
		Registry.register(Registries.STATUS_EFFECT, new Identifier("stardewcraft", "max_heart_up"), MAXHEARTUP_EFFECT);

		//Register zone of crops
		Registry.register(Registries.BLOCK, new Identifier("stardewcraft","parsnip_crop"), PARSNIP_CROP);
		Registry.register(Registries.ITEM, new Identifier("stardewcraft","parsnip_seeds"), PARSNIP_SEEDS);


		Registry.register(Registries.BLOCK, new Identifier("stardewcraft", "safe_box_block"), SAFE_BOX_BLOCK);
	}
}