package ca.retrylife.blood_cod_plugins.registry;

import org.bukkit.entity.Player;

public class UserRegistry {

    // Internal instance reference
    private static UserRegistry instance = null;
    
    /**
     * Get the global instance of UserRegistry
     *
     * @return UserRegistry instance
     */
    public static UserRegistry getInstance() {
        if (instance == null) {
            instance = new UserRegistry();
        }
        return instance;
    }
    
    // Hidden constructor to force singleton usage
    private UserRegistry(){}

    public boolean doesPlayerHavePermission(Player player, String permission) {

        return false;
        
    }
    
    
}