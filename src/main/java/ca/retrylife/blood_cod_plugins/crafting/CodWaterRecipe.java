package ca.retrylife.blood_cod_plugins.crafting;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

import ca.retrylife.blood_cod_plugins.items.CodWater;

public class CodWaterRecipe extends ShapedRecipe {

    @SuppressWarnings("deprecation")
    public CodWaterRecipe() {
        super(new NamespacedKey("bcp", "cod_water_crafting"), new CodWater(1));

        // Configure recipe
        super.shape("BC");
        super.setIngredient('B', Material.GLASS_BOTTLE);
        super.setIngredient('C', Material.COD);
    }
    
}