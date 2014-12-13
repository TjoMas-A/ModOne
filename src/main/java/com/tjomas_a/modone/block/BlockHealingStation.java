package com.tjomas_a.modone.block;


import com.tjomas_a.modone.reference.Names;
import com.tjomas_a.modone.tileentity.ModOneTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHealingStation extends BlockMO
{
    public BlockHealingStation()
    {
        super();
        this.setBlockName(Names.Blocks.HEAL);
        this.setBlockTextureName(Names.Blocks.HEAL);
        this.setResistance(10.0f);
        this.setHardness(1.5f);
        this.setLightLevel(0.4f);
    }

    public TileEntity createTileEntity(World world, int metadata)
    {
        return new ModOneTileEntity();
    }
}
