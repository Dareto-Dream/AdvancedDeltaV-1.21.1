package com.deltavdevs.advanceddeltav.item;

import com.deltavdevs.advanceddeltav.AdvancedDeltaV;
import com.deltavdevs.advanceddeltav.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AdvancedDeltaV.MODID);

    public static final Supplier<CreativeModeTab> ROCKET_BLOCKS_TAB = CREATIVE_MODE_TAB.register("rocket_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL.get()))
                    .title(Component.translatable("creativetab.advanceddeltav.rocket_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.STEEL_BLOCK);
                    }).build());

    public static final Supplier<CreativeModeTab> ROCKET_PARTS_TAB = CREATIVE_MODE_TAB.register("rocket_parts_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(AdvancedDeltaV.MODID, "rocket_blocks_tab"))
                    .title(Component.translatable("creativetab.advanceddeltav.rocket_parts"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.STEEL);
                        output.accept(ModItems.ROCKET_CONTROL_CHIP);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
