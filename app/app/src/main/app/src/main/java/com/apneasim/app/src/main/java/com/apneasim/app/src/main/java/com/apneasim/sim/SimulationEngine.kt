package com.apneasim.sim

data class SimParams(
    val massa: Double,
    val zavorra: Double,
    val polmoni: Double,
    val profonditaTarget: Double,
    val eta: Int
)

data class SimState(
    val t: Double,
    val profondita: Double,
    val velocita: Double
)

object SimulationEngine {
    fun step(state: SimState, params: SimParams, dt: Double): SimState {
        val acc = -0.1 * state.profondita + 0.05 * params.massa - 0.02 * params.zavorra
        val v = state.velocita + acc * dt
        val d = state.profondita + v * dt
        return SimState(state.t + dt, d.coerceAtLeast(0.0), v)
    }
}
