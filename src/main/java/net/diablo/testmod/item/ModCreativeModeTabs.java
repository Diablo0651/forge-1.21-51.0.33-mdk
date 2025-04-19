package net.diablo.testmod.item;

import net.diablo.testmod.TestMod;
import net.diablo.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEM_TABS = CREATIVE_MODE_TABS.register("alexandrite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .title(Component.translatable("creativetab.testmod.alexandrite_items"))
                    .displayItems((itemDisplayParameters, output)-> {
                       output.accept(ModItems.ALEXANDRITE.get());
                       output.accept(ModItems.RAW_ALEXANDRITE.get());

                       output.accept(ModItems.CHISEL.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCKS_TABS = CREATIVE_MODE_TABS.register("alexandrite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .withTabsBefore(ALEXANDRITE_ITEM_TABS.getId())
                    .title(Component.translatable("creativetab.testmod.alexandrite_blocks"))
                    .displayItems((itemDisplayParameters, output)-> {
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

                    }).build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
