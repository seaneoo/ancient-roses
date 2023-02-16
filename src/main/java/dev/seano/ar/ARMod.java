package dev.seano.ar;

import dev.seano.ar.block.ARBlocks;
import dev.seano.ar.item.ARItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ARMod implements ModInitializer {
    public static final String MOD_ID = "ar";
    public static final String MOD_NAME = "Ancient Roses";

    private static Logger logger;

    @Override
    public void onInitialize() {
        ARBlocks.registerAll();
        ARItems.registerAll();

        logger = LoggerFactory.getLogger(MOD_NAME);
    }

    @SuppressWarnings("unused")
    public static Logger getLogger() {
        return logger;
    }

    public static Identifier identifier(String path) {
        return new Identifier(MOD_ID, path);
    }
}
