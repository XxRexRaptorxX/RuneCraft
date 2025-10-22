package xxrexraptorxx.runecraft.world;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctions;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.List;
import java.util.function.Supplier;

//setblock ~ ~ ~ minecraft:chest{LootTable:"minecraft:chests/stronghold_library"}
public class ChestLootEnhancerModifier extends LootModifier {

    public static final Supplier<MapCodec<ChestLootEnhancerModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
            .and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(m -> m.item)).and(Codec.INT.optionalFieldOf("count", -1).forGetter(m -> m.count))
            .and(Codec.INT.optionalFieldOf("min_count", -1).forGetter(m -> m.minCount)).and(Codec.INT.optionalFieldOf("max_count", -1).forGetter(m -> m.maxCount))
            .and(LootItemFunctions.CODEC.listOf().optionalFieldOf("functions", List.of()).forGetter(m -> m.functions)).apply(inst, ChestLootEnhancerModifier::new)));

    private final Item item;
    private final int count;
    private final int minCount;
    private final int maxCount;
    private final List<Holder<LootItemFunction>> functions;

    public ChestLootEnhancerModifier(LootItemCondition[] conditionsIn, Item item, int count, int minCount, int maxCount, List<Holder<LootItemFunction>> functions) {
        super(conditionsIn);
        this.item = item;
        this.count = count;
        this.minCount = minCount;
        this.maxCount = maxCount;
        this.functions = functions;
    }


    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        RandomSource random = context.getRandom();
        int itemCount;

        if (count >= 0) {
            itemCount = count;
        } else if (minCount >= 0 && maxCount >= 0) {
            itemCount = random.nextIntBetweenInclusive(minCount, maxCount);
        } else {
            // Fallback to a default value if neither count nor range is specified
            itemCount = 1;
        }

        ItemStack itemToAdd = new ItemStack(item, itemCount);

        for (Holder<LootItemFunction> functionHolder : functions) {
            LootItemFunction function = functionHolder.value();
            itemToAdd = function.apply(itemToAdd, context);
        }

        generatedLoot.add(itemToAdd);
        return generatedLoot;
    }


    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
