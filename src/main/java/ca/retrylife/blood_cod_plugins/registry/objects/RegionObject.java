package ca.retrylife.blood_cod_plugins.registry.objects;

import org.bukkit.Location;

public class RegionObject {

    public static class AreaObject {
        public int x;
        public int z;
    }

    public String dimension;
    public String id;
    public AreaObject corner_a;
    public AreaObject corner_b;

    public String getIdentifier() {
        return String.format("%s:%s", dimension, id);
    }

    public boolean contains(Location location) {

        // Get the corner locations
        int x1 = Math.min(corner_a.x, corner_b.x);
        int z1 = Math.min(corner_a.z, corner_b.z);
        int x2 = Math.max(corner_a.x, corner_b.x);
        int z2 = Math.max(corner_a.z, corner_b.z);

        return location.getX() >= x1 && location.getX() <= x2 && location.getZ() >= z1 && location.getZ() <= z2;

    }

}