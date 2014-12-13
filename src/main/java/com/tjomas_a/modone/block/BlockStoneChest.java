package com.tjomas_a.modone.block;

import com.tjomas_a.modone.reference.Names;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockStoneChest extends BlockMO implements ITileEntityProvider
{
    public BlockStoneChest()
    {
        super();
        this.setBlockName(Names.Blocks.CHEST);
        this.setBlockTextureName(Names.Blocks.CHEST);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return null;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}
