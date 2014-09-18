package com.FallingDutchman.SteamOverlay;

import com.FallingDutchman.SteamOverlay.Client.Gui.MoGui;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeyRegister
{
    public static KeyBinding MO = new KeyBinding("Open Minecraft Overlay", Keyboard.KEY_I, "key.categories.misc");

    static {
        ClientRegistry.registerKeyBinding(MO);
    }

    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event)
    {
        Minecraft mc = Minecraft.getMinecraft();
        if(MO.isPressed() && mc.currentScreen == null){
            mc.displayGuiScreen(new MoGui());
        }
    }
}
