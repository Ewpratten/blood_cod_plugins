package ca.retrylife.blood_cod_plugins.registry;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;
import org.bukkit.entity.Player;

import ca.retrylife.blood_cod_plugins.registry.objects.UserObject;

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

    // List of known users
    private UserObject[] users;

    // Hidden constructor to force singleton usage
    private UserRegistry() {
    }

    public void load() throws IOException {

        // Get file
        InputStream fileStream = getClass().getResourceAsStream("users.json");
        String jsonData = IOUtils.toString(fileStream, Charset.defaultCharset());

        // Deserialize
        this.users = new Gson().fromJson(jsonData, UserObject[].class);

    }

    public boolean doesPlayerHavePermission(Player player, String permission) {

        // Get player uuid
        String uuidStr = player.getUniqueId().toString();

        // Search for player
        for (UserObject user : users) {
            if (user.uuid.equals(uuidStr)) {
                for (String perm : user.permissions) {
                    if (perm.equals(permission)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

}