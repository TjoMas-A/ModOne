package com.tjomas_a.modone.client.gui;

import com.tjomas_a.modone.inventory.ContainerStoneChest;
import com.tjomas_a.modone.reference.Colours;
import com.tjomas_a.modone.reference.Names;
import com.tjomas_a.modone.reference.Textures;
import com.tjomas_a.modone.tileentity.StoneChestTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiStoneChest extends GuiContainer
{
    private StoneChestTileEntity stoneChestTileEntity;

    public GuiStoneChest(InventoryPlayer inventoryPlayer, StoneChestTileEntity stoneChest)
    {
        super(new ContainerStoneChest(inventoryPlayer, stoneChest));
        stoneChestTileEntity = stoneChest;

        if (this.stoneChestTileEntity.getState() == 0)
        {
            xSize = 704;
            ySize = 672;
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        if (stoneChestTileEntity.getState() == 0 || stoneChestTileEntity.getState() == 1)
        {
            fontRendererObj.drawString(StatCollector.translateToLocal(stoneChestTileEntity.getInventoryName()), 8, 6, Integer.parseInt(Colours.PURE_WHITE, 16));
            fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 35, ySize - 95 + 2, Integer.parseInt(Colours.PURE_WHITE, 16));
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        if (stoneChestTileEntity.getState() == 0)
        {
            this.mc.getTextureManager().bindTexture(Textures.Gui.STONE_CHEST);
        }

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }

}
