package com.FallingDutchman.SteamOverlay.Client.Gui;

import com.FallingDutchman.SteamOverlay.Reference.References;
import net.minecraft.client.gui.GuiScreen;

import static org.lwjgl.opengl.GL11.*;

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
        return true;
    }

    public void drawScreen(int x, int y, float f)
    {
        final int MARGIN = this.width / 26;
        final int HEIGHTMARGIN = 25;
        final int ITEMWIDTH  = 150;
        final int ITEMHEIGHT = 175;

        this.drawDefaultBackground();

        drawOutlinedBox(MARGIN, this.height - HEIGHTMARGIN - ITEMHEIGHT, ITEMWIDTH, ITEMHEIGHT, 0x00888888, References.BOX_OUTLINE_COLOR);
        drawRect(MARGIN, this.height - HEIGHTMARGIN, MARGIN + ITEMWIDTH, this.height - HEIGHTMARGIN - ITEMHEIGHT, 0x99292929);

        drawOutlinedBox((this.width/2) - (ITEMWIDTH/2), this.height - HEIGHTMARGIN - ITEMHEIGHT, ITEMWIDTH, ITEMHEIGHT, 0x00888888, References.BOX_OUTLINE_COLOR);
        drawRect((this.width/2) - (ITEMWIDTH/2), this.height - HEIGHTMARGIN, (this.width/2) + (ITEMWIDTH/2), this.height - HEIGHTMARGIN - ITEMHEIGHT, 0x99292929);

        drawOutlinedBox(this.width - ITEMWIDTH - MARGIN,  this.height - HEIGHTMARGIN - ITEMHEIGHT, ITEMWIDTH, ITEMHEIGHT, 0x00888888, References.BOX_OUTLINE_COLOR);
        drawRect(this.width - ITEMWIDTH - MARGIN, this.height - HEIGHTMARGIN, this.width - MARGIN, this.height - HEIGHTMARGIN - ITEMHEIGHT, 0x99292929);

        super.drawScreen(x, y, f);
    }

    public void drawOutlinedBox(int x, int y, int width, int height, int color, int outlineColor) {
        glPushMatrix();
        glScalef(0.5F, 0.5F, 0.5F);
        drawRect(x * 2 - 2, y * 2 - 2, (x + width) * 2 + 2,(y + height) * 2 + 2, outlineColor);
        glPopMatrix();
    }
}
