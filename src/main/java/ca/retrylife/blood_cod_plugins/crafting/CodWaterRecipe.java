package ca.retrylife.blood_cod_plugins.crafting;

import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

import ca.retrylife.blood_cod_plugins.items.CodWater;

public class CodWaterRecipe extends ShapedRecipe {

    @SuppressWarnings("deprecation")
    public CodWaterRecipe() {
        super(new CodWater(1));

        // Configure recipe
        super.shape("BC");
        super.setIngredient('B', Material.POTION);
        super.setIngredient('C', Material.COD);
    }
    
}