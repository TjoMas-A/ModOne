package com.tjomas_a.modone.network.message;

import com.tjomas_a.modone.tileentity.MOTileEntity;
import com.tjomas_a.modone.tileentity.StoneChestTileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessageStoneChestTileEntity implements IMessage, IMessageHandler<MessageStoneChestTileEntity, IMessage>
{

    public int x, y, z;
    public byte orientation;
    public byte state;
    public String customName, owner;

    public MessageStoneChestTileEntity()
    {

    }

    public MessageStoneChestTileEntity(StoneChestTileEntity stoneChestTileEntity)
    {
        this.x = stoneChestTileEntity.xCoord;
        this.y = stoneChestTileEntity.yCoord;
        this.z = stoneChestTileEntity.zCoord;
        this.orientation = (byte) stoneChestTileEntity.getOrientation().ordinal();
        this.state = (byte) stoneChestTileEntity.getState();
        this.customName = stoneChestTileEntity.getCustomName();
        this.owner = stoneChestTileEntity.getOwner();
    }

    /**
     * Convert from supplied buffer into specific message type
     *
     * @param buf
     */

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        int ownerLength = buf.readInt();
        this.owner = new String(buf.readBytes(ownerLength).array());
    }

    /**
     * Deconstruct message to the supplied byte buffer
     *
     * @param buf
     */

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        buf.writeInt(owner.length());
        buf.writeBytes(owner.getBytes());
    }

    /**
     * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
     * is needed.
     *
     * @param message The message
     * @param ctx
     * @return an optional return message
     */

    @Override
    public IMessage onMessage(MessageStoneChestTileEntity message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof MOTileEntity)
        {
            ((MOTileEntity) tileEntity).setOrientation(message.orientation);
            ((MOTileEntity) tileEntity).setState(message.state);
            ((MOTileEntity) tileEntity).setCustomName(message.customName);
            ((MOTileEntity) tileEntity).setOwner(message.owner);

        }

        return null;

    }

}
