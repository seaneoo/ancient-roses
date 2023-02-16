package dev.seano.ar.item;

import dev.seano.ar.CGVMod;
import dev.seano.ar.block.CGVBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
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

    public static final Item ROSE = register(Registries.BLOCK.getId(CGVBlocks.ROSE)
            .getPath(), new BlockItem(CGVBlocks.ROSE, new FabricItemSettings()));

    public static void registerAll() {
        ITEMS.forEach(((identifier, item) -> Registry.register(Registries.ITEM, identifier, item)));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> entries.add(ROSE));
    }

    private static Item register(String path, Item item) {
        return register(CGVMod.identifier(path), item);
    }

    private static Item register(Identifier identifier, Item item) {
        if (item instanceof BlockItem) ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        ITEMS.put(identifier, item);
        return item;
    }
}
