package net.numalab.zombies.config

import net.kunmc.lab.configlib.value.DoubleValue
import net.kunmc.lab.configlib.value.LocationValue

class SpawnPoint {
    // スポーン中心地点
    val loc = LocationValue()

    // スポーン半径
    val radius = DoubleValue(2.0, 0.0, Double.MAX_VALUE)
}