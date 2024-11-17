package com.example.act1_din

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // Para Layouts
import androidx.compose.material3.* // Usar Material3
import androidx.compose.runtime.* // Estados y recuerdan
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SliderExample(text:String,onCambioColor:(Float)->Unit) {

    var sliderValue by remember { mutableStateOf(0f) }

    Row (
        modifier = Modifier
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text)

        Spacer(modifier = Modifier.width(5.dp))

        Slider(
            value = sliderValue, // Valor del slider
            onValueChange = {
                sliderValue = it
                onCambioColor(sliderValue)
                            },
            valueRange = 0f..250f,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

