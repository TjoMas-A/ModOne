package com.tjomas_a.modone.block;

import com.tjomas_a.modone.reference.Names;

public class BlockNovaculite extends BlockMO
{
    public BlockNovaculite()
    {
        super();
        this.setBlockName(Names.Blocks.NOVA);
        this.setBlockTextureName(Names.Blocks.NOVA);
        this.setHardness(2.5F);
        this.setResistance(75.0F);
    }
}