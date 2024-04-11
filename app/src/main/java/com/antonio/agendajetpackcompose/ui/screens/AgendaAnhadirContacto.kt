package com.antonio.agendajetpackcompose.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.BottomAppBar
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.antonio.agendajetpackcompose.R
import com.antonio.agendajetpackcompose.ui.miscompose.myTextField
import com.antonio.agendajetpackcompose.ui.navigation.Screens
import com.antonio.agendajetpackcompose.ui.viewmodel.AgendaViewModel
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgendaAnhadirContacto(navController: NavHostController, viewModel: AgendaViewModel) {

    Scaffold(
        topBar = {
            MyTopBar3(navController, viewModel)
        },
        content = { padding ->
            ContenidoDetalleAnhadir(navController, viewModel)
        },


        )


}


@Composable
fun MyTopBar3(
    navController: NavHostController,
    viewModel: AgendaViewModel,
    backgroundColor: Color = Color(10, 48, 100),//azul
    contentColor: Color = Color(232, 18, 36),//rojo
    elevation: Dp = AppBarDefaults.TopAppBarElevation
) {
    val context = LocalContext.current

    val colorRojo = Color(232, 18, 36)
    TopAppBar(

        navigationIcon = {
            IconButton(onClick = { navController.navigate(route = Screens.Agenda.route) }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Ir hacia atras",
                    tint = colorRojo,
                    modifier = Modifier.size(60.dp)
                )
            }


        },
        title = {
            Text(
                "Agenda F.C. Barcelona",
                color = colorRojo,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },

        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation

    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContenidoDetalleAnhadir(navController: NavHostController, viewModel: AgendaViewModel) {
    val colorRojo = Color(232, 18, 36)
    val colorAzul = Color(10, 48, 100)
    val colorAmarillo = Color(235, 203, 73)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Card(
            border = BorderStroke(2.dp, colorRojo),
            colors = CardDefaults.cardColors(containerColor = colorAmarillo),
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 75.dp, horizontal = 16.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, top = 10.dp)
            ) {
                Column(
                    Modifier
                        .weight(1.2f)
                        .padding(top = 10.dp, start = 10.dp),
                    // .height(160.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                )
                {

                    TextField(
                        value = viewModel.nombre,
                        onValueChange = { viewModel.getNombre(it) },
                        label = {
                            if (viewModel.nombre.isEmpty()) {
                                Text("Nombre", style = TextStyle(fontSize = 10.sp))
                            }
                        },
                        textStyle = TextStyle(fontSize = 12.sp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier
                            .width(180.dp)
                            .height(45.dp)
                    )
                    Spacer(modifier = Modifier.size(2.dp))

                    TextField(
                        value = viewModel.apellidos,
                        onValueChange = { viewModel.getApellidos(it) },
                        label = {
                            if (viewModel.apellidos.isEmpty()) {
                                Text("Apellidos", style = TextStyle(fontSize = 10.sp))
                            }
                        },
                        textStyle = TextStyle(fontSize = 12.sp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier
                            .width(180.dp)
                            .height(45.dp)
                    )
                    Spacer(modifier = Modifier.size(2.dp))
                    TextField(
                        value = viewModel.telefonoFijo,
                        onValueChange = { viewModel.getTelefonoFijo(it) },
                        label = {
                            if (viewModel.telefonoFijo.isEmpty()) {
                                Text("Telefono fijo", style = TextStyle(fontSize = 10.sp))
                            }
                        },
                        textStyle = TextStyle(fontSize = 12.sp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(180.dp)
                            .height(45.dp)
                    )
                    Spacer(modifier = Modifier.size(2.dp))
                    TextField(
                        value = viewModel.telefonoMovil,
                        onValueChange = { viewModel.getTelefonoMovil(it) },
                        label = {
                            if (viewModel.telefonoMovil.isEmpty()) {
                                Text("Telefono movil", style = TextStyle(fontSize = 10.sp))
                            }
                        },
                        textStyle = TextStyle(fontSize = 12.sp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(180.dp)
                            .height(45.dp)
                    )


                }
                Image(
                    alignment = Alignment.CenterEnd,
                    painter = painterResource(R.drawable.jugadordesconocido),
                    contentDescription = "foto",
                    modifier = Modifier
                        .size(200.dp)
                        .weight(0.9f)

                )

            }
//            Row(){
//                Text(text = "Dirección: ",
//                    modifier= Modifier.padding(start=10.dp,top=10.dp),
//                    fontWeight = FontWeight.Bold
//                )
//                Text(
//                    text = viewModel.contacto.Direccion,
//                    modifier = Modifier.padding(top=10.dp),
//                    fontSize = 16.sp
//                )
//            }

//            Row(){
//                Text(text = "C.P: ",
//                    modifier= Modifier.padding(start=10.dp,top=10.dp),
//                    fontWeight = FontWeight.Bold)
//                Text(
//                    text = viewModel.contacto.codigoPostal,
//                    modifier = Modifier.padding(top=10.dp),
//                    fontSize = 16.sp
//                )
//
//                Text(text = "Ciudad: ",
//                    modifier= Modifier.padding(start=10.dp,top=10.dp),
//                    fontWeight = FontWeight.Bold)
//                Text(
//                    text = viewModel.contacto.ciudad,
//                    modifier = Modifier.padding(top=10.dp),
//                    fontSize = 16.sp
//                )
//
//
//            }
//            Row(){
//                Text(text = "Provincia: ",
//                    modifier= Modifier.padding(start=10.dp,top=10.dp),
//                    fontWeight = FontWeight.Bold)
//                Text(
//                    text = viewModel.contacto.provincia,
//                    modifier = Modifier.padding(top=10.dp),
//                    fontSize = 16.sp
//                )
//            }

//            Row(){
//                Text(text = "email: ",
//                    modifier= Modifier.padding(start=10.dp,top=10.dp),
//                    fontWeight = FontWeight.Bold)
//                Text(
//                    text = viewModel.contacto.email,
//                    modifier = Modifier.padding(top=10.dp),
//                    fontSize = 16.sp
//                )
//            }

//            Row(){
//                Text(text = "Cumpleaños: ",
//                    modifier= Modifier.padding(start=10.dp,top=10.dp),
//                    fontWeight = FontWeight.Bold)
//                Text(
//                    text = viewModel.contacto.cumpleaños,
//                    modifier = Modifier.padding(top=10.dp),
//                    fontSize = 16.sp
//                )
//            }

//            Card(
//                border = BorderStroke(2.dp, colorAzul), modifier = Modifier
//                    .fillMaxSize()
//                    .padding(horizontal = 16.dp, vertical = 24.dp)
//            ) {
//                Column(){
//                    Text(text = "Observaciones: ",
//                        modifier= Modifier.padding(start=10.dp,top=10.dp),
//                        fontWeight = FontWeight.Bold)
//                    Text(
//                        text = viewModel.contacto.observaciones,
//                        modifier = Modifier.padding(10.dp)
//                    )
//                }
//
//
//            }


//


        }

    }
}
