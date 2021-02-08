package ca.retrylife.blood_cod_plugins.items;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CodWater extends ItemStack {

    public CodWater(int quantity) {
        super(Material.POTION, quantity, (short) 1, (byte) 0);

        // Configure the item
        ItemMeta meta = super.getItemMeta();
        meta.setDisplayName("Tank Water of Cod");
        meta.setLore(Arrays.asList("A little muddy", "Tastes like the color brown"));

        super.setItemMeta(meta);
    }

}