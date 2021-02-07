package ca.retrylife.blood_cod_plugins.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RegionUtils {

    
    public static boolean isPlayerInRegion(Player player, Location locA, Location locB) {

        // Region bounds
        int x1 = Math.min(locA.getBlockX(), locB.getBlockX());
        int z1 = Math.min(locA.getBlockZ(), locB.getBlockZ());
        int x2 = Math.max(locA.getBlockX(), locB.getBlockX());
        int z2 = Math.max(locA.getBlockZ(), locB.getBlockZ());

        // Player location
        Location playerLoc = player.getLocation();
 
        return playerLoc.getX() >= x1 && playerLoc.getX() <= x2 && playerLoc.getZ() >= z1 && playerLoc.getZ() <= z2;
    }
    
}