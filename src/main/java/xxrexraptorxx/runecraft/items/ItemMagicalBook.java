package xxrexraptorxx.runecraft.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import xxrexraptorxx.runecraft.utils.SpellHelper;
import xxrexraptorxx.runecraft.utils.enums.SpellShapes;

public class ItemMagicalBook extends Item {

    public ItemMagicalBook(Properties properties) {
        super(properties
                .rarity(Rarity.RARE)
                .stacksTo(1)
                .durability(15)
                .fireResistant()
        );
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }


    @Override
    public ItemStack getCraftingRemainder(ItemStack stack) {
        if (stack.getMaxDamage() == stack.getDamageValue()) {
            return new ItemStack(Items.AIR);

        } else {
            ItemStack newItemStack = stack.copy();
            newItemStack.setDamageValue(stack.getDamageValue() + 1);
            return newItemStack;
        }
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();

        SpellHelper.spawnSpellEffect(SpellShapes.SINGLE, ParticleTypes.ENCHANT, 10, 1, level, player.position());
        return InteractionResult.SUCCESS;
    }

}
