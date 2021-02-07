package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementEvent implements Listener {

    @EventHandler
    public void handlePlayerMovement(PlayerMoveEvent event) {

        // Get needed data
        Location previousBlockPose = event.getFrom().getBlock().getLocation();
        Location newBlockPose = event.getTo().getBlock().getLocation();

        // Only look for block-to-block movement
        if (Math.abs(previousBlockPose.distance(newBlockPose)) == 0) {
            return;
        }

        

    }

}