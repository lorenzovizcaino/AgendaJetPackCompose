package com.antonio.agendajetpackcompose.ui.navigation

sealed class Screens(val route:String) {
    object Menu: Screens("initial_screen")

    object Agenda: Screens("agenda")
    object AgendaDetalle: Screens("detalle de agenda")

}