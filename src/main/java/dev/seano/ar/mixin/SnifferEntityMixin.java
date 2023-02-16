package dev.seano.ar.mixin;

import dev.seano.ar.ARMod;
import dev.seano.ar.item.ARItems;
import dev.seano.ar.util.WeightedRandomBag;
import net.minecraft.class_8153;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
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
@Mixin(class_8153.class)
public abstract class SnifferEntityMixin extends AnimalEntity {

    protected SnifferEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @ModifyVariable(method = "method_49142", at = @At("STORE"), ordinal = 0)
    private ItemStack dig(ItemStack itemStack) {
        if (this.getWorld()
                .getEnabledFeatures()
                .contains(FeatureFlags.UPDATE_1_20)) {
            double roseChance = ARMod.getConfig().roseChance >= 1 ? 1 : ARMod.getConfig().roseChance * 100;
            double vanillaChance = roseChance >= 1 ? 0 : 100 - roseChance;

            WeightedRandomBag<Item> itemWeightedRandomBag = new WeightedRandomBag<>();
            itemWeightedRandomBag.addEntry(Items.TORCHFLOWER_SEEDS, vanillaChance);
            itemWeightedRandomBag.addEntry(ARItems.ROSE, roseChance);
            itemStack = new ItemStack(itemWeightedRandomBag.getRandom());
        }
        return itemStack;
    }
}
