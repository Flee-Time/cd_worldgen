package net.fleetime.cd_worldgen;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class STConfiguredStructures {
    /**
     * Static instance of our structure so we can reference it and add it to biomes easily.
     */
    public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_BASE = STStructures.RUN_DOWN_BASE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_BUNKER = STStructures.RUN_DOWN_BUNKER.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_HOUSE = STStructures.RUN_DOWN_HOUSE.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_TOWER = STStructures.RUN_DOWN_TOWER.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_BASE_LGEN = STStructures.RUN_DOWN_BASE_LGEN.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_BUNKER_LGEN = STStructures.RUN_DOWN_BUNKER_LGEN.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_HOUSE_LGEN = STStructures.RUN_DOWN_HOUSE_LGEN.get().configured(IFeatureConfig.NONE);
    public static StructureFeature<?, ?> CONFIGURED_RUN_DOWN_TOWER_LGEN = STStructures.RUN_DOWN_TOWER_LGEN.get().configured(IFeatureConfig.NONE);

    /**
     * Registers the configured structure which is what gets added to the biomes.
     * Noticed we are not using a forge registry because there is none for configured structures.
     *
     * We can register configured structures at any time before a world is clicked on and made.
     * But the best time to register configured features by code is honestly to do it in FMLCommonSetupEvent.
     */
    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(cd_worldgen.MODID, "configured_run_down_base"), CONFIGURED_RUN_DOWN_BASE);
        Registry.register(registry, new ResourceLocation(cd_worldgen.MODID, "configured_run_down_bunker"), CONFIGURED_RUN_DOWN_BUNKER);
        Registry.register(registry, new ResourceLocation(cd_worldgen.MODID, "configured_run_down_house"), CONFIGURED_RUN_DOWN_HOUSE);
        Registry.register(registry, new ResourceLocation(cd_worldgen.MODID, "configured_run_down_tower"), CONFIGURED_RUN_DOWN_TOWER);
        Registry.register(registry, new ResourceLocation(cd_worldgen.MODID, "configured_run_down_base_lgen"), CONFIGURED_RUN_DOWN_BASE_LGEN);
        Registry.register(registry, new ResourceLocation(cd_worldgen.MODID, "configured_run_down_bunker_lgen"), CONFIGURED_RUN_DOWN_BUNKER_LGEN);
        Registry.register(registry, new ResourceLocation(cd_worldgen.MODID, "configured_run_down_house_lgen"), CONFIGURED_RUN_DOWN_HOUSE_LGEN);
        Registry.register(registry, new ResourceLocation(cd_worldgen.MODID, "configured_run_down_tower_lgen"), CONFIGURED_RUN_DOWN_TOWER_LGEN);

        /* Ok so, this part may be hard to grasp but basically, just add your structure to this to
        * prevent any sort of crash or issue with other mod's custom ChunkGenerators. If they use
        * FlatGenerationSettings.STRUCTURE_FEATURES in it and you don't add your structure to it, the game
        * could crash later when you attempt to add the StructureSeparationSettings to the dimension.
        *
        * (It would also crash with superflat worldtype if you omit the below line
        * and attempt to add the structure's StructureSeparationSettings to the world)
        *
        * Note: If you want your structure to spawn in superflat, remove the FlatChunkGenerator check
        * in StructureTutorialMain.addDimensionalSpacing and then create a superflat world, exit it,
        * and re-enter it and your structures will be spawning. I could not figure out why it needs
        * the restart but honestly, superflat is really buggy and shouldn't be your main focus in my opinion.
        *
        * Requires AccessTransformer ( see resources/META-INF/accesstransformer.cfg )
        */
        FlatGenerationSettings.STRUCTURE_FEATURES.put(STStructures.RUN_DOWN_BASE.get(), CONFIGURED_RUN_DOWN_BASE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(STStructures.RUN_DOWN_BUNKER.get(), CONFIGURED_RUN_DOWN_BUNKER);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(STStructures.RUN_DOWN_HOUSE.get(), CONFIGURED_RUN_DOWN_HOUSE);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(STStructures.RUN_DOWN_TOWER.get(), CONFIGURED_RUN_DOWN_TOWER);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(STStructures.RUN_DOWN_BASE_LGEN.get(), CONFIGURED_RUN_DOWN_BASE_LGEN);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(STStructures.RUN_DOWN_BUNKER_LGEN.get(), CONFIGURED_RUN_DOWN_BUNKER_LGEN);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(STStructures.RUN_DOWN_HOUSE_LGEN.get(), CONFIGURED_RUN_DOWN_HOUSE_LGEN);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(STStructures.RUN_DOWN_TOWER_LGEN.get(), CONFIGURED_RUN_DOWN_TOWER_LGEN);
    }
}
