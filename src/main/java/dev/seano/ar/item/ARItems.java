/*
 * Licensed under the CC0 1.0 Universal (CC0 1.0) Public Domain Dedication.
 * https://creativecommons.org/publicdomain/zero/1.0/
 */

package dev.seano.ar.item;

import dev.seano.ar.ARMod;
import dev.seano.ar.block.ARBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;

import java.util.HashMap;

/**
 * @author Sean O'Connor
 */
public class ARItems {

    private static final HashMap<Identifier, Item> ITEMS = new HashMap<>();

    public static final Item ROSE = register(Registries.BLOCK.getId(ARBlocks.ROSE)
            .getPath(), new BlockItem(ARBlocks.ROSE, new FabricItemSettings().requires(FeatureFlags.UPDATE_1_20)));

    @SuppressWarnings("UnstableApiUsage")
    public static void registerAll() {
        ITEMS.forEach(((identifier, item) -> Registry.register(Registries.ITEM, identifier, item)));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> entries.addAfter(Items.DANDELION, ROSE));
    }

    private static Item register(String path, Item item) {
        return register(ARMod.identifier(path), item);
    }

    private static Item register(Identifier identifier, Item item) {
        if (item instanceof BlockItem) ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        ITEMS.put(identifier, item);
        return item;
    }
}
