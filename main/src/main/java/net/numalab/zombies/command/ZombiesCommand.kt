package net.numalab.zombies.command

import dev.kotx.flylib.command.Command
import net.kunmc.lab.configlib.ConfigCommandBuilder
import net.numalab.zombies.Zombies
import net.numalab.zombies.config.ZombiesConfig

class ZombiesCommand(config: ZombiesConfig, plugin: Zombies) : Command("zb") {
    init {
        description("The main command of the Zombies plugin")
        usage {
            selectionArgument("ON/OFF", "ON", "OFF")
            executes {
                val first = typedArgs[0] as String
                when (first) {
                    "ON" -> {
                        config.isEnabled.value(true)
                        success("Zombies are now enabled")
                    }
                    "OFF" -> {
                        config.isEnabled.value(false)
                        success("Zombies are now disabled")
                    }
                    else -> fail("Invalid argument")
                }
            }
            children(
                AddSpawnPointCommand(config),
                ConfigCommandBuilder(config).also { config.subConfigs.forEach { c -> it.addConfig(c) } }.build()
            )
        }
    }
}