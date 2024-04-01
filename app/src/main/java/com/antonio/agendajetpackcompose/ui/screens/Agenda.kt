package com.antonio.agendajetpackcompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.antonio.agendajetpackcompose.ui.model.Contactos
import com.antonio.agendajetpackcompose.ui.viewmodel.AgendaViewModel


@Composable
fun Agenda(navController: NavHostController, viewModel: AgendaViewModel) {
    var lista=viewModel.getListaContactos()
    var contacto=lista.first()

    Box(modifier=Modifier.fillMaxSize()){
        Row(){
            Column {
                Row(){
                    Text(text = "Nombre: ")
                    Text(text = contacto.nombre)
                }
                Row(){
                    Text(text = "Apellidos: ")
                    Text(text = contacto.apellidos)
                }
                Row(){
                    Text(text = "Telefono fijo: ")
                    Text(text = contacto.telefonoFijo)
                }
                Row(){
                    Text(text = "Telefono movil: ")
                    Text(text = contacto.telefonoMovil)
                }

            }
            Image(painter = painterResource(id = contacto.foto), contentDescription ="foto" )

        }
    }

}