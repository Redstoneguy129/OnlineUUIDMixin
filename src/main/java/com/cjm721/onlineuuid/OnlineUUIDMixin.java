package com.cjm721.onlineuuid;


import com.mojang.authlib.GameProfile;
import net.minecraft.network.login.INetHandlerLoginServer;
import net.minecraft.server.network.NetHandlerLoginServer;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.server.FMLServerHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.UUID;

//@Mixin(NetHandlerLoginServer.class)
public abstract class OnlineUUIDMixin implements INetHandlerLoginServer, ITickable {
    //@Overwrite
    protected GameProfile getOfflineProfile(GameProfile original)
    {
        UUID uuid = FMLServerHandler.instance().getServer().getPlayerProfileCache().getGameProfileForUsername(original.getName()).getId();
        return new GameProfile(uuid, original.getName());
    }
}
