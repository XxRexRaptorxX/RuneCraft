package xxrexraptorxx.runecraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import xxrexraptorxx.runecraft.main.ModItems;
import xxrexraptorxx.runecraft.main.References;

import javax.annotation.Nullable;

public class TagsItem extends ItemTagsProvider {
    public TagsItem(final DataGenerator generator, final BlockTagsProvider blockTagProvider, @Nullable final ExistingFileHelper existingFileHelper) {
        super(generator, blockTagProvider, References.MODID, existingFileHelper);
    }


    @Override
    protected void addTags() {
        tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(   ModItems.AMETHYST.get(),
                        ModItems.RUBY.get(),
                        ModItems.SAPPHIRE.get(),
                        ModItems.TOPAZ.get(),
                        ModItems.CRYSTAL.get(),
                        ModItems.CHARGED_AMETHYST.get(),
                        ModItems.CHARGED_RUBY.get(),
                        ModItems.CHARGED_SAPPHIRE.get(),
                        ModItems.CHARGED_TOPAZ.get(),
                        ModItems.CHARGED_CRYSTAL.get(),
                        ModItems.CHARGED_DIAMOND.get(),
                        ModItems.CHARGED_EMERALD.get()
                        );
    }
}
