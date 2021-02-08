package ca.retrylife.blood_cod_plugins.registry;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.LivingEntity;

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

    // Victim registry
    private HashMap<UUID, Double> registry = new HashMap<>();

    // Hidden constructor to force singleton usage
    private SmittenRegistry() {
    }

    public void setMostRecentVictim(LivingEntity entity) {

        // Get unique id of the victim
        UUID uuid = entity.getUniqueId();

        // Get current timestamp
        double timestamp = System.currentTimeMillis();

        // Set the registry entry
        this.registry.put(uuid, timestamp);

    }

    public boolean isFinalBlow(LivingEntity entity) {

        // Get unique id of the victim
        UUID uuid = entity.getUniqueId();

        // Get current timestamp
        double timestamp = System.currentTimeMillis();

        // Check for match
        if (this.registry.containsKey(uuid)) {

            // Check that the time range is reasonable
            if ((timestamp - this.registry.get(uuid)) <= 1500) {
                return true;
            }

        }

        return false;
    }

}