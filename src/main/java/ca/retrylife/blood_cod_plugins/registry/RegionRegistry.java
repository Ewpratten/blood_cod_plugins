package ca.retrylife.blood_cod_plugins.registry;

public class RegionRegistry {

    // Internal instance reference
    private static RegionRegistry instance = null;
    
    /**
     * Get the global instance of RegionRegistry
     *
     * @return RegionRegistry instance
     */
    public static RegionRegistry getInstance() {
        if (instance == null) {
            instance = new RegionRegistry();
        }
        return instance;
    }
    
    // Hidden constructor to force singleton usage
    private RegionRegistry(){}
    
    
    
}