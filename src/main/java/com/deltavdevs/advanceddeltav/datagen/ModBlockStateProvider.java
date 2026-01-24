package com.deltavdevs.advanceddeltav.datagen;

import com.deltavdevs.advanceddeltav.AdvancedDeltaV;
import com.deltavdevs.advanceddeltav.block.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import com.deltavdevs.advanceddeltav.block.custom.LavaLamp;
import org.jetbrains.annotations.NotNull;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AdvancedDeltaV.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.STEEL_BLOCK);
        lavaLampBlock(ModBlocks.RED_LAVA_LAMP);
        lavaLampBlock(ModBlocks.ORANGE_LAVA_LAMP);
        lavaLampBlock(ModBlocks.YELLOW_LAVA_LAMP);
        lavaLampBlock(ModBlocks.LIME_LAVA_LAMP);
        lavaLampBlock(ModBlocks.GREEN_LAVA_LAMP);
        lavaLampBlock(ModBlocks.CYAN_LAVA_LAMP);
        lavaLampBlock(ModBlocks.LIGHT_BLUE_LAVA_LAMP);
        lavaLampBlock(ModBlocks.BLUE_LAVA_LAMP);
        lavaLampBlock(ModBlocks.PURPLE_LAVA_LAMP);
        lavaLampBlock(ModBlocks.MAGENTA_LAVA_LAMP);
        lavaLampBlock(ModBlocks.PINK_LAVA_LAMP);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void lavaLampBlock(DeferredBlock<?> deferredBlock) {
        String name = deferredBlock.getId().getPath();

        var inactiveModel = createLavaLampModel(name, "off");
        var activeModel = createLavaLampModel(name, "on");

        getVariantBuilder(deferredBlock.get())
                .partialState().with(LavaLamp.ACTIVE, false)
                    .modelForState().modelFile(inactiveModel).addModel()
                .partialState().with(LavaLamp.ACTIVE, true)
                    .modelForState().modelFile(activeModel).addModel();

        simpleBlockItem(deferredBlock.get(), inactiveModel);
    }


    // Block Model Builders
    private BlockModelBuilder createLavaLampModel(String lampID, String state) {
        return models().getBuilder(lampID + "_" + state)
                .renderType("translucent")
                .texture("1", modLoc("block/" + lampID + "_" + state))
                .texture("particle", modLoc("block/" + lampID + "_off"))

                // Element 1: Top cap (5.5, 13, 5.5 to 10.5, 14, 10.5)
                .element()
                .from(5.5f, 13, 5.5f).to(10.5f, 14, 10.5f)
                .face(Direction.NORTH).uvs(11.5f, 11.5f, 14, 12).texture("#1").end()
                .face(Direction.EAST).uvs(12, 7.5f, 14.5f, 8).texture("#1").end()
                .face(Direction.SOUTH).uvs(12, 8, 14.5f, 8.5f).texture("#1").end()
                .face(Direction.WEST).uvs(12, 8.5f, 14.5f, 9).texture("#1").end()
                .face(Direction.UP).uvs(9.5f, 10.5f, 7, 8).texture("#1").end()
                .face(Direction.DOWN).uvs(11, 5, 8.5f, 7.5f).texture("#1").end()
                .end()

                // Element 2: Top section (6, 14, 6 to 10, 15, 10)
                .element()
                .from(6, 14, 6).to(10, 15, 10)
                .face(Direction.NORTH).uvs(0, 12.5f, 2, 13).texture("#1").end()
                .face(Direction.EAST).uvs(7, 12.5f, 9, 13).texture("#1").end()
                .face(Direction.SOUTH).uvs(9, 12.5f, 11, 13).texture("#1").end()
                .face(Direction.WEST).uvs(11, 12.5f, 13, 13).texture("#1").end()
                .face(Direction.UP).uvs(11.5f, 12, 9.5f, 10).texture("#1").end()
                .face(Direction.DOWN).uvs(9, 10.5f, 7, 12.5f).texture("#1").end()
                .end()

                // Element 3: Inner glass (6.5, 3, 6.5 to 9.5, 13, 9.5)
                .element()
                .from(6.5f, 3, 6.5f).to(9.5f, 13, 9.5f)
                .face(Direction.NORTH).uvs(7.5f, 0, 9, 5).texture("#1").end()
                .face(Direction.EAST).uvs(2.5f, 8, 4, 13).texture("#1").end()
                .face(Direction.SOUTH).uvs(4, 8, 5.5f, 13).texture("#1").end()
                .face(Direction.WEST).uvs(5.5f, 8, 7, 13).texture("#1").end()
                .face(Direction.UP).uvs(13, 3.5f, 11.5f, 2).texture("#1").end()
                .face(Direction.DOWN).uvs(13, 3.5f, 11.5f, 5).texture("#1").end()
                .end()

                // Element 4: Outer glass (5.5, 3, 5.5 to 10.5, 13, 10.5)
                .element()
                .from(5.5f, 3, 5.5f).to(10.5f, 13, 10.5f)
                .face(Direction.NORTH).uvs(0, 0, 2.5f, 5).texture("#1").end()
                .face(Direction.EAST).uvs(2.5f, 0, 5, 5).texture("#1").end()
                .face(Direction.SOUTH).uvs(0, 5, 2.5f, 10).texture("#1").end()
                .face(Direction.WEST).uvs(5, 0, 7.5f, 5).texture("#1").end()
                .face(Direction.UP).uvs(11.5f, 2.5f, 9, 0).texture("#1").end()
                .face(Direction.DOWN).uvs(11.5f, 2.5f, 9, 5).texture("#1").end()
                .end()

                // Element 5: Bottom ring (6, 1, 6 to 10, 2, 10)
                .element()
                .from(6, 1, 6).to(10, 2, 10)
                .face(Direction.NORTH).uvs(0, 13, 2, 13.5f).texture("#1").end()
                .face(Direction.EAST).uvs(2, 13, 4, 13.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(13, 2, 15, 2.5f).texture("#1").end()
                .face(Direction.WEST).uvs(13, 2.5f, 15, 3).texture("#1").end()
                .face(Direction.UP).uvs(13, 7, 11, 5).texture("#1").end()
                .face(Direction.DOWN).uvs(13.5f, 0, 11.5f, 2).texture("#1").end()
                .end()

                // Element 6: Bottom cap (5.5, 2, 5.5 to 10.5, 3, 10.5)
                .element()
                .from(5.5f, 2, 5.5f).to(10.5f, 3, 10.5f)
                .face(Direction.NORTH).uvs(9, 12, 11.5f, 12.5f).texture("#1").end()
                .face(Direction.EAST).uvs(12, 9, 14.5f, 9.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(12, 9.5f, 14.5f, 10).texture("#1").end()
                .face(Direction.WEST).uvs(11.5f, 12, 14, 12.5f).texture("#1").end()
                .face(Direction.UP).uvs(12, 10, 9.5f, 7.5f).texture("#1").end()
                .face(Direction.DOWN).uvs(2.5f, 10, 0, 12.5f).texture("#1").end()
                .end()

                // Element 7: Base (5, 0, 5 to 11, 1, 11)
                .element()
                .from(5, 0, 5).to(11, 1, 11)
                .face(Direction.NORTH).uvs(11, 7, 14, 7.5f).texture("#1").end()
                .face(Direction.EAST).uvs(11.5f, 10, 14.5f, 10.5f).texture("#1").end()
                .face(Direction.SOUTH).uvs(11.5f, 10.5f, 14.5f, 11).texture("#1").end()
                .face(Direction.WEST).uvs(11.5f, 11, 14.5f, 11.5f).texture("#1").end()
                .face(Direction.UP).uvs(5.5f, 8, 2.5f, 5).texture("#1").end()
                .face(Direction.DOWN).uvs(8.5f, 5, 5.5f, 8).texture("#1").end()
                .end()

                // Display transforms
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .translation(0, 3, 2).scale(0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .translation(0, 3, 2).scale(0.5f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .translation(0, 3, 0).scale(0.5f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .translation(0, 3, 0).scale(0.5f).end()
                .transform(ItemDisplayContext.GROUND)
                .translation(0, 2, 0).scale(0.5f).end()
                .transform(ItemDisplayContext.GUI)
                .rotation(0, -45, -45).translation(0.25f, 0.25f, 0).scale(0.8f).end()
                .transform(ItemDisplayContext.HEAD)
                .translation(-8, 0, 0).scale(0.6f).end()
                .end();
    }
}