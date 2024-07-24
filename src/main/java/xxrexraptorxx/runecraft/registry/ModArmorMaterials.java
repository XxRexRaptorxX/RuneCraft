package xxrexraptorxx.runecraft.registry;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import xxrexraptorxx.runecraft.main.References;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {

    private static final DeferredRegister<ArmorMaterial> MATERIAL = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, References.MODID);


    public static void init(IEventBus bus) {
        MATERIAL.register(bus);
    }


    public static final Holder<ArmorMaterial> MAGICAL = MATERIAL.register("magical", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 2);
                map.put(ArmorItem.Type.CHESTPLATE, 2);
                map.put(ArmorItem.Type.HELMET, 1);
            }),
            30, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(ModItems.CLOTH), List.of(
                    new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(References.MODID, "magical"))), 0.0F, 0));


}