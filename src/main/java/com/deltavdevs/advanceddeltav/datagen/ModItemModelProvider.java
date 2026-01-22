package com.deltavdevs.advanceddeltav.datagen;

import com.deltavdevs.advanceddeltav.AdvancedDeltaV;
import com.deltavdevs.advanceddeltav.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdvancedDeltaV.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.SMALL_CHIP_BASE.get());
    }
}