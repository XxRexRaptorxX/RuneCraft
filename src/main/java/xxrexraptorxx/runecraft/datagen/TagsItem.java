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
        tag(ItemTags.PIGLIN_REPELLENTS)
                .add(   ModItems.CURSE_WAND.get()
                        );
    }
}
