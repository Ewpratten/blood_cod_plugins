package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;
import ca.retrylife.blood_cod_plugins.registry.AdvancementRegistry;
import ca.retrylife.blood_cod_plugins.registry.RegionRegistry;

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

        // Check for player entering main church
        if (RegionRegistry.getInstance().getRegion("overworld:church").contains(newBlockPose)) {

            // Award advancement
            AdvancementRegistry.getInstance().awardAdvancementToPlayer(event.getPlayer(), AdvancementList.ENTER_CHURCH);

        }

        // Check for player entering bloodland
        if (RegionRegistry.getInstance().getRegion("overworld:bloodland").contains(newBlockPose)) {

            // Award advancement
            AdvancementRegistry.getInstance().awardAdvancementToPlayer(event.getPlayer(), AdvancementList.BLOODLAND);

        }

        // Check for player entering an opposing church
        if (RegionRegistry.getInstance().getRegion("overworld:percy_church").contains(newBlockPose)
                || RegionRegistry.getInstance().getRegion("overworld:common_church").contains(newBlockPose)) {

            // Award advancement
            AdvancementRegistry.getInstance().awardAdvancementToPlayer(event.getPlayer(), AdvancementList.DEFECTOR);

        }

    }

}