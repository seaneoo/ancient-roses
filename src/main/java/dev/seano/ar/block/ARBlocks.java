package dev.seano.ar.block;

import dev.seano.ar.ARMod;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.HashMap;

/**
 * @author Sean O'Connor
 */
public class ARBlocks {

    private static final HashMap<Identifier, Block> BLOCKS = new HashMap<>();

    public static final Block ROSE = register("rose", new FlowerBlock(StatusEffects.SATURATION, 7, AbstractBlock.Settings.of(Material.PLANT)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .requires(FeatureFlags.UPDATE_1_20)
            .method_49229(AbstractBlock.OffsetType.XZ)));
    public static final Block POTTED_ROSE = register("potted_rose", new FlowerPotBlock(ROSE, AbstractBlock.Settings.of(Material.DECORATION)
            .breakInstantly()
            .requires(FeatureFlags.UPDATE_1_20)
            .nonOpaque()));

    public static void registerAll() {
        BLOCKS.forEach(((identifier, item) -> Registry.register(Registries.BLOCK, identifier, item)));
    }

    @SuppressWarnings("SameParameterValue")
    private static Block register(String path, Block block) {
        return register(ARMod.identifier(path), block);
    }

    private static Block register(Identifier identifier, Block block) {
        BLOCKS.put(identifier, block);
        return block;
    }
}
