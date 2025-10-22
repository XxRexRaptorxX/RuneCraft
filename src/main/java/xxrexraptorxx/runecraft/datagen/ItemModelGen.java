package xxrexraptorxx.runecraft.datagen;

import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import xxrexraptorxx.runecraft.registry.ModItems;

import java.util.function.BiConsumer;

public class ItemModelGen extends ItemModelGenerators {

    public ItemModelGen(ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
    }


    @Override
    public void run() {
        this.generateFlatItem(ModItems.BASIC_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.AETHER_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.NETHER_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.CURSE_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.HOLY_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.STORM_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.MAELSTROM_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.ESCAPE_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.DEFENSIVE_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.THUNDER_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.CREATURE_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.CHANGING_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.DESTRUCTION_WAND.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.MAGICAL_BOOK.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.MAGICAL_PAGE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SPELL_PAGE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ENCHANTING_PAGE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.WAND_PAGE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ORB_PAGE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ALCHEMY_PAGE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.CURSE_PAGE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.LOST_PAGE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.BANNED_PAGE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ORB.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SOUL_ORB.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SPIRIT_STAR.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SPIRIT_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.ASH.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.CLOTH.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.SOUL.get(), ModelTemplates.FLAT_ITEM);

        this.generateFlatItem(ModItems.RUNE_A.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_B.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_C.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_D.get(), ModelTemplates.FLAT_ITEM);
        // this.generateFlatItem(ModItems.RUNE_E.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_F.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_G.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_H.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_I.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_J.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_K.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_L.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_M.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_N.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_O.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_P.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_Q.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_R.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_S.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_T.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_U.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_V.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_W.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_X.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_Y.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_Z.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_DMG.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_FRE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_HRD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RUNE_PTL.get(), ModelTemplates.FLAT_ITEM);

        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_A.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_B.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_C.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_D.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        // this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_E.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_F.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_G.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_H.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_I.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_J.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_K.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_L.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_M.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_N.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_O.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_P.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_Q.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_R.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_S.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_T.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_U.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_V.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_W.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_X.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_Y.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(ModItems.PORTABLE_RUNE_STONE_Z.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        this.generateFlatItem(ModItems.MAGICAL_CAP.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.MAGICAL_ROBE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.MAGICAL_PANTS.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.MAGICAL_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(ModItems.RITUAL_DAGGER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
    }

}
