package us.lolice.commandfilter

import org.bukkit.plugin.java.JavaPlugin
import us.lolice.commandfilter.config.ConfigManager
import us.lolice.commandfilter.listener.CommandPreprocessListener

class CommandFilter : JavaPlugin() {
    private lateinit var configManager: ConfigManager
    private lateinit var commandListener: CommandPreprocessListener

    override fun onEnable() {
        configManager = ConfigManager(this)
        commandListener = CommandPreprocessListener(this, configManager)

        server.pluginManager.registerEvents(commandListener, this)

        logger.info("CommandFilter has been enabled!")
    }

    override fun onDisable() {
        logger.info("CommandFilter has been disabled!")
    }
}
