package net.fleetime.cd_worldgen;

import org.apache.commons.lang3.tuple.Pair;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class OptionsHolder
{
	public static class Common
	{
        private static final int defaultBase_avgDist = 25;
		private static final int defaultBase_minDist = 15;
        private static final int defaultBunker_avgDist = 15;
		private static final int defaultBunker_minDist = 5;
        private static final int defaultHouse_avgDist = 20;
		private static final int defaultHouse_minDist = 10;
        private static final int defaultTower_avgDist = 20;
		private static final int defaultTower_minDist = 10;
		private static final boolean defaultLGEN = false;

        public final ConfigValue<Integer> base_avgDist;
		public final ConfigValue<Integer> base_minDist;
        public final ConfigValue<Integer> bunker_avgDist;
		public final ConfigValue<Integer> bunker_minDist;
        public final ConfigValue<Integer> house_avgDist;
		public final ConfigValue<Integer> house_minDist;
        public final ConfigValue<Integer> tower_avgDist;
		public final ConfigValue<Integer> tower_minDist;
		public final ConfigValue<Boolean> LGEN;


		public Common(ForgeConfigSpec.Builder builder)
		{
            builder.comment("CHANGE THESE BEFORE CREATING A WORLD!!!\nANY CHANGES MADE WILL NOT AFFECT ALREADY GENERATED CHUNKS.");
			builder.push("General_Settings");
			this.LGEN = builder.comment("Setting this to false spawns only one time loot, setting this to true spawns loot generators.")
					.define("lootgenerators", defaultLGEN);
			builder.pop();
            builder.push("WorldGen_Base");
            this.base_avgDist = builder.comment("Average chunks between two bases.")
                .worldRestart()
                .defineInRange("avg_dist", defaultBase_avgDist, 10, 50);
            this.base_minDist = builder.comment("Minimum chunks between two bases. MUST BE LESS THAN THE avg_dist SETTING.")
                    .worldRestart()
                    .defineInRange("min_dist", defaultBase_minDist, 3, 30);
            builder.pop();
            builder.push("WorldGen_Bunker");
            this.bunker_avgDist = builder.comment("Average chunks between two bases.")
                .worldRestart()
                .defineInRange("avg_dist", defaultBunker_avgDist, 10, 50);
            this.bunker_minDist = builder.comment("Minimum chunks between two bases. MUST BE LESS THAN THE avg_dist SETTING.")
                    .worldRestart()
                    .defineInRange("min_dist", defaultBunker_minDist, 3, 30);
            builder.pop();
            builder.push("WorldGen_House");
            this.house_avgDist = builder.comment("Average chunks between two bases.")
                .worldRestart()
                .defineInRange("avg_dist", defaultHouse_avgDist, 10, 50);
            this.house_minDist = builder.comment("Minimum chunks between two bases. MUST BE LESS THAN THE avg_dist SETTING.")
                    .worldRestart()
                    .defineInRange("min_dist", defaultHouse_minDist, 3, 30);
            builder.pop();
            builder.push("WorldGen_Tower");
            this.tower_avgDist = builder.comment("Average chunks between two bases.")
                .worldRestart()
                .defineInRange("avg_dist", defaultTower_avgDist, 10, 50);
            this.tower_minDist = builder.comment("Minimum chunks between two bases. MUST BE LESS THAN THE avg_dist SETTING.")
                    .worldRestart()
                    .defineInRange("min_dist", defaultTower_minDist, 3, 30);
            builder.pop();
		}
	}

	public static final Common COMMON;
	public static final ForgeConfigSpec COMMON_SPEC;

	static //constructor
	{
		Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON = commonSpecPair.getLeft();
		COMMON_SPEC = commonSpecPair.getRight();
	}
}