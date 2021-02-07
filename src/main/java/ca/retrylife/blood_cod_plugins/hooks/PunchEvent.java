package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;
import ca.retrylife.blood_cod_plugins.registry.AdvancementRegistry;
import ca.retrylife.blood_cod_plugins.registry.UserRegistry;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class PunchEvent implements Listener {

    @EventHandler
    public void handlePlayerPunchEvent(EntityDamageByEntityEvent event) {

        // Both actors must be players
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {

            // Get the two actors
            Player damager = (Player) event.getDamager();
            Player damaged = (Player) event.getEntity();

            // Check that the damager is godlike
            if (UserRegistry.getInstance().doesPlayerHavePermission(damager, "godlike")) {

                // Get the world the damaged player is in
                World world = damaged.getWorld();

                // Smite the damaged
                Bukkit.getLogger().info(String.format("Player %s has felt the power of nature", damaged.getName()));
                world.strikeLightning(damaged.getLocation());

                // Award the actors the corresponding advancement
                AdvancementRegistry.getInstance().awardAdvancementToPlayer(damager, AdvancementList.ENLIGHTENMENT);
                AdvancementRegistry.getInstance().awardAdvancementToPlayer(damaged, AdvancementList.ENLIGHTENMENT);

            }

        }

    }

}