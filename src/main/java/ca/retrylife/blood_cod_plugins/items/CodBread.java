package ca.retrylife.blood_cod_plugins.items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CodBread extends ItemStack {

    private static final String ITEM_NAME = "Bread of Cod";

    public CodBread(int quantity) {
        super(Material.BREAD, quantity);

        // Configure the item
        ItemMeta meta = super.getItemMeta();
        meta.setDisplayName(ITEM_NAME);
        meta.setLore(
                Arrays.asList("Tastes a little fishy", "May have been sitting in a shulker for a few weeks already"));

        super.setItemMeta(meta);
    }

    public static boolean isCodBread(ItemStack items) {
        return items.getItemMeta().getDisplayName().equals(ITEM_NAME);
    }

}