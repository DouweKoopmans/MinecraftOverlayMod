package com.FallingDutchman.SteamOverlay.Client.Gui;

import com.FallingDutchman.SteamOverlay.Util.FormattingCode;
import com.FallingDutchman.SteamOverlay.Util.References;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class MoGui extends GuiScreen
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
        final int LABELHEIGHT = 15;
        final int TEXTOFFSET = 4;

        this.drawDefaultBackground();
        /*
        * draw the gui boxes
        */
        FontRenderer fr = mc.fontRenderer;
        drawSolidGradientRect(
                MARGIN,
                this.height - ITEMHEIGHT - HEIGHTMARGIN - LABELHEIGHT,
                MARGIN + ITEMWIDTH,
                this.height - HEIGHTMARGIN,
                References.GUI_COLOR_ONE, References.GUI_COLOR_TWO);

        drawSolidGradientRect(
                (this.width / 2) - (ITEMWIDTH / 2),
                this.height - ITEMHEIGHT - HEIGHTMARGIN - LABELHEIGHT,
                (this.width / 2) + (ITEMWIDTH / 2),
                this.height - HEIGHTMARGIN,
                References.GUI_COLOR_ONE, References.GUI_COLOR_TWO);

        drawSolidGradientRect(
                this.width - ITEMWIDTH - MARGIN,
                this.height - HEIGHTMARGIN - ITEMHEIGHT - LABELHEIGHT,
                this.width - MARGIN,
                this.height - HEIGHTMARGIN,
                References.GUI_COLOR_ONE, References.GUI_COLOR_TWO);
        /*
        * draw label text
        */
        String Screenshots = FormattingCode.ITALICS + "ScreenShots";
        drawCenteredString(fr ,
                Screenshots,
                this.width/2,
                this.height - HEIGHTMARGIN - ITEMHEIGHT - (LABELHEIGHT/2) - TEXTOFFSET,
                0xFFFFFF);

        String Players = FormattingCode.ITALICS + "Other players";
        drawCenteredString(fr ,
                Players, MARGIN + ITEMWIDTH/2,
                this.height - HEIGHTMARGIN - ITEMHEIGHT - (LABELHEIGHT/2) - TEXTOFFSET,
                0xFFFFFF);

        String PMessages = FormattingCode.ITALICS + "Active Conversations";
        drawCenteredString(fr ,
                PMessages,
                this.width - MARGIN - ITEMWIDTH/2,
                this.height - HEIGHTMARGIN - ITEMHEIGHT - (LABELHEIGHT/2) - TEXTOFFSET,
                0xFFFFFF);

        super.drawScreen(x, y, f);
    }

    public void drawSolidGradientRect(int vertex1, int vertex2, int vertex3,int vertex4, int ColorOne, int ColorTwo) {

        glPushMatrix();
        Color color1 = new Color(ColorOne);
        Color color2 = new Color(ColorTwo);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        Tessellator tess = Tessellator.instance;
        glDisable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glShadeModel(GL_SMOOTH);
        tess.startDrawingQuads();
        tess.setColorOpaque(color1.getRed(), color1.getGreen(), color1.getBlue());
        tess.addVertex(vertex1, vertex4, zLevel);
        tess.addVertex(vertex3, vertex4, zLevel);
        tess.setColorOpaque(color2.getRed(), color2.getGreen(), color2.getBlue());
        tess.addVertex(vertex3, vertex2, zLevel);
        tess.addVertex(vertex1, vertex2, zLevel);
        tess.draw();
        glEnable(GL_TEXTURE_2D);
        glPopMatrix();
    }
}
