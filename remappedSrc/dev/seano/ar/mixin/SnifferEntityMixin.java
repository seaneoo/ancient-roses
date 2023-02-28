/*
 * Licensed under the CC0 1.0 Universal (CC0 1.0) Public Domain Dedication.
 * https://creativecommons.org/publicdomain/zero/1.0/
 */

package dev.seano.ar.mixin;

import dev.seano.ar.ARMod;
import dev.seano.ar.item.ARItems;
import dev.seano.ar.util.RandomCollection;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * @author Sean O'Connor
 */
@Mixin(SnifferEntity.class)
public abstract class SnifferEntityMixin extends AnimalEntity {

    /**
     * Mapping of {@link Item} instances and their specified weight.
     */
    private static final RandomCollection<Item> ITEMS = new RandomCollection<>();

    static {
        /* Add items and their weights to the RandomCollection. */
        ITEMS.add(90, Items.TORCHFLOWER_SEEDS);
        ITEMS.add(10, ARItems.ROSE);

        for (int i = 0; i < 10; i++) {
            ARMod.getLogger()
                    .info(ITEMS.next()
                            .toString());
        }
    }

    protected SnifferEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * Inject into {@link SnifferEntity#dropSeeds()} to drop a custom {@link ItemStack} when the sniffer "digs" up a seed.
     *
     * @param itemStack The ItemStack to modify.
     * @return The ItemStack dropped.
     */
    @SuppressWarnings("JavadocReference")
    @ModifyVariable(method = "dropSeeds", at = @At("STORE"), ordinal = 0)
    private ItemStack dropSeedsInject(ItemStack itemStack) {
        /* Ensure the current world has Update 1.20 experimental features enabled. */
        if (this.method_48926()
                .getEnabledFeatures()
                .contains(FeatureFlags.UPDATE_1_20)) {
            /* Pick a new item to drop; modify the itemStack variable. */
            itemStack = new ItemStack(ITEMS.next());
        }
        /* Return the modified itemStack variable. */
        return itemStack;
    }
}
