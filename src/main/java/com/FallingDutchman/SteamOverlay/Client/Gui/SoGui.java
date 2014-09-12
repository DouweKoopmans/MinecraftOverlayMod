package com.FallingDutchman.SteamOverlay.Client.Gui;

import net.minecraft.client.gui.GuiScreen;

public class SoGui extends GuiScreen
{
    @Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        initGui();
        super.drawScreen(par1, par2, par3);
    }
}
