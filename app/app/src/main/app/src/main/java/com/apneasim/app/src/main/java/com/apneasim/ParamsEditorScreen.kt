package com.apneasim.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.apneasim.sim.SimulationEngine
import com.apneasim.sim.SimParams

@Composable
fun ParamsEditorScreen() {
    var massa by remember { mutableStateOf("130") }
    var zavorra by remember { mutableStateOf("3") }
    var polmoni by remember { mutableStateOf("5") }
    var profondita by remember { mutableStateOf("30") }
    var eta by remember { mutableStateOf("68") }

    var start by remember { mutableStateOf(false) }

    if (!start) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(value = massa, onValueChange = { massa = it }, label = { Text("Massa (kg)") })
            OutlinedTextField(value = zavorra, onValueChange = { zavorra = it }, label = { Text("Zavorra (kg)") })
            OutlinedTextField(value = polmoni, onValueChange = { polmoni = it }, label = { Text("Polmoni (L)") })
            OutlinedTextField(value = profondita, onValueChange = { profondita = it }, label = { Text("Profondità target (m)") })
            OutlinedTextField(value = eta, onValueChange = { eta = it }, label = { Text("Età (anni)") })

            Spacer(Modifier.height(20.dp))

            Button(onClick = { start = true }) {
                Text("Avvia Simulazione")
            }
        }
    } else {
        SimView(
            SimParams(
                massa.toDouble(),
                zavorra.toDouble(),
                polmoni.toDouble(),
                profondita.toDouble(),
                eta.toInt()
            )
        )
    }
}
