package ca.retrylife.blood_cod_plugins;

import kr.entree.spigradle.annotations.PluginMain;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

@PluginMain
public class BloodCodPluginMain extends JavaPlugin {

    public BloodCodPluginMain() {
    }

    public BloodCodPluginMain(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
    }

}