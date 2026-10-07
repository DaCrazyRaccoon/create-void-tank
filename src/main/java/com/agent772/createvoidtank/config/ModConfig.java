package com.agent772.createvoidtank.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class ModConfig {

    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.EnumValue<ActivationMode> ACTIVATION_MODE;
    public static final ModConfigSpec.EnumValue<MinimumHeatLevel> MINIMUM_HEAT_LEVEL;
    public static final ModConfigSpec.BooleanValue VOID_ON_CONTRAPTIONS;

    public enum ActivationMode {
        ALWAYS_ACTIVE,
        REQUIRES_HEAT,
        REQUIRES_REDSTONE
    }

    public enum MinimumHeatLevel {
        PASSIVE,
        BLAZE_BURNER,
        SUPERHEATED
    }

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("activation");

        ACTIVATION_MODE = builder
                .comment("Condition that must be met for the Void Tank to void fluid.",
                        "ALWAYS_ACTIVE = no condition needed (default)",
                        "REQUIRES_HEAT = must be placed above a heat source (Blaze Burner, fire, lava, campfire)",
                        "REQUIRES_REDSTONE = must receive a redstone signal")
                .defineEnum("activationMode", ActivationMode.ALWAYS_ACTIVE);

        MINIMUM_HEAT_LEVEL = builder
                .comment("Minimum heat level required when activationMode is REQUIRES_HEAT.",
                        "PASSIVE = campfire, fire, lava (default)",
                        "BLAZE_BURNER = lit Blaze Burner",
                        "SUPERHEATED = superheated Blaze Burner",
                        "Higher heat levels satisfy lower requirements.")
                .defineEnum("minimumHeatLevel", MinimumHeatLevel.PASSIVE);

        builder.pop();

        builder.push("contraptions");

        VOID_ON_CONTRAPTIONS = builder
                .comment("Whether Void Tanks on moving contraptions void fluid (e.g. fluid collected by a Drill Drain).",
                        "A mounted Void Tank keeps the activation state it had when the contraption was assembled.",
                        "Set to false to ignore Void Tanks on contraptions, as in version 1.1.0.")
                .define("voidOnContraptions", true);

        builder.pop();

        SPEC = builder.build();
    }
}
