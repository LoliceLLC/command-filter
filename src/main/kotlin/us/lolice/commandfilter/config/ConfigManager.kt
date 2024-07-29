package us.lolice.commandfilter.config

import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class ConfigManager(plugin: JavaPlugin) {
    val blockColonCommands: Boolean
    val blockWhitespaceCommands: Boolean
    val invalidColonCommandMessage: String
    val invalidWhitespaceCommandMessage: String
    val whitelistedPlugins: Set<String>

    init {
        plugin.saveDefaultConfig()
        val config = plugin.config

        blockColonCommands = config.getBoolean("blockColonCommands", true)
        blockWhitespaceCommands = config.getBoolean("blockWhitespaceCommands", true)
        invalidColonCommandMessage = ChatColor.translateAlternateColorCodes('&', config.getString("invalidColonCommandMessage") ?: "&cPlugin do not get \"invalidColonCommandMessage\" from config!")
        invalidWhitespaceCommandMessage = ChatColor.translateAlternateColorCodes('&', config.getString("invalidWhitespaceCommandMessage") ?: "&cPlugin do not get \"invalidWhitespaceCommandMessage\" from config!")
        whitelistedPlugins = config.getStringList("whitelistedPlugins").toSet()
    }
}
