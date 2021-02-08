package ca.retrylife.blood_cod_plugins.advancements;

import org.bukkit.NamespacedKey;

public enum AdvancementList {
    // The root plugin. Not used
    @SuppressWarnings("deprecation")
    ROOT(new NamespacedKey("bcp", "root"), "root"),

    // Enter the church
    @SuppressWarnings("deprecation")
    ENTER_CHURCH(new NamespacedKey("bcp", "enter_church"), "enter_church"),

    // Defector
    @SuppressWarnings("deprecation")
    DEFECTOR(new NamespacedKey("bcp", "defector"), "defector"),

    // Bloodland
    @SuppressWarnings("deprecation")
    BLOODLAND(new NamespacedKey("bcp", "bloodland"), "bloodland"),

    // Robe Up
    @SuppressWarnings("deprecation")
    ROBE_UP(new NamespacedKey("bcp", "robe_up"), "robes"),

    // Not water
    @SuppressWarnings("deprecation")
    NOT_WATER(new NamespacedKey("bcp", "not_water"), "not_water"),

    // Not bread
    @SuppressWarnings("deprecation")
    NOT_BREAD(new NamespacedKey("bcp", "not_bread"), "not_bread"),

    // Lightning strike
    @SuppressWarnings("deprecation")
    ENLIGHTENMENT(new NamespacedKey("bcp", "enlightenment"), "enlightenment"),
    
    // Sacrifice
    @SuppressWarnings("deprecation")
    ULTIMATE_SACRIFICE(new NamespacedKey("bcp", "ultimate_sacrifice"), "ultimate_sacrifice");

    private final NamespacedKey name;
    private final String fileTitle;

    private AdvancementList(NamespacedKey name, String fileTitle) {
        this.name = name;
        this.fileTitle = fileTitle;
    }

    public NamespacedKey getName() {
        return name;
    }

    public String getFileTitle() {
        return fileTitle;
    }

}