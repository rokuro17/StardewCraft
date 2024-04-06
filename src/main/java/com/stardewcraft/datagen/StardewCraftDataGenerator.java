package com.stardewcraft.datagen;

import com.stardewcraft.StardewCraft;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class StardewCraftDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(AdvancementsProvider::new);
    }

    static class AdvancementsProvider extends FabricAdvancementProvider {
        protected AdvancementsProvider(FabricDataOutput dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
            AdvancementEntry rootAdvancement = Advancement.Builder.create()
                    .display(
                            StardewCraft.PARSNIP, // The display icon
                            Text.translatable("welcome_to_the_valley"), // The title
                            Text.literal("If you want to become a farmer, you have to start with the basics"), // The description
                            new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                            true, // Show toast top right
                            true, // Announce to chat
                            false // Hidden in the advancement tab
                    )
                    // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                    .criterion("got_seeds", InventoryChangedCriterion.Conditions.items(Items.WHEAT_SEEDS))
                    .rewards(new AdvancementRewards.Builder().addLoot(new Identifier("stardewcraft", "getting_started")))
                    .build(consumer, "stardewcraft" + "/root");
        }
    }
}
