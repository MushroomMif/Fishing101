package net.macck209.fishing101.registries;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.LocationCheckLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.TimeCheckLootCondition;
import net.minecraft.loot.condition.WeatherCheckLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.predicate.LightPredicate;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.entity.LocationPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;

public class LootRegistry {
    private static final Identifier FISHING_FISH_LOOT_TABLE_ID = LootTables.FISHING_FISH_GAMEPLAY;
    private static final Identifier FISHING_TREASURE_LOOT_TABLE_ID = LootTables.FISHING_TREASURE_GAMEPLAY;
    public static final LootCondition.Builder NEEDS_OCEAN_BIOME;
    public static final LootCondition.Builder NOT_OCEAN_BIOME;
    public static final LootCondition.Builder NEEDS_SWAMP_BIOME;
    public static final LootCondition.Builder NEEDS_JUNGLE_BIOME;
    public static final LootCondition.Builder NEEDS_NIGHT;
    public static final LootCondition.Builder NEEDS_MANGROVE;
    public static final LootCondition.Builder NEEDS_JAPAN;
    public static final LootCondition.Builder NEEDS_BEACH;
    public static final LootCondition.Builder ABOVE_Y90;
    public static final LootCondition.Builder IS_RAINING;
    public static final LootCondition.Builder IS_STORMY;
    public static final LootCondition.Builder NEEDS_END;
    public static final LootCondition.Builder NEEDS_COLD;
    public static final LootCondition.Builder NEEDS_DARKNESS;
    public static final LootCondition.Builder BELOW_Y0;
    public static final LootCondition.Builder NEEDS_DEEP_DARK;
    public static final LootCondition.Builder NEEDS_WARM_OCEAN_OR_BEACH;
    public static final LootCondition.Builder NEEDS_MUSHROOM_FIELDS;
    public static final LootCondition.Builder NEEDS_FLOWER_FOREST;
    public static final LootCondition.Builder NEEDS_BAMBOO_JUNGLE;
    public static final LootCondition.Builder ABOVE_Y128;
    public static final LootCondition.Builder NEEDS_COLD_OCEAN;
    public static final LootCondition.Builder NEEDS_WARM_OCEAN_OR_JUNGLE;



