package com.FallingDutchman.SteamOverlay;

import com.FallingDutchman.SteamOverlay.Client.Gui.SoGui;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class KeyRegister
{
    public static KeyBinding SO = new KeyBinding("Steam Overlay", Keyboard.KEY_I, "key.categories.misc");

    static {
        ClientRegistry.registerKeyBinding(SO);
    }

    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event)
    {
        Minecraft mc = Minecraft.getMinecraft();
        if(SO.isPressed() && mc.currentScreen == null){
            mc.displayGuiScreen(new SoGui());
        }
    }
}
