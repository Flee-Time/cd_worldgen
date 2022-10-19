package net.fleetime.cd_worldgen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.fleetime.cd_worldgen.structures.RunDownBase;
import net.fleetime.cd_worldgen.structures.RunDownBaseLGen;
import net.fleetime.cd_worldgen.structures.RunDownBunker;
import net.fleetime.cd_worldgen.structures.RunDownBunkerLGen;
import net.fleetime.cd_worldgen.structures.RunDownHouse;
import net.fleetime.cd_worldgen.structures.RunDownHouseLGen;
import net.fleetime.cd_worldgen.structures.RunDownTower;
import net.fleetime.cd_worldgen.structures.RunDownTowerLGen;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class STStructures {

    /**
     * We are using the Deferred Registry system to register our structure as this is the preferred way on Forge.
     * This will handle registering the base structure for us at the correct time so we don't have to handle it ourselves.
     *
     * HOWEVER, do note that Deferred Registries only work for anything that is a Forge Registry. This means that
     * configured structures and configured features need to be registered directly to WorldGenRegistries as there
     * is no Deferred Registry system for them.
     */
    public static final DeferredRegister<Structure<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, cd_worldgen.MODID);

    /**
     * Registers the structure itself and sets what its path is. In this case, the
     * structure will have the resourcelocation of structure_tutorial:run_down_house.
     *
     * It is always a good idea to register your Structures so that other mods and datapacks can
     * use them too directly from the registries. It great for mod/datapacks compatibility.
     *
     * IMPORTANT: Once you have set the name for your structure below and distributed your mod,
     *   changing the structure's registry name or removing the structure may cause log spam.
     *   This log spam won't break your worlds as forge already fixed the Mojang bug of removed structures wrecking worlds.
     *   https://github.com/MinecraftForge/MinecraftForge/commit/56e538e8a9f1b8e6ff847b9d2385484c48849b8d
     *
     *   However, users might not know that and think you are to blame for issues that doesn't exist.
     *   So it is best to keep your structure names the same as long as you can instead of changing them frequently.
     */
    public static final RegistryObject<Structure<NoFeatureConfig>> RUN_DOWN_BASE = DEFERRED_REGISTRY_STRUCTURE.register("run_down_base", () -> (new RunDownBase(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> RUN_DOWN_BUNKER = DEFERRED_REGISTRY_STRUCTURE.register("run_down_bunker", () -> (new RunDownBunker(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> RUN_DOWN_HOUSE = DEFERRED_REGISTRY_STRUCTURE.register("run_down_house", () -> (new RunDownHouse(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> RUN_DOWN_TOWER = DEFERRED_REGISTRY_STRUCTURE.register("run_down_tower", () -> (new RunDownTower(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> RUN_DOWN_BASE_LGEN = DEFERRED_REGISTRY_STRUCTURE.register("run_down_base_lgen", () -> (new RunDownBaseLGen(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> RUN_DOWN_BUNKER_LGEN = DEFERRED_REGISTRY_STRUCTURE.register("run_down_bunker_lgen", () -> (new RunDownBunkerLGen(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> RUN_DOWN_HOUSE_LGEN = DEFERRED_REGISTRY_STRUCTURE.register("run_down_house_lgen", () -> (new RunDownHouseLGen(NoFeatureConfig.CODEC)));
    public static final RegistryObject<Structure<NoFeatureConfig>> RUN_DOWN_TOWER_LGEN = DEFERRED_REGISTRY_STRUCTURE.register("run_down_tower_lgen", () -> (new RunDownTowerLGen(NoFeatureConfig.CODEC)));


    /**
     * This is where we set the rarity of your structures and determine if land conforms to it.
     * See the comments in below for more details.
     */
    public static void setupStructures() {
        setupMapSpacingAndLand(
                RUN_DOWN_BASE.get(), /* The instance of the structure */
                new StructureSeparationSettings(OptionsHolder.COMMON.base_avgDist.get() /* average distance apart in chunks between spawn attempts */,
                        OptionsHolder.COMMON.base_minDist.get() /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        1324657950 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);

        setupMapSpacingAndLand(
                RUN_DOWN_BUNKER.get(), /* The instance of the structure */
                new StructureSeparationSettings(OptionsHolder.COMMON.bunker_avgDist.get() /* average distance apart in chunks between spawn attempts */,
                        OptionsHolder.COMMON.bunker_minDist.get() /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        1234121290 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);        

        setupMapSpacingAndLand(
                RUN_DOWN_HOUSE.get(), /* The instance of the structure */
                new StructureSeparationSettings(OptionsHolder.COMMON.house_avgDist.get() /* average distance apart in chunks between spawn attempts */,
                        OptionsHolder.COMMON.house_minDist.get() /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        1214125290 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);

        setupMapSpacingAndLand(
                RUN_DOWN_TOWER.get(), /* The instance of the structure */
                new StructureSeparationSettings(OptionsHolder.COMMON.tower_avgDist.get() /* average distance apart in chunks between spawn attempts */,
                        OptionsHolder.COMMON.tower_minDist.get() /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        1754121590 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);

        setupMapSpacingAndLand(
                RUN_DOWN_BASE_LGEN.get(), /* The instance of the structure */
                new StructureSeparationSettings(OptionsHolder.COMMON.base_avgDist.get() /* average distance apart in chunks between spawn attempts */,
                        OptionsHolder.COMMON.base_minDist.get() /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        1324657950 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);

        setupMapSpacingAndLand(
                RUN_DOWN_BUNKER_LGEN.get(), /* The instance of the structure */
                new StructureSeparationSettings(OptionsHolder.COMMON.bunker_avgDist.get() /* average distance apart in chunks between spawn attempts */,
                        OptionsHolder.COMMON.bunker_minDist.get() /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        1234121290 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);        

        setupMapSpacingAndLand(
                RUN_DOWN_HOUSE_LGEN.get(), /* The instance of the structure */
                new StructureSeparationSettings(OptionsHolder.COMMON.house_avgDist.get() /* average distance apart in chunks between spawn attempts */,
                        OptionsHolder.COMMON.house_minDist.get() /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        1214125290 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);

        setupMapSpacingAndLand(
                RUN_DOWN_TOWER_LGEN.get(), /* The instance of the structure */
                new StructureSeparationSettings(OptionsHolder.COMMON.tower_avgDist.get() /* average distance apart in chunks between spawn attempts */,
                        OptionsHolder.COMMON.tower_minDist.get() /* minimum distance apart in chunks between spawn attempts. MUST BE LESS THAN ABOVE VALUE*/,
                        1754121590 /* this modifies the seed of the structure so no two structures always spawn over each-other. Make this large and unique. */),
                true);
        // Add more structures here and so on
    }

    /**
     * Adds the provided structure to the registry, and adds the separation settings.
     * The rarity of the structure is determined based on the values passed into
     * this method in the structureSeparationSettings argument.
     * This method is called by setupStructures above.
     */
    public static <F extends Structure<?>> void setupMapSpacingAndLand(
            F structure,
            StructureSeparationSettings structureSeparationSettings,
            boolean transformSurroundingLand)
    {
        /*
         * We need to add our structures into the map in Structure class
         * alongside vanilla structures or else it will cause errors.
         *
         * If the registration is setup properly for the structure,
         * getRegistryName() should never return null.
         */
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

        /*
         * Whether surrounding land will be modified automatically to conform to the bottom of the structure.
         * Basically, it adds land at the base of the structure like it does for Villages and Outposts.
         * Doesn't work well on structure that have pieces stacked vertically or change in heights.
         *
         * Note: The air space this method will create will be filled with water if the structure is below sealevel.
         * This means this is best for structure above sealevel so keep that in mind.
         *
         * NOISE_AFFECTING_FEATURES requires AccessTransformer  (See resources/META-INF/accesstransformer.cfg)
         */
        if(transformSurroundingLand){
            Structure.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.NOISE_AFFECTING_FEATURES)
                            .add(structure)
                            .build();
        }

        /*
         * This is the map that holds the default spacing of all structures.
         * Always add your structure to here so that other mods can utilize it if needed.
         *
         * However, while it does propagate the spacing to some correct dimensions from this map,
         * it seems it doesn't always work for code made dimensions as they read from this list beforehand.
         *
         * Instead, we will use the WorldEvent.Load event in StructureTutorialMain to add the structure
         * spacing from this list into that dimension or to do dimension blacklisting properly.
         * We also use our entry in DimensionStructuresSettings.DEFAULTS in WorldEvent.Load as well.
         *
         * DEFAULTS requires AccessTransformer  (See resources/META-INF/accesstransformer.cfg)
         */
        DimensionStructuresSettings.DEFAULTS =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.DEFAULTS)
                        .put(structure, structureSeparationSettings)
                        .build();


        /*
         * There are very few mods that relies on seeing your structure in the noise settings registry before the world is made.
         *
         * You may see some mods add their spacings to DimensionSettings.BUILTIN_OVERWORLD instead of the NOISE_GENERATOR_SETTINGS loop below but
         * that field only applies for the default overworld and won't add to other worldtypes or dimensions (like amplified or Nether).
         * So yeah, don't do DimensionSettings.BUILTIN_OVERWORLD. Use the NOISE_GENERATOR_SETTINGS loop below instead if you must.
         */
        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings().structureConfig();

            /*
             * Pre-caution in case a mod makes the structure map immutable like datapacks do.
             * I take no chances myself. You never know what another mods does...
             *
             * structureConfig requires AccessTransformer  (See resources/META-INF/accesstransformer.cfg)
             */
            if(structureMap instanceof ImmutableMap){
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig = tempMap;
            }
            else{
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }
}
