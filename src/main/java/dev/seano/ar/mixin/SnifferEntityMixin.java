package dev.seano.ar.mixin;

import dev.seano.ar.item.CGVItems;
import dev.seano.ar.util.WeightedRandomBag;
import net.minecraft.class_8153;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

    @SuppressWarnings("ParameterCanBeLocal")
    @ModifyVariable(method = "method_49142", at = @At("STORE"), ordinal = 0)
    private ItemStack dig(ItemStack itemStack) {
        WeightedRandomBag<Item> itemWeightedRandomBag = new WeightedRandomBag<>();
        itemWeightedRandomBag.addEntry(Items.TORCHFLOWER_SEEDS, 90);
        itemWeightedRandomBag.addEntry(CGVItems.ROSE, 10);
        itemStack = new ItemStack(itemWeightedRandomBag.getRandom());
        return itemStack;
    }
}
