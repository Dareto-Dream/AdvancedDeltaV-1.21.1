package com.deltavdevs.advanceddeltav.block;

import com.deltavdevs.advanceddeltav.AdvancedDeltaV;
import com.deltavdevs.advanceddeltav.block.custom.LavaLamp;
import com.deltavdevs.advanceddeltav.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(AdvancedDeltaV.MODID);

    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final DeferredBlock<Block> RED_LAVA_LAMP = registerBlock("red_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> ORANGE_LAVA_LAMP = registerBlock("orange_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> YELLOW_LAVA_LAMP = registerBlock("yellow_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> LIME_LAVA_LAMP = registerBlock("lime_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> GREEN_LAVA_LAMP = registerBlock("green_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> CYAN_LAVA_LAMP = registerBlock("cyan_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> LIGHT_BLUE_LAVA_LAMP = registerBlock("light_blue_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> BLUE_LAVA_LAMP = registerBlock("blue_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> PURPLE_LAVA_LAMP = registerBlock("purple_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> MAGENTA_LAVA_LAMP = registerBlock("magenta_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));
    public static final DeferredBlock<Block> PINK_LAVA_LAMP = registerBlock("pink_lava_lamp",
            () -> new LavaLamp(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(1f)
                    .sound(SoundType.LANTERN)
            ));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
