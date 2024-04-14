package com.stardewcraft;

import com.stardewcraft.blockentities.SeedMakerEntity;
import com.stardewcraft.blocks.ScarecrowBlock;
import com.stardewcraft.blocks.SeedMakerBlock;
import com.stardewcraft.effects.MaxHeartUp;


import com.stardewcraft.items.crops.*;
import com.stardewcraft.items.tools.CopperTools;
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
	public static String MOD_ID = "stardewcraft";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final StatusEffect MAXHEARTUP_EFFECT = new MaxHeartUp();

	static StatusEffectInstance MaxHeartUpInstance = new StatusEffectInstance(MAXHEARTUP_EFFECT, 20, 0);

	public static final Item STARDROP =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "stardrop"),
					new Item(new FabricItemSettings()
							.maxCount(1)
							.food(new FoodComponent.Builder()
									.alwaysEdible().hunger(10)
									.saturationModifier(0.5f)
									.statusEffect(MaxHeartUpInstance, 1.0f)
									.build())));
	public static final Item PARSNIP =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "parsnip"),
					new Item(new FabricItemSettings()
							.maxCount(64)
							.food(new FoodComponent.Builder()
									.hunger(2)
									.saturationModifier(0.1f)
									.build())));
	public static final Item BLUE_JAZZ =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blue_jazz"),
					new Item(new FabricItemSettings()
							.maxCount(64)
							.food(new FoodComponent.Builder()
									.hunger(2)
									.saturationModifier(0.1f)
									.build())));
	public static final Item POTATO =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "potato"),
					new Item(new FabricItemSettings()
							.maxCount(64)
							.food(new FoodComponent.Builder()
									.hunger(2)
									.saturationModifier(0.1f)
									.build())));
	public static final Item CARROT =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "carrot"),
					new Item(new FabricItemSettings()
							.maxCount(64)
							.food(new FoodComponent.Builder()
									.hunger(2)
									.saturationModifier(0.1f)
									.build())));
	public static final Item CAULIFLOWER =
			Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cauliflower"),
					new Item(new FabricItemSettings()
							.maxCount(64)
							.food(new FoodComponent.Builder()
									.hunger(2)
									.saturationModifier(0.1f)
									.build())));

	public static final RegistryKey<ItemGroup> STARDEWCRAFT =
			RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "stardewcraft"));
	public static final CropBlock PARSNIP_CROP =
			new Parsnip_Crop(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item PARSNIP_SEEDS =
			new AliasedBlockItem(PARSNIP_CROP, new Item.Settings());
	public static final CropBlock BLUE_JAZZ_CROP =
			new Blue_Jazz_Crop(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item BLUE_JAZZ_SEEDS =
			new AliasedBlockItem(BLUE_JAZZ_CROP, new Item.Settings());
	public static final CropBlock POTATO_CROP =
			new Potato_Crop(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item POTATO_SEEDS =
			new AliasedBlockItem(POTATO_CROP, new Item.Settings());
	public static final CropBlock CARROT_CROP =
			new Carrot_Crop(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item CARROT_SEEDS =
			new AliasedBlockItem(CARROT_CROP, new Item.Settings());
	public static final CropBlock CAULIFLOWER_CROP =
			new Cauliflower_Crop(AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item CAULIFLOWER_SEEDS =
			new AliasedBlockItem(CAULIFLOWER_CROP, new Item.Settings());


	//Register zone of tools
	private void registerTools() {
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "copper_pickaxe"), CopperTools.COPPER_PICKAXE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "copper_axe"), CopperTools.COPPER_AXE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "copper_hoe"), CopperTools.COPPER_HOE);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "copper_shovel"), CopperTools.COPPER_SHOVEL);
	}


	public static final Block SCARECROW  = new ScarecrowBlock(FabricBlockSettings.create().strength(4.0f).requiresTool());

	public static final Block SEED_MAKER_BLOCK  = new SeedMakerBlock(FabricBlockSettings.create().strength(4.0f));


	public static final BlockEntityType<SeedMakerEntity> SEED_MAKER_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier(MOD_ID, "seed_maker_entity"),
			FabricBlockEntityTypeBuilder.create(SeedMakerEntity::new, SEED_MAKER_BLOCK).build()
	);
	/**
	 * Method that regulates the behavior of the mod on initialization
	 */
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		registerTools();

		//Register of custom Item Group for the mod
		Registry.register(Registries.ITEM_GROUP, STARDEWCRAFT, FabricItemGroup.builder()
				.icon(() -> new ItemStack(STARDROP))
				.displayName(Text.translatable("StardewCraft"))
						.entries(((displayContext, entries) -> {
							entries.add(STARDROP);
							entries.add(PARSNIP);
							entries.add(PARSNIP_SEEDS);
							entries.add(BLUE_JAZZ);
							entries.add(BLUE_JAZZ_SEEDS);
							entries.add(POTATO);
							entries.add(POTATO_SEEDS);
							entries.add(CARROT);
							entries.add(CARROT_SEEDS);
							entries.add(CAULIFLOWER);
							entries.add(CAULIFLOWER_SEEDS);
							entries.add(CopperTools.COPPER_AXE);
							entries.add(CopperTools.COPPER_HOE);
							entries.add(CopperTools.COPPER_PICKAXE);
							entries.add(CopperTools.COPPER_SHOVEL);
							entries.add(SCARECROW);
							entries.add(SEED_MAKER_BLOCK);
						}))
				.build()); // build() no longer registers by itself

		LOGGER.info("StardewCraft");

		//Register zone of effects
		Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, "max_heart_up"), MAXHEARTUP_EFFECT);

		//Register zone of crops
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID,"parsnip_crop"), PARSNIP_CROP);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID,"parsnip_seeds"), PARSNIP_SEEDS);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "blue_jazz_crop"), BLUE_JAZZ_CROP);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "blue_jazz_seeds"), BLUE_JAZZ_SEEDS);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "potato_crop"), POTATO_CROP);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "potato_seeds"), POTATO_SEEDS);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "carrot_crop"), CARROT_CROP);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "carrot_seeds"), CARROT_SEEDS);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cauliflower_crop"), CAULIFLOWER_CROP);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cauliflower_seeds"), CAULIFLOWER_SEEDS);


		//Register zone of blocks
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "scarecrow_block"), SCARECROW);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "scarecrow_block"), new BlockItem(SCARECROW, new FabricItemSettings()));
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "seed_maker_block"), SEED_MAKER_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "seed_maker_block"), new BlockItem(SEED_MAKER_BLOCK, new FabricItemSettings()));
	}
}