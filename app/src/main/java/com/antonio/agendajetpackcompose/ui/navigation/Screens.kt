package com.antonio.agendajetpackcompose.ui.navigation

sealed class Screens(val route:String) {
    object Menu: Screens("initial_screen")//info a aparecer en pantalla

    object Agenda: Screens("agenda")//info a aparecer en pantalla

}