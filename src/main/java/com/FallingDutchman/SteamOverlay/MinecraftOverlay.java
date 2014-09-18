package com.FallingDutchman.SteamOverlay;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import com.FallingDutchman.SteamOverlay.Util.References;


@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.VERSION)
public class MinecraftOverlay
{
    @Instance
    public static MinecraftOverlay instance;

    @EventHandler
    public void onInit(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new KeyRegister());
    }
}