    public static void register() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && FISHING_FISH_LOOT_TABLE_ID.equals(id)) {
                tableBuilder.modifyPools(tb ->{
                    tb
                    .with(ItemEntry.builder(Items.COD)
                            .conditionally(NEEDS_COLD.invert())
                            .conditionally(NEEDS_JUNGLE_BIOME.invert())
                            .weight(3000-60))
                    .with(ItemEntry.builder(Items.SALMON)
                            .conditionally(NEEDS_WARM_OCEAN_OR_BEACH.invert())
                            .weight(1000-25))
                    .with(ItemEntry.builder(Items.PUFFERFISH)
                            .conditionally(NEEDS_WARM_OCEAN_OR_BEACH)
                            .weight(250-2))
                    .with(ItemEntry.builder(Items.TROPICAL_FISH)
                            .conditionally(NEEDS_WARM_OCEAN_OR_JUNGLE)
                            .weight(500-13))

                    .with(ItemEntry.builder(Items.SALMON)
                            .conditionally(ABOVE_Y90)
                            .weight(3000))
                    .with(ItemEntry.builder(Items.TROPICAL_FISH)
                            .conditionally(NEEDS_JUNGLE_BIOME)
                            .weight(1500))

                    .with(ItemEntry.builder(ItemRegistry.ORDINARY_CARP)
                            .conditionally(NOT_OCEAN_BIOME)
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.DEFORMED_CARP)
                            .conditionally(NOT_OCEAN_BIOME)
                            .weight(1000))
                    .with(ItemEntry.builder(ItemRegistry.LUMINOUS_CARP)
                            .conditionally(NOT_OCEAN_BIOME)
                            .conditionally(NEEDS_NIGHT)
                            .weight(500))

                    .with(ItemEntry.builder(ItemRegistry.ORDINARY_CATFISH)
                            .conditionally(NOT_OCEAN_BIOME)
                            .conditionally(NEEDS_SWAMP_BIOME.invert())
                            .conditionally(NEEDS_JUNGLE_BIOME.invert())
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.MUDDY_CATFISH)
                            .conditionally(NEEDS_SWAMP_BIOME)
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.TROPICAL_CATFISH)
                            .conditionally(NEEDS_JUNGLE_BIOME)
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.DIVINE_CATFISH)
                            .conditionally(NOT_OCEAN_BIOME)
                            .weight(100))

                    .with(ItemEntry.builder(ItemRegistry.ORDINARY_MACKEREL)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .weight(3000))
                    .with(ItemEntry.builder(ItemRegistry.LUMINOUS_MACKEREL)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .conditionally(NEEDS_NIGHT)
                            .weight(500))

                    .with(ItemEntry.builder(ItemRegistry.MANGROVE_JACK)
                            .conditionally(NEEDS_MANGROVE)
                            .weight((2000)))

                    .with(ItemEntry.builder(ItemRegistry.ORDINARY_SHRIMP)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .conditionally(NEEDS_COLD_OCEAN.invert())
                            .weight((2000)))
                    .with(ItemEntry.builder(ItemRegistry.LUMINOUS_SHRIMP)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .conditionally(NEEDS_COLD_OCEAN.invert())
                            .conditionally(NEEDS_NIGHT)
                            .weight((500)))

                    .with(ItemEntry.builder(ItemRegistry.STARFISH)
                            .conditionally(NEEDS_WARM_OCEAN_OR_BEACH)
                            .conditionally(NEEDS_END.invert())
                            .weight((1200)))

                    .with(ItemEntry.builder(ItemRegistry.JELLYFISH)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .conditionally(NEEDS_END.invert())
                            .weight((1200)))
                    .with(ItemEntry.builder(ItemRegistry.DIVINE_JELLYFISH)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .weight((100)))

                    .with(ItemEntry.builder(ItemRegistry.RED_KOI)
                            .conditionally(NEEDS_JAPAN)
                            .weight((1200)))
                    .with(ItemEntry.builder(ItemRegistry.YELLOW_KOI)
                            .conditionally(NEEDS_JAPAN)
                            .weight((1200)))

                    .with(ItemEntry.builder(ItemRegistry.ICE_COD)
                            .conditionally(NEEDS_COLD)
                            .weight((3000)))

                    .with(ItemEntry.builder(ItemRegistry.ANGLERFISH)
                            .conditionally(NEEDS_DARKNESS)
                            .conditionally(NEEDS_END.invert())
                            .conditionally(BELOW_Y0)
                            .weight((500)))
                    .with(ItemEntry.builder(ItemRegistry.ANGLERFISH)
                            .conditionally(NEEDS_DARKNESS)
                            .conditionally(NEEDS_DEEP_DARK)
                            .weight((1000)))

                    .with(ItemEntry.builder(ItemRegistry.SOLARFISH)
                            .conditionally(ABOVE_Y90)
                            .conditionally(NEEDS_NIGHT.invert())
                            .weight((1000)))

                    .with(ItemEntry.builder(ItemRegistry.WITCHFISH)
                            .conditionally(NEEDS_MUSHROOM_FIELDS)
                            .weight((1000)))

                    .with(ItemEntry.builder(ItemRegistry.FLOWERFISH)
                            .conditionally(NEEDS_FLOWER_FOREST)
                            .weight((1000)))

                    .with(ItemEntry.builder(ItemRegistry.PANDAFISH)
                            .conditionally(NEEDS_BAMBOO_JUNGLE)
                            .weight((1000)))


                    // Rare fish are more common when it's raining
                    .with(ItemEntry.builder(Items.PUFFERFISH)
                            .conditionally(IS_RAINING)
                            .weight(500))
                    .with(ItemEntry.builder(ItemRegistry.DIVINE_CATFISH)
                            .conditionally(NOT_OCEAN_BIOME)
                            .conditionally(IS_RAINING)
                            .weight(100))
                    .with(ItemEntry.builder(ItemRegistry.DIVINE_JELLYFISH)
                            .conditionally(NEEDS_OCEAN_BIOME)
                            .conditionally(IS_RAINING)
                            .weight(100))

                    .with(ItemEntry.builder(ItemRegistry.THUNDERFIN)
                            .conditionally(IS_STORMY)
                            .weight(1000))


                    // End fish
                    .with(ItemEntry.builder(ItemRegistry.END_JELLYFISH)
                            .conditionally(NEEDS_END)
                            .weight((1200)))
                    .with(ItemEntry.builder(ItemRegistry.END_STARFISH)
                            .conditionally(NEEDS_END)
                            .weight((1200)))
                ;});
            }
        });
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && FISHING_TREASURE_LOOT_TABLE_ID.equals(id)) {
                tableBuilder.modifyPools(tb ->{
                    tb
                            .with(ItemEntry.builder(ItemRegistry.CRAB_CLAW)
                                    .conditionally(NEEDS_WARM_OCEAN_OR_BEACH)
                                    .weight(3))
                    ;});
            }
        });
    }


    static {
        // Note: Fish distribution isn't realistic. I'm more focused on making the mod fun. Feel free to modify stuff your way tho
        NEEDS_OCEAN_BIOME = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.OCEAN))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.COLD_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_COLD_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_FROZEN_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_LUKEWARM_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FROZEN_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.LUKEWARM_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.WARM_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.BEACH)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_BEACH)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.STONY_SHORE)));
        NOT_OCEAN_BIOME  = NEEDS_OCEAN_BIOME.invert();
        NEEDS_SWAMP_BIOME = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SWAMP))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MANGROVE_SWAMP)));
        NEEDS_JUNGLE_BIOME = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.JUNGLE))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.BAMBOO_JUNGLE)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SPARSE_JUNGLE)));
        NEEDS_NIGHT = TimeCheckLootCondition.create(BoundedIntUnaryOperator.create(12000,24000)).period(24000);
        NEEDS_MANGROVE = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MANGROVE_SWAMP));
        NEEDS_JAPAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.CHERRY_GROVE))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MEADOW)));
        NEEDS_BEACH = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.BEACH))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_BEACH)));
        ABOVE_Y90 = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().y(NumberRange.DoubleRange.atLeast(90)));
        IS_RAINING = WeatherCheckLootCondition.create().raining(true).or(WeatherCheckLootCondition.create().thundering(true));
        IS_STORMY = WeatherCheckLootCondition.create().thundering(true);
        NEEDS_END = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().dimension(World.END));
        NEEDS_COLD = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_BEACH))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_PLAINS)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_SLOPES)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.SNOWY_TAIGA)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.ICE_SPIKES)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FROZEN_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FROZEN_PEAKS)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FROZEN_RIVER)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_FROZEN_OCEAN)));
        NEEDS_DARKNESS = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().light(LightPredicate.Builder.create().light(NumberRange.IntRange.atMost(0))));
        BELOW_Y0 = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().y(NumberRange.DoubleRange.atMost(0)));
        NEEDS_DEEP_DARK = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_DARK));
        NEEDS_WARM_OCEAN_OR_BEACH = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.WARM_OCEAN))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.LUKEWARM_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_LUKEWARM_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.BEACH)));
        NEEDS_MUSHROOM_FIELDS = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.MUSHROOM_FIELDS));
        NEEDS_FLOWER_FOREST = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FLOWER_FOREST));
        NEEDS_BAMBOO_JUNGLE = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.BAMBOO_JUNGLE));
        ABOVE_Y128 = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().y(NumberRange.DoubleRange.atLeast(128)));
        NEEDS_COLD_OCEAN = LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.FROZEN_OCEAN))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_FROZEN_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.COLD_OCEAN)))
                .or(LocationCheckLootCondition.builder(LocationPredicate.Builder.create().biome(BiomeKeys.DEEP_COLD_OCEAN)));
        NEEDS_WARM_OCEAN_OR_JUNGLE = NEEDS_BAMBOO_JUNGLE.or(NEEDS_WARM_OCEAN_OR_BEACH);
    }
}
