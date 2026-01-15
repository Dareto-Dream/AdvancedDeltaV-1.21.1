package com.deltavdevs.advanceddeltav.item;

import com.deltavdevs.advanceddeltav.AdvancedDeltaV;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AdvancedDeltaV.MODID);

    public static final DeferredItem<Item> ROCKET_CONTROL_CHIP = ITEMS.register("rocket_control_chip",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
