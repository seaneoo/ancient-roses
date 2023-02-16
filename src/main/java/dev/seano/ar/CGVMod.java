package dev.seano.ar;

import dev.seano.ar.block.CGVBlocks;
import dev.seano.ar.item.CGVItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CGVMod implements ModInitializer {
    public static final String MOD_ID = "ar";
    public static final String MOD_NAME = "Ancient Roses";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        CGVBlocks.registerAll();
        CGVItems.registerAll();
    }

    public static Identifier identifier(String path) {
        return new Identifier(MOD_ID, path);
    }
}
