package com.tjomas_a.modone.block;

public class BlockHealingStation extends BlockMO
{
    public BlockHealingStation()
    {
        super();
        this.setBlockName("healingStation");
        this.setBlockTextureName("healingStation");
        this.setResistance(10.0f);
        this.setHardness(1.5f);
        this.setLightLevel(0.4f);
    }
}
