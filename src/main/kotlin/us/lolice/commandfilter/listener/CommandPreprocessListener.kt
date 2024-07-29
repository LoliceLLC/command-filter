package us.lolice.commandfilter.listener

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.plugin.java.JavaPlugin
import us.lolice.commandfilter.config.ConfigManager

class CommandPreprocessListener(
    private val plugin: JavaPlugin,
    private val configManager: ConfigManager
) : Listener {

    @EventHandler
    fun onPlayerCommandPreprocess(event: PlayerCommandPreprocessEvent) {
        val message = event.message.trimStart()
        if (!message.startsWith("/")) return

        if (configManager.blockWhitespaceCommands && isWhitespaceCommand(message)) {
            event.player.sendMessage(configManager.invalidWhitespaceCommandMessage)
            event.isCancelled = true
            return
        }

        if (configManager.blockColonCommands && isColonCommand(message)) {
            event.player.sendMessage(configManager.invalidColonCommandMessage)
            event.isCancelled = true
        }
    }

    private fun isWhitespaceCommand(message: String): Boolean {
        return message.length > 1 && message[1] == ' '
    }

    private fun isColonCommand(message: String): Boolean {
        val parts = message.substring(1).split(":", limit = 2)
        if (parts.size < 2) return false

        val pluginName = parts[0].trim()
        if (pluginName.isEmpty() || configManager.whitelistedPlugins.contains(pluginName)) return false

        return isBlockedPlugin(pluginName)
    }

    private fun isBlockedPlugin(pluginName: String): Boolean {
        return when {
            pluginName.equals("bukkit", ignoreCase = true) -> true
            pluginName.equals("minecraft", ignoreCase = true) -> true
            else -> plugin.server.pluginManager.plugins.any { it.name.equals(pluginName, ignoreCase = true) }
        }
    }
}
