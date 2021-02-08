package ca.retrylife.blood_cod_plugins.registry;

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
    private Player victim = null;
    private double timestamp;

    // Hidden constructor to force singleton usage
    private SmittenRegistry() {
    }

    public void setMostRecentVictim(Player player) {
        this.victim = player;
        this.timestamp = System.currentTimeMillis();
    }

    public boolean isFinalBlow(Player player) {
        return (player.equals(this.victim) && Math.abs(System.currentTimeMillis() - this.timestamp) < 2000);
    }

}