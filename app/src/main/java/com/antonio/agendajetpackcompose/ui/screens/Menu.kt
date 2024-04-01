package com.antonio.agendajetpackcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.antonio.agendajetpackcompose.ui.navigation.Screens
import com.antonio.agendajetpackcompose.ui.viewmodel.AgendaViewModel

@Composable
fun Menu(navController: NavHostController, viewModel: AgendaViewModel) {
    Column(modifier=Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { navController.navigate(route=Screens.Agenda.route) }) {
            Text(text = "Agenda")
        }
    }

}