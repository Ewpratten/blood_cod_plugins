package ca.retrylife.blood_cod_plugins;

import kr.entree.spigradle.annotations.PluginMain;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;
import ca.retrylife.blood_cod_plugins.crafting.CodBreadRecipe;
import ca.retrylife.blood_cod_plugins.crafting.CodWaterRecipe;
import ca.retrylife.blood_cod_plugins.hooks.ConnectionEvent;
import ca.retrylife.blood_cod_plugins.hooks.DeathEvent;
import ca.retrylife.blood_cod_plugins.hooks.InventoryEvent;
import ca.retrylife.blood_cod_plugins.hooks.MovementEvent;
import ca.retrylife.blood_cod_plugins.hooks.PunchEvent;
import ca.retrylife.blood_cod_plugins.registry.AdvancementRegistry;
import ca.retrylife.blood_cod_plugins.registry.RegionRegistry;
import ca.retrylife.blood_cod_plugins.registry.UserRegistry;

@PluginMain
public class BloodCodPluginMain extends JavaPlugin {

    public BloodCodPluginMain() {
    }

    public BloodCodPluginMain(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("The blood cod has blessed this server");

        // Register advancements
        try {

            // Register the root first
            AdvancementRegistry.getInstance().registerAdvancement(AdvancementList.ROOT);

            for (AdvancementList advancement : AdvancementList.values()) {
                AdvancementRegistry.getInstance().registerAdvancement(advancement);
            }

        } catch (IOException e) {
            Bukkit.getLogger().warning(
                    "Something went wrong while loading advancements for BCP. This plugin will be disabled. Contact the plugin author");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // Load Users
        try {
            UserRegistry.getInstance().load();
        } catch (IOException e) {
            Bukkit.getLogger().warning(
                    "Something went wrong while loading users for BCP. This plugin will be disabled. Contact the plugin author");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // Load Regions
        try {
            RegionRegistry.getInstance().load();
        } catch (IOException e) {
            Bukkit.getLogger().warning(
                    "Something went wrong while loading regions for BCP. This plugin will be disabled. Contact the plugin author");
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // Register event listeners
        getServer().getPluginManager().registerEvents(new ConnectionEvent(), this);
        getServer().getPluginManager().registerEvents(new PunchEvent(), this);
        getServer().getPluginManager().registerEvents(new MovementEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvent(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(), this);

        // Custom crafting
        getServer().addRecipe(new CodBreadRecipe());
        // getServer().addRecipe(new CodWaterRecipe());


    }

}