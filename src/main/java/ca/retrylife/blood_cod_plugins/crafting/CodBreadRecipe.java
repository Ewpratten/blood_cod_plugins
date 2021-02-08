package ca.retrylife.blood_cod_plugins.crafting;

import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

import ca.retrylife.blood_cod_plugins.items.CodBread;

public class CodBreadRecipe extends ShapedRecipe {

    @SuppressWarnings("deprecation")
    public CodBreadRecipe() {
        super(new CodBread(1));

        // Configure recipe
        super.shape("BC");
        super.setIngredient('B', Material.BREAD);
        super.setIngredient('C', Material.COD);
    }
    
}