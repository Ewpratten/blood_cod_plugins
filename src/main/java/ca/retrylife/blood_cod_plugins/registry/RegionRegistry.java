package ca.retrylife.blood_cod_plugins.registry;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import ca.retrylife.blood_cod_plugins.registry.objects.RegionObject;

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

    // All regions
    private RegionObject[] regions;

    // Hidden constructor to force singleton usage
    private RegionRegistry() {
    }

    public void load() throws IOException {

        // Get file
        InputStream fileStream = getClass().getResourceAsStream("regionmap.json");
        String jsonData = IOUtils.toString(fileStream, Charset.defaultCharset());

        // Deserialize
        this.regions = new Gson().fromJson(jsonData, RegionObject[].class);

    }

    public RegionObject getRegion(String key) {

        // Search
        for (RegionObject region : regions) {

            if (region.getIdentifier().equals(key)) {
                return region;
            }

        }

        return null;

    }

}