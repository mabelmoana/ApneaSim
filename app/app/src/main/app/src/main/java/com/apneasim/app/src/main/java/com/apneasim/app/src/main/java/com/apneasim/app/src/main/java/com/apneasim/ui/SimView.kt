package com.apneasim.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.apneasim.sim.*

@Composable
fun SimView(params: SimParams) {
    var state by remember { mutableStateOf(SimState(0.0, 0.0, 0.0)) }

    LaunchedEffect(Unit) {
        while (state.profondita < params.profonditaTarget) {
            state = SimulationEngine.step(state, params, 0.1)
            kotlinx.coroutines.delay(100)
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawLine(Color.Blue, start = center, end = center.copy(y = size.height), strokeWidth = 5f)
        drawCircle(Color.Red, radius = 20f, center = center.copy(y = (state.profondita / params.profonditaTarget * size.height).toFloat()))
    }
}
