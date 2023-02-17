/*
 * Licensed under the CC0 1.0 Universal (CC0 1.0) Public Domain Dedication.
 * https://creativecommons.org/publicdomain/zero/1.0/
 */

package dev.seano.ar;

import dev.seano.ar.block.ARBlocks;
import dev.seano.ar.item.ARItems;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ARMod implements ModInitializer {
    public static final String MOD_ID = "ar";
    public static final String MOD_NAME = "Ancient Roses";

    private static Logger logger;
    private static ARConfig config;

    @Override
    public void onInitialize() {
        AutoConfig.register(ARConfig.class, GsonConfigSerializer::new);

        ARBlocks.registerAll();
        ARItems.registerAll();

        logger = LoggerFactory.getLogger(MOD_NAME);
        config = AutoConfig.getConfigHolder(ARConfig.class)
                .getConfig();
    }

    @SuppressWarnings("unused")
    public static Logger getLogger() {
        return logger;
    }

    @SuppressWarnings("unused")
    public static ARConfig getConfig() {
        return config;
    }

    public static Identifier identifier(String path) {
        return new Identifier(MOD_ID, path);
    }
}
