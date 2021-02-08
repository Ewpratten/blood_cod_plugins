package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;
import ca.retrylife.blood_cod_plugins.registry.AdvancementRegistry;
import ca.retrylife.blood_cod_plugins.registry.SmittenRegistry;

public class DeathEvent implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        // Get actor
        Player deadPlayer = event.getEntity();

        // Check if they are a known victim of a godlike player
        if (SmittenRegistry.getInstance().isFinalBlow(deadPlayer)) {
            Bukkit.getLogger().info(String.format("A final blow has been dealt to %s", deadPlayer.getName()));

            // Override death message
            event.setDeathMessage(String.format("The %sBlood Cod%s is displeased with %s",
                    ChatColor.BLACK.toString() + ChatColor.BOLD.toString(), ChatColor.RESET, deadPlayer.getName()));

            // Award the player their advancement
            AdvancementRegistry.getInstance().awardAdvancementToPlayer(deadPlayer, AdvancementList.ULTIMATE_SACRIFICE);

            // Play sound
            World world = deadPlayer.getWorld();
            world.playSound(deadPlayer.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0f, 1.0f);

        }

    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        // Get actor
        LivingEntity deadEntity = event.getEntity();

        // Ignore players
        if (deadEntity instanceof Player) {
            return;
        }

        // Check if they are a known victim of a godlike player
        if (SmittenRegistry.getInstance().isFinalBlow(deadEntity)) {
            Bukkit.getLogger().info(String.format("A final blow has been dealt to %s", deadEntity.getName()));

            // Play sound
            World world = deadEntity.getWorld();
            world.playSound(deadEntity.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0f, 1.0f);

        }

    }

}