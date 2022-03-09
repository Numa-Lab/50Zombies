package net.numalab.zombies.config

import net.kunmc.lab.configlib.BaseConfig
import net.kunmc.lab.configlib.value.BooleanValue
import org.bukkit.plugin.Plugin

class ZombiesConfig(plugin: Plugin) : BaseConfig(plugin) {
    val isEnabled = BooleanValue(false)
    val spawnPoints = mutableListOf<SpawnPoint>()
    val phase = PhaseConfig(plugin)

    @Transient
    val subConfigs = listOf<BaseConfig>(phase)
}