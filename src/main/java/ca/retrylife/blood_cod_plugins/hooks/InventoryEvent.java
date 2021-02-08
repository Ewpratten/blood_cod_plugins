package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.Color;
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

        // Allocate an array for the player's full set of clothing
        ItemStack[] clothing = new ItemStack[] { event.getPlayer().getInventory().getHelmet(),
                event.getPlayer().getInventory().getChestplate(), event.getPlayer().getInventory().getLeggings(),
                event.getPlayer().getInventory().getBoots(),

        };

        // Ensure every single armor slot is red leather, otherwise, skip the
        // advancement
        for (ItemStack itemStack : clothing) {

            // Skip if null
            if (itemStack == null) {
                return;
            }

            // Skip if not leather
            if (!itemStack.getType().toString().contains("LEATHER")
                    || !(itemStack.getItemMeta() instanceof LeatherArmorMeta)) {
                return;
            }

            // Skip if not red
            if (!((LeatherArmorMeta) itemStack.getItemMeta()).getColor().equals(RED_DYE_COLOR)) {
                return;
            }

        }

        // Award the advancement
        AdvancementRegistry.getInstance().awardAdvancementToPlayer((Player) event.getPlayer(), AdvancementList.ROBE_UP);

    }

}