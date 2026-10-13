package com.arslaanuzair.tokensmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.core.registry.Registry;
import net.minecraft.network.chat.Component;

public class TokensMod implements ModInitializer {
    public static final String MOD_ID = "tokensmod";

    public static final Item ENDERMAN_TOKEN = new EndermanTokenItem(new Item.Properties());
    public static final Item FIRE_TOKEN = new FireTokenItem(new Item.Properties());

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new ResourceLocation(MOD_ID, "enderman_token"), ENDERMAN_TOKEN);
        Registry.register(Registries.CREATIVE_MODE_TAB, new ResourceLocation(MOD_ID, "tokens_tab"), CreativeModeTabs.builder().title(Component.translatable("itemGroup.tokensmod.tokens")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> ENDERMAN_TOKEN.getDefaultInstance()).displayItems((parameters, output) -> {
            output.accept(ENDERMAN_TOKEN);
        }).build());
    }
}