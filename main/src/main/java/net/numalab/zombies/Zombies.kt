package net.numalab.zombies

import dev.kotx.flylib.flyLib
import net.numalab.zombies.command.ZombiesCommand
import net.numalab.zombies.config.ZombiesConfig
import org.bukkit.plugin.java.JavaPlugin

class Zombies : JavaPlugin() {
    val config = ZombiesConfig(this).also {
        it.saveConfigIfAbsent()
    }

    init {
        flyLib {
            command(ZombiesCommand(config,this@Zombies))
        }
    }

    override fun onEnable() {
        // Plugin startup logic
        config.loadConfig() // World読み込みの必要があるのでここで読み込み
    }

    override fun onDisable() {
        // Plugin shutdown logic
        config.saveConfigIfPresent()
    }
}