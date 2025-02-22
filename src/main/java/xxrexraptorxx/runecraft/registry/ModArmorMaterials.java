package xxrexraptorxx.runecraft.registry;

import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import xxrexraptorxx.runecraft.main.References;

import java.util.EnumMap;

public class ModArmorMaterials {

    public static final TagKey<Item> REPAIR_MATERIALS_MAGICAL = ItemTags.create(ResourceLocation.fromNamespaceAndPath(References.MODID, "repair_materials_magical"));

    public static final net.minecraft.world.item.equipment.ArmorMaterial BEDROCK_ARMOR_MATERIAL = new net.minecraft.world.item.equipment.ArmorMaterial(
            // The durability multiplier of the armor material.
            // ArmorType have different unit durabilities that the multiplier is applied to:
            // - HELMET: 11
            // - CHESTPLATE: 16
            // - LEGGINGS: 15
            // - BOOTS: 13
            // - BODY: 16
            50,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 1);
                map.put(ArmorType.LEGGINGS, 2);
                map.put(ArmorType.CHESTPLATE, 2);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 2);
            }),
            30,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            REPAIR_MATERIALS_MAGICAL,
            ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.fromNamespaceAndPath(References.MODID, "magical"))
    );

}