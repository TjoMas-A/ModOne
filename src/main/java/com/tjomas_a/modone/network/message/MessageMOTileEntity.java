package com.tjomas_a.modone.network.message;

import com.tjomas_a.modone.tileentity.MOTileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessageMOTileEntity implements IMessage, IMessageHandler<MessageMOTileEntity, IMessage>
{
    public int x, y, z;
    public byte orientation, state;
    public String customName, owner;

    public MessageMOTileEntity()
    {
    }

    public MessageMOTileEntity(MOTileEntity mOTileEntity)
    {
        this.x = mOTileEntity.xCoord;
        this.y = mOTileEntity.yCoord;
        this.z = mOTileEntity.zCoord;
        this.orientation = (byte) mOTileEntity.getOrientation().ordinal();
        this.state = (byte) mOTileEntity.getState();
        this.customName = mOTileEntity.getCustomName();
        this.owner = mOTileEntity.getOwner();
    }

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

    @Override
    public IMessage onMessage(MessageMOTileEntity message, MessageContext ctx)
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

    @Override
    public String toString()
    {
        return String.format("ModOneTileEntity - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
    }
}
