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

    public static final Supplier<CreativeModeTab> BASICS_TAB = CREATIVE_MODE_TAB.register("basics_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STEEL.get()))
                    .title(Component.translatable("creativetab.advanceddeltav.basics"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.STEEL_BLOCK);
                        output.accept(ModItems.STEEL);
                        output.accept(ModItems.SMALL_CHIP_BASE);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
