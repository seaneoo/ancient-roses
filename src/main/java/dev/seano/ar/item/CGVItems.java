package dev.seano.ar.item;

import dev.seano.ar.CGVMod;
import dev.seano.ar.block.CGVBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;

/**
 * @author Sean O'Connor
 */
public class CGVItems {

    private static final HashMap<Identifier, Item> ITEMS = new HashMap<>();

    public static final Item ROSE = register(CGVBlocks.ROSE);

    public static void registerAll() {
        ITEMS.forEach(((identifier, item) -> Registry.register(Registries.ITEM, identifier, item)));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> entries.add(ROSE));
    }

    @SuppressWarnings("SameParameterValue")
    private static Item register(Block block) {
        return register(new BlockItem(block, new Item.Settings()));
    }

    private static Item register(Block block, Block... blocks) {
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        for (Block block2 : blocks) {
            Item.BLOCK_ITEMS.put(block2, blockItem);
        }
        return register(blockItem);
    }

    private static Item register(BlockItem item) {
        return register(item.getBlock(), item);
    }

    protected static Item register(Block block, Item item) {
        return register(Registries.BLOCK.getId(block), item);
    }

    private static Item register(String id, Item item) {
        return register(CGVMod.identifier(id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        ITEMS.put(id, item);
        return item;
    }
}
