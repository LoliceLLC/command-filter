# command-filter

CommandFilter is a plugin for Minecraft servers running on Bukkit/Spigot.
It is designed to filter and block certain types of commands, increasing server security and control.
Written for one person but can be useful to someone else.

## Features

- Block commands with a colon (e.g. `/plugin:command`)
- Block commands that start with a space (e.g. `/ command`)
- Customizable error messages
- Ability to create a whitelist of plugins whose commands will not be blocked.

## Installation

1. Download the latest version of the plugin in releases
2. Place the .jar file in the `plugins` folder of your Minecraft server
3. Restart the server or use the plugin to reload plugins

## Configuration

After the first run of the plugin, a `config.yml` file will be created. You can configure the following parameters:

- `blockColonCommands`: Block commands with a colon (default: true)
- `blockWhitespaceCommands`: Block commands starting with a space (default: true)
- `invalidColonCommandMessage`: Message when attempting to use a blocked colon command
- `invalidWhitespaceCommandMessage`: Message when attempting to use a command starting with a space.
- `whitelistedPlugins`: List of plugins whose commands will not be blocked