package dev.seano.ar;

import dev.seano.ar.block.ARBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class ARModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ARBlocks.ROSE, RenderLayer.getCutout());
    }
}
