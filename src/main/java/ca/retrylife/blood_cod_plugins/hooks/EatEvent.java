package ca.retrylife.blood_cod_plugins.hooks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;
import ca.retrylife.blood_cod_plugins.items.CodBread;
import ca.retrylife.blood_cod_plugins.items.CodWater;
import ca.retrylife.blood_cod_plugins.registry.AdvancementRegistry;

public class EatEvent implements Listener {

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {

        // Get the consumed item
        ItemStack item = event.getItem();

        // Get the player
        Player player = event.getPlayer();

        // Skip if null
        if (item == null) {
            return;
        }

        // Award correct advancement
        if (CodBread.isCodBread(item)) {
            AdvancementRegistry.getInstance().awardAdvancementToPlayer(player, AdvancementList.NOT_BREAD);
        } else if (CodWater.isCodWater(item)) {
            AdvancementRegistry.getInstance().awardAdvancementToPlayer(player, AdvancementList.NOT_WATER);
        }

    }

}