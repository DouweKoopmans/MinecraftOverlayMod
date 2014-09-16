package com.FallingDutchman.SteamOverlay.Client.Gui;

import com.FallingDutchman.SteamOverlay.Reference.FormattingCode;
import com.FallingDutchman.SteamOverlay.Reference.References;
import net.minecraft.client.gui.FontRenderer;
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
        /*
        * draw the gui boxes and borders
        */
        FontRenderer fr = mc.fontRenderer;
        drawOutlinedBox(MARGIN, this.height - HEIGHTMARGIN - ITEMHEIGHT, ITEMWIDTH, ITEMHEIGHT, 0x00888888, References.BOX_OUTLINE_COLOR);
        drawRect(MARGIN, this.height - HEIGHTMARGIN, MARGIN + ITEMWIDTH, this.height - HEIGHTMARGIN - ITEMHEIGHT, 0x99292929);

        drawOutlinedBox((this.width/2) - (ITEMWIDTH/2), this.height - HEIGHTMARGIN - ITEMHEIGHT, ITEMWIDTH, ITEMHEIGHT, 0x00888888, References.BOX_OUTLINE_COLOR);
        drawRect((this.width/2) - (ITEMWIDTH/2), this.height - HEIGHTMARGIN, (this.width/2) + (ITEMWIDTH/2), this.height - HEIGHTMARGIN - ITEMHEIGHT, 0x99292929);

        drawOutlinedBox(this.width - ITEMWIDTH - MARGIN,  this.height - HEIGHTMARGIN - ITEMHEIGHT, ITEMWIDTH, ITEMHEIGHT, 0x00888888, References.BOX_OUTLINE_COLOR);
        drawRect(this.width - ITEMWIDTH - MARGIN, this.height - HEIGHTMARGIN, this.width - MARGIN, this.height - HEIGHTMARGIN - ITEMHEIGHT, 0x99292929);

        /*
        * draw labels
        */

        final int LABELHEIGHT = 15;
        final int LABELOFFSET = 3;
        drawOutlinedBox(MARGIN, this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELHEIGHT - LABELOFFSET, ITEMWIDTH, LABELHEIGHT, 0x00888888, References.BOX_OUTLINE_COLOR);
        drawRect(MARGIN, this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELOFFSET, MARGIN + ITEMWIDTH, this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELHEIGHT - LABELOFFSET, 0x99292929);

        drawOutlinedBox((this.width/2) - (ITEMWIDTH/2), this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELHEIGHT - LABELOFFSET, ITEMWIDTH, LABELHEIGHT, 0x00888888, References.BOX_OUTLINE_COLOR);
        drawRect((this.width/2) - (ITEMWIDTH/2),this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELOFFSET, (this.width/2) + (ITEMWIDTH/2),this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELHEIGHT - LABELOFFSET, 0x99292929);

        drawOutlinedBox(this.width - ITEMWIDTH - MARGIN,this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELHEIGHT - LABELOFFSET,ITEMWIDTH ,LABELHEIGHT , 0x00888888, References.BOX_OUTLINE_COLOR);
        drawRect(this.width - ITEMWIDTH - MARGIN, this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELOFFSET, this.width - MARGIN,this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELHEIGHT - LABELOFFSET, 0x99292929);

        /*
        * add label text
        */
        String Screenshots = FormattingCode.ITALICS + "ScreenShots";
        drawCenteredString(fr ,Screenshots, this.width/2, this.height - HEIGHTMARGIN - ITEMHEIGHT - (LABELHEIGHT/2) - LABELOFFSET - 4, 0xFFFFFF);

        String Players = FormattingCode.ITALICS + "Other players";
        drawCenteredString(fr ,Players, MARGIN + ITEMWIDTH/2, this.height - HEIGHTMARGIN - ITEMHEIGHT - (LABELHEIGHT/2) - LABELOFFSET - 4, 0xFFFFFF);

        String PMessages = FormattingCode.ITALICS + "Active Conversations";
        drawCenteredString(fr ,PMessages,this.width - MARGIN - ITEMWIDTH/2, this.height - HEIGHTMARGIN - ITEMHEIGHT - (LABELHEIGHT/2) - LABELOFFSET - 4, 0xFFFFFF);

        super.drawScreen(x, y, f);
    }

    public void drawOutlinedBox(int x, int y, int width, int height, int color, int outlineColor) {
        glPushMatrix();
        glScalef(0.5F, 0.5F, 0.5F);
        drawRect(x * 2 - 2, y * 2 - 2, (x + width) * 2 + 2,(y + height) * 2 + 2, outlineColor);
        glPopMatrix();
    }
}
