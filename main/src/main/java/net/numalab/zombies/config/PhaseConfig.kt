package net.numalab.zombies.config

import net.kunmc.lab.configlib.BaseConfig
import net.kunmc.lab.configlib.value.EnumValue
import net.kunmc.lab.configlib.value.IntegerValue
import org.bukkit.plugin.Plugin

class PhaseConfig(plugin: Plugin) : BaseConfig(plugin) {
    val timeType = EnumValue(PhaseTimeType.CONST)

    // ベースの時間
    // CONST -> この値が常に続く
    // ADD -> この値に
    val baseTimeSec = IntegerValue(60, 0, Integer.MAX_VALUE)

    // フェーズごとに延長する時間
    val addTimeSet = IntegerValue(3, 0, Integer.MAX_VALUE)

    /**
     * @param phaseIndex Zero-Indexed
     */
    fun calcPhaseTime(phaseIndex: Int): Int {
        when (timeType.value()!!) {   // Maruさんに全幅の信頼を置いた!!
            PhaseTimeType.CONST -> {
                // 常に続く
                return baseTimeSec.value()
            }
            PhaseTimeType.ADD -> {
                // 加算
                return baseTimeSec.value() + addTimeSet.value() * phaseIndex
            }
        }
    }
}

enum class PhaseTimeType {
    CONST, // 常に一定の値
    ADD   // 常に一定の値を上乗せする
}