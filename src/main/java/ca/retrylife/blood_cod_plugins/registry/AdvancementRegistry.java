package ca.retrylife.blood_cod_plugins.registry;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;

import ca.retrylife.blood_cod_plugins.advancements.AdvancementList;

public class AdvancementRegistry {

    // Internal instance reference
    private static AdvancementRegistry instance = null;

    /**
     * Get the global instance of AdvancementRegistry
     *
     * @return AdvancementRegistry instance
     */
    public static AdvancementRegistry getInstance() {
        if (instance == null) {
            instance = new AdvancementRegistry();
        }
        return instance;
    }

    // Internal registry
    private HashMap<NamespacedKey, Advancement> advancements = new HashMap<NamespacedKey, Advancement>();

    // Hidden constructor to force singleton usage
    private AdvancementRegistry() {
    }

    /**
     * Register a custom advancement. JSON format is governed by:
     * https://minecraft.gamepedia.com/Advancement/JSON_format
     * 
     * @param advancement Advancement
     * @throws IOException
     */
    public void registerAdvancement(AdvancementList advancement) throws IOException {
        this.registerAdvancement(advancement.getName(), advancement.getFileTitle());
    }

    /**
     * Register a custom advancement. JSON format is governed by:
     * https://minecraft.gamepedia.com/Advancement/JSON_format
     * 
     * @param key       Advancement key
     * @param fileTitle first part of the file name
     * @throws IOException
     */
    @SuppressWarnings("deprecation")
    public void registerAdvancement(NamespacedKey key, String fileTitle) throws IOException {
        Bukkit.getLogger()
                .info(String.format("Loading advancement %s from advancement_defs/%s.json", key.toString(), fileTitle));

        // Load the JSON data
        InputStream fileStream = getClass().getResourceAsStream(String.format("advancement_defs/%s.json", fileTitle));
        String jsonData = IOUtils.toString(fileStream, Charset.defaultCharset());

        // Load the advancement
        Advancement advancement = Bukkit.getUnsafe().loadAdvancement(key, jsonData);

        // Add to registry
        this.advancements.put(key, advancement);
    }

    /**
     * Give a player an advancement
     * 
     * @param player      Player
     * @param advancement Advancement
     */
    public void awardAdvancementToPlayer(Player player, AdvancementList advancement) {

        // Get the advancement
        Advancement bukkitAdvancement = this.advancements.get(advancement.getName());

        // Skip if the player already has this advancement
        if (player.getAdvancementProgress(bukkitAdvancement).isDone()) {
            return;
        }

        // Grant
        Bukkit.getLogger().info(String.format("Granting advancement %s to player %s", advancement.getName().toString(),
                player.getName()));
        player.getAdvancementProgress(bukkitAdvancement).awardCriteria("enable");

    }

}