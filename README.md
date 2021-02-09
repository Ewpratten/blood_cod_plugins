# Blood Cod Plugins
![Build plugin](https://github.com/Ewpratten/blood_cod_plugins/workflows/Build%20plugin/badge.svg) 

The *Blood Cod Plugins* pack is a monolithic server-side Minecraft plugin for use on a private survival multiplayer server. The goal of this plugin is to integrate the server history and lore into gameplay by providing custom NBT-backed items, crafting recipes, and advancements. Due to the one-off nature of this plugin, you'll find many hard-coded UUIDs and world coordinates in the plugin code.

## Features

### Smite

Players with the `god` or `godlike` [permission]() have the ability to smite any player with their fist at any time. When smiting a player, the smiter is gifted a fast and strong regeneration effect, and both players are gifted 14 seconds of fire resistance. This prevents the smiter from accidentally killing another player when only meaning to strike them with lightning for comedic effect.

When a player has been smote (smitten?), they are awarded the `Enlightenment` advancement. Any player that has been killed by a `god` or `godlike` player in this process will also get the `Ultimate Sacrifice` advancement.

### Advancements

The following custom advancements have been added to the game. More can be added upon request. Or, if you'd like: make a [Pull Request](https://github.com/Ewpratten/blood_cod_plugins/pull/new) and do it yourself.

| Title              | How to get it                                                       |
|--------------------|---------------------------------------------------------------------|
| Root               | Is granted to every player automatically the first time they log in |
| Welcome to Church  | Enter the blood church                                              |
| Defector           | Enter one of the other churches in the world                        |
| Box of Flames      | Enter (or fly overtop) Bloodland                                    |
| Robe Up            | Wear a full set of red leather armor                                |
| Thats Not Water!   | Drink `Tank Water of Cod`                                           |
| Thats Not Bread!   | Eat `Bread of Cod`                                                  |
| Enlightenment      | Get smited by the 🅱️ope                                            |
| Ultimate Sacrifice | Get smited to death by the 🅱️ope                                   |

These advancements are defined in [datapack format](https://minecraft.gamepedia.com/Advancement/JSON_format) in the [`src/main/resources/advancement_defs/`](https://github.com/Ewpratten/blood_cod_plugins/tree/master/src/main/resources/advancement_defs) directory. On server startup, the plugin compiles and injects it's own datapack into the server.

### Items & Crafting

| Item              | Recipe                    |
|-------------------|---------------------------|
| Tank Water of Cod | 1 glass bottle, 1 raw cod |
| Bread of Cod      | 1 bread, 1 raw cod        |

## Configuration

### User Permissions

User permissions are configured in [`src/main/resources/users.json`](https://github.com/Ewpratten/blood_cod_plugins/blob/master/src/main/resources/users.json). An example is Keegan's entry:

```js
{
    // Player UUID
    "uuid":"8b24c526-aea8-4eb7-80bb-34645d2e958e",

    // List of permissions for the player 
    // "godlike" allows smiting players
    // "god" allows smiting all entities
    "permissions": [
        "godlike"
    ]
}
```

### Regions

Regions are defined in [`src/main/resources/regionmap.json`](https://github.com/Ewpratten/blood_cod_plugins/blob/master/src/main/resources/regionmap.json). These objects are used by the plugin for area-based advancements (like `Welcome to Church`). An example is the blood church definition:

```js
{
    // These are used to access the region in the RegionRegistry
    "dimension": "overworld",
    "id": "church",

    // Top right corner of the area on dynmap
    "corner_a": {
        "x": -494,
        "z": 136
    },

    // Bottom left corner of the area on dynmap
    "corner_b": {
        "x": -509,
        "z": 161
    }
}
```

## Building

```sh
git clone https://github.com/ewpratten/blood_cod_plugins.git
cd blood_cod_plugins
./gradlew build
```

The resulting plugin JAR is in `build/libs`
