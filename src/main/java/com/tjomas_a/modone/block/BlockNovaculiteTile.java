package com.tjomas_a.modone.block;

import com.tjomas_a.modone.reference.Names;

public class BlockNovaculiteTile extends BlockMO
{
    public BlockNovaculiteTile()
    {
        super();
        this.setBlockName(Names.Blocks.NOVA_TILE);
        this.setBlockTextureName(Names.Blocks.NOVA_TILE);
        this.setHardness(2.5F);
        this.setResistance(75.0F);
    }
}
