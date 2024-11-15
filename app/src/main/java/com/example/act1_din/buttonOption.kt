package com.example.act1_din

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun buttonOption( util : Boolean,onBotonMostrar:(()->Unit),encendido:Boolean,onBotonVisible:((Boolean) -> Unit)){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){

        Button(onClick = onBotonMostrar, enabled = util) {
            if(util){
                textoGeneral("Pulsame")
            }
        }
        Spacer(modifier = Modifier.width(20.dp))

        Switch(checked = encendido,onCheckedChange = onBotonVisible)
    }
}