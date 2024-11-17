package com.example.act1_din

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun act1Check(modifier: Modifier = Modifier) {
    var check by rememberSaveable { mutableStateOf(false) }
    var check2 by rememberSaveable { mutableStateOf(false) }
    var check3 by rememberSaveable { mutableStateOf(false) }
    var visible by rememberSaveable { mutableStateOf(false) }
    var util by rememberSaveable { mutableStateOf(true) }
    var option by rememberSaveable { mutableStateOf(mutableListOf<String>()) }

    var rojo by rememberSaveable { mutableStateOf(0) }
    var azul by rememberSaveable { mutableStateOf(255) }
    var verde by rememberSaveable { mutableStateOf(255) }


    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(rojo,verde,azul)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        checkBoxOption(check, onCheckedChange = {
            check = !check
            option = checkCaso(option,"caso1",check)
        },"caso1")

        checkBoxOption(check2, onCheckedChange = {
            check2 = !check2
            option = checkCaso(option,"caso2",check2)

        },"caso2")

        checkBoxOption(check3, onCheckedChange = {
            check3 = !check3
            option = checkCaso(option,"caso3",check3)
        },"caso3")


        textoVisible(visible,option)


        buttonOption(
            util = util ,
            onBotonMostrar = {visible = !visible},
            encendido = util,
            onBotonVisible = {
                util = !util
                visible = false
            }
        )

        SliderExample(text = "Rojo", onCambioColor = {rojo = it.toInt()})
        SliderExample(text = "Verde", onCambioColor = {verde = it.toInt()})
        SliderExample(text = "Azul", onCambioColor = {azul = it.toInt()})


    }
}

@Composable
fun textoVisible(visible:Boolean, option: List<String>){

    Box (
        modifier = Modifier.padding(20.dp)
            .background(Color.White)
            .width(200.dp)
            .height(60.dp),
        contentAlignment = Alignment.Center
    ){
        if (visible && option.isNotEmpty()) {
            textoGeneral(option.min())
        }
    }
}

@Composable
fun textoGeneral(texto:String){
    Text(texto, color = Color.Black)
}