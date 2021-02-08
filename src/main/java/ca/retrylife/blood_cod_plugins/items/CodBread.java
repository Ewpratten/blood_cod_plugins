package ca.retrylife.blood_cod_plugins.items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CodBread extends ItemStack {

    public CodBread(int quantity) {
        super(Material.BREAD, quantity);

        // Configure the item
        ItemMeta meta = super.getItemMeta();
        meta.setDisplayName("Bread of Cod");
        meta.setLore(Arrays.asList(
            "Tastes a little fishy",
            "May have been sitting in a shulker for a few weeks already"
        ));

        super.setItemMeta(meta);
    }
    
}