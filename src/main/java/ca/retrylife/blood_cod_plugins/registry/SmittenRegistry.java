package ca.retrylife.blood_cod_plugins.registry;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class SmittenRegistry {

    // Internal instance reference
    private static SmittenRegistry instance = null;

    /**
     * Get the global instance of SmittenRegistry
     *
     * @return SmittenRegistry instance
     */
    public static SmittenRegistry getInstance() {
        if (instance == null) {
            instance = new SmittenRegistry();
        }
        return instance;
    }

    // Victim

    // Hidden constructor to force singleton usage
    private SmittenRegistry() {
    }

    public void setMostRecentVictim(Entity entity) {
    }

    public boolean isFinalBlow(Entity entity) {
        return false;
    }

}