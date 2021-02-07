package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;
import ca.retrylife.blood_cod_plugins.registry.AdvancementRegistry;

public class ConnectionEvent implements Listener {

    @EventHandler
    public void handlePlayerLogin(PlayerJoinEvent event) {

        // Grant the player the root advancement
        AdvancementRegistry.getInstance().awardAdvancementToPlayer(event.getPlayer(), AdvancementList.ROOT);
    }

}