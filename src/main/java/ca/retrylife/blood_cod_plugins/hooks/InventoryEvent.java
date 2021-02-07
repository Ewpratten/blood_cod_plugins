package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;
import ca.retrylife.blood_cod_plugins.registry.AdvancementRegistry;

public class InventoryEvent implements Listener {

    // Dye colors
    private static final Color RED_DYE_COLOR = Color.fromRGB(176, 46, 38);

    @EventHandler
    public void handlePlayerInventoryAction(InventoryCloseEvent event) {

        // Get the clothes of the player
        ItemStack helmet = event.getPlayer().getInventory().getHelmet();
        ItemStack chest = event.getPlayer().getInventory().getChestplate();
        ItemStack legs = event.getPlayer().getInventory().getLeggings();
        ItemStack boots = event.getPlayer().getInventory().getBoots();

        // Ensure the correct clothes are worn
        if (
        // @formatter:off
            helmet.getType().equals(Material.LEATHER_HELMET) &&
            chest.getType().equals(Material.LEATHER_CHESTPLATE) &&
            legs.getType().equals(Material.LEATHER_LEGGINGS) &&
            boots.getType().equals(Material.LEATHER_BOOTS) 
        // @formatter:on
        ) {

            // Ensure everything is the correct color
            if (
            // @formatter:off
                ((LeatherArmorMeta) helmet.getItemMeta()).getColor().equals(RED_DYE_COLOR) &&
                ((LeatherArmorMeta) chest.getItemMeta()).getColor().equals(RED_DYE_COLOR) &&
                ((LeatherArmorMeta) legs.getItemMeta()).getColor().equals(RED_DYE_COLOR) &&
                ((LeatherArmorMeta) boots.getItemMeta()).getColor().equals(RED_DYE_COLOR) 
            // @formatter:on
            ) {

                // Award the player their new advancement
                AdvancementRegistry.getInstance().awardAdvancementToPlayer((Player) event.getPlayer(), AdvancementList.ROBE_UP);

            }

        }

    }

}