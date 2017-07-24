package pw.valaria.norecipebookcrafting;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.*;
import com.comphenix.protocol.reflect.StructureModifier;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;

public final class NoRecipeBookCrafting extends JavaPlugin {

    @Override
    public void onEnable() {
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        protocolManager.addPacketListener(new PacketAdapter(this, ListenerPriority.HIGH, PacketType.Play.Client.AUTO_RECIPE) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                event.setCancelled(true);
                /* // it refused to listen to me...
                PacketContainer packet = event.getPacket();



                Integer windowId = packet.getIntegers().getValues().get(0);
                Short action = packet.getShorts().getValues().get(0);


                PacketContainer packetContainer = new PacketContainer(PacketType.Play.Server.TRANSACTION);
                packetContainer.getIntegers().write(0, windowId);
                packetContainer.getShorts().write(0, action);
                packetContainer.getBooleans().write(0, false);
                //System.out.println(packetContainer.toString());

                //System.out.println(windowId);
                //System.out.println(action);

                try {
                    protocolManager.sendServerPacket(event.getPlayer(), packetContainer);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                */

                // so we do this instead....
                event.getPlayer().updateInventory();

            }
        });


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
