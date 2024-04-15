package com.antonio.agendajetpackcompose.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.antonio.agendajetpackcompose.ui.model.Contactos
import com.antonio.agendajetpackcompose.ui.model.ContactosFinales
import com.antonio.agendajetpackcompose.ui.navigation.Screens
import com.antonio.agendajetpackcompose.ui.viewmodel.AgendaViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Agenda(navController: NavHostController, viewModel: AgendaViewModel) {

    Scaffold(
        topBar = {
            MyTopBar(navController,viewModel)
        },
        content = {padding ->
            Contenido(navController,viewModel)
        }
    )





}

@Composable
fun MyTopBar(navController: NavHostController,
             viewModel: AgendaViewModel,
             backgroundColor: Color = Color(10, 48, 100),//azul
             contentColor: Color = Color(232, 18, 36),//rojo
             elevation: Dp = AppBarDefaults.TopAppBarElevation
             ) {
    val context= LocalContext.current

    val colorRojo=Color(232, 18, 36)
    TopAppBar(

        navigationIcon = {
            IconButton(onClick = {navController.navigate(route = Screens.Menu.route)}) {
                Icon(imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Ir hacia atras",
                    tint = colorRojo,
                    modifier = Modifier.size(60.dp)
                )
            }



        },
        title = { Text("Agenda F.C. Barcelona", color = colorRojo, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
        actions = {

            IconButton(onClick = {
                navController.navigate(route=Screens.AgendaAnhadirContacto.route)

            }) {
                Icon(imageVector = Icons.Filled.Add,
                    contentDescription = "añadir contacto",
                    tint = colorRojo,
                    modifier = Modifier.size(80.dp)
                )
            }





        },
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation

    )


}

@Composable
fun Contenido(navController: NavHostController, viewModel: AgendaViewModel) {

    val context = LocalContext.current

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 60.dp)
    ) {
        items(viewModel.leerContactosArchivo(context)) {
            ItemContactos(
                navController = navController,
                viewModel = viewModel,
                contacto = it,

            ) {
                viewModel.setaContactoFinales(it)
                navController.navigate(route = Screens.AgendaDetalle.route)
            }
        }
    }


}

@Composable
fun ItemContactos(navController: NavHostController,viewModel: AgendaViewModel, contacto: ContactosFinales, onItemSelected: () -> Unit) {
    var context= LocalContext.current
    val colorRojo=Color(232, 18, 36)
    val colorAzul=Color(10, 48, 100)

    val imageBitmap = if (contacto.foto != null) {
        viewModel.ByteArrayToImage(contacto.foto!!)
    } else {
        null
    }
    //val imageBitmap= contacto.foto?.let { viewModel.ByteArrayToImage(it) }
    //se transforma ByteArray a imageBitMap para poder utilizar la foto en el Image()

    Card(border = BorderStroke(2.dp, colorRojo), modifier = Modifier
        .fillMaxWidth()

        .clickable { onItemSelected() }
        .padding(horizontal = 8.dp, vertical = 2.dp)) {

        Row() {
            imageBitmap?.let {
                Image(
                    bitmap = it,
                    contentDescription = "foto contacto",
                    modifier = Modifier.size(90.dp)
                )
            }
            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = contacto.nombre + " " + contacto.apellidos,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Row(modifier=Modifier.fillMaxWidth().height(30.dp), verticalAlignment = Alignment.CenterVertically){
                    Icon(imageVector = Icons.Filled.Call,
                        contentDescription = "telefonoFijo",
                        tint = colorRojo
                    )
                    Text(text = contacto.telefonoFijo, fontSize = 18.sp)
                    IconButton(onClick = {
                        viewModel.setaContactoFinales(contacto)
                        viewModel.borrarContacto(context, viewModel.contactofinal)
                        navController.navigate(route=Screens.Agenda.route)

                    }, modifier = Modifier.padding(start=120.dp)) {
                        Icon(imageVector = Icons.Filled.Delete,
                            contentDescription = "Borrar",
                            tint = Color.Black,

                        )
                    }


                }

                Row(modifier=Modifier.fillMaxWidth().height(30.dp), verticalAlignment = Alignment.CenterVertically){

                    Icon(imageVector = Icons.Filled.PhoneAndroid,
                        contentDescription = "telefonoMovil",
                        tint = colorAzul
                    )
                    Text(text = contacto.telefonoMovil, fontSize = 18.sp)
                    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(start=120.dp)) {
                        Icon(imageVector = Icons.Filled.Edit,
                            contentDescription = "Editar",
                            tint = Color.Black,

                            )
                    }
                }


            }
        }

    }
}
