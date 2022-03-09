package net.numalab.zombies.command

import dev.kotx.flylib.command.Command
import net.numalab.zombies.config.SpawnPoint
import net.numalab.zombies.config.ZombiesConfig
import org.bukkit.Location

class AddSpawnPointCommand(config: ZombiesConfig) : Command("addSpawnPoint") {
    init {
        description("Command to add a mob spawn point")
        usage {
            locationArgument("spawn location")
            doubleArgument("mob spawn radius", 0.0)
            executes {
                val loc = typedArgs[0] as Location
                if (world == null) {
                    fail("Could not get world")
                } else {
                    val radius = typedArgs[1] as Double
                    loc.world = world!! // FlyLibではワールドがnullになるのでワールドを設定する
                    config.spawnPoints.add(SpawnPoint().also {
                        it.loc.value(loc)
                        it.radius.value(radius)
                    })
                    success("Spawn point added,size:${config.spawnPoints.size}")
                }
            }
        }
    }
}