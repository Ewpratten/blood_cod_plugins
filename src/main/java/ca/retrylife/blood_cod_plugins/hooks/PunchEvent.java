package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;
import ca.retrylife.blood_cod_plugins.registry.AdvancementRegistry;
import ca.retrylife.blood_cod_plugins.registry.SmittenRegistry;
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

        // Get both actors
        Entity damager = event.getDamager();
        Entity damaged = event.getEntity();

        // Ensure the entities are Player and LivingEntity
        if (damager instanceof Player && damaged instanceof LivingEntity) {

            // Find the player's Permissions
            boolean isGodlike = UserRegistry.getInstance().doesPlayerHavePermission((Player) damager, "godlike");
            boolean isGod = UserRegistry.getInstance().doesPlayerHavePermission((Player) damager, "god");

            // Determine the damaged entity type
            boolean isDamagedPlayer = damaged instanceof Player;

            // The damager must be at least godlike to continue
            if (isGod || (isGodlike && isDamagedPlayer)) {

                // Get the world of the damaged entity
                World world = damaged.getWorld();

                // Give fire resistance to the damaged
                ((LivingEntity) damaged)
                        .addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20 * 7, 3, false, false));

                // Give health boost to the damager
                ((Player) damager)
                        .addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 14, 20, false, false));
                ((Player) damager)
                        .addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20 * 14, 20, false, false));

                // Smite the damaged
                Bukkit.getLogger().info(String.format("%s has felt the power of nature", damaged.getName()));
                world.strikeLightning(damaged.getLocation());

                // Play extra sounds
                world.playSound(damaged.getLocation(), Sound.ITEM_TRIDENT_THUNDER, 1.0f, 1.0f);

                // Award advancement to the damager
                AdvancementRegistry.getInstance().awardAdvancementToPlayer((Player) damager,
                        AdvancementList.ENLIGHTENMENT);

                // Possibly award advancement to the damaged
                if (isDamagedPlayer) {
                    AdvancementRegistry.getInstance().awardAdvancementToPlayer((Player) damaged,
                            AdvancementList.ENLIGHTENMENT);
                }

                // Keep track of the damaged
                SmittenRegistry.getInstance().setMostRecentVictim((LivingEntity) damaged);

            }

        }

    }

}