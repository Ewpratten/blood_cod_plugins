package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;
import ca.retrylife.blood_cod_plugins.registry.AdvancementRegistry;
import ca.retrylife.blood_cod_plugins.registry.UserRegistry;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
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

                // Give fire resistance to the damaged
                damaged.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20 * 7, 3, false, false));

                // Smite the damaged
                Bukkit.getLogger().info(String.format("Player %s has felt the power of nature", damaged.getName()));
                world.strikeLightning(damaged.getLocation());

                // Award the actors the corresponding advancement
                AdvancementRegistry.getInstance().awardAdvancementToPlayer(damager, AdvancementList.ENLIGHTENMENT);
                AdvancementRegistry.getInstance().awardAdvancementToPlayer(damaged, AdvancementList.ENLIGHTENMENT);

                // Play an extra sound
                world.playSound(damaged.getLocation(), Sound.ITEM_TRIDENT_THUNDER, 1.0f, 1.0f);

            }

        }
        // This only works when debugging
        else if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity
                && event.getDamager().getUniqueId().toString().equals("390b7445-5d17-404b-a856-53235a3b185e")) {

            // Get the two actors
            Player damager = (Player) event.getDamager();
            Entity damaged = event.getEntity();

            // Check that the damager is godlike
            if (UserRegistry.getInstance().doesPlayerHavePermission(damager, "godlike")) {

                // Get the world the damaged player is in
                World world = damaged.getWorld();

                // Give fire resistance to the damaged
                ((LivingEntity) damaged)
                        .addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20 * 7, 3, false, false));

                // Smite the damaged
                Bukkit.getLogger().info(String.format("Player %s has felt the power of nature", damaged.getName()));
                world.strikeLightning(damaged.getLocation());

                // Award the actors the corresponding advancement
                AdvancementRegistry.getInstance().awardAdvancementToPlayer(damager, AdvancementList.ENLIGHTENMENT);

                // Play an extra sound
                world.playSound(damaged.getLocation(), Sound.ITEM_TRIDENT_THUNDER, 1.0f, 1.0f);

            }

        }

    }

}