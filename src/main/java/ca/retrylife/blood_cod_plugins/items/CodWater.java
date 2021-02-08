package ca.retrylife.blood_cod_plugins.items;

import java.util.Arrays;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

public class CodWater extends ItemStack {

    public CodWater(int quantity) {
        super(Material.POTION, quantity);

        // Configure the item lore
        ItemMeta meta = super.getItemMeta();
        meta.setDisplayName("Tank Water of Cod");
        meta.setLore(Arrays.asList("A little muddy", "Tastes like the color brown"));

        // Configure the potion data
        PotionMeta potionMeta = (PotionMeta) meta;
        PotionData potionData = new PotionData(PotionType.WATER);
        potionMeta.setBasePotionData(potionData);
        potionMeta.setColor(Color.fromRGB(8606770));

        super.setItemMeta(meta);
    }

}