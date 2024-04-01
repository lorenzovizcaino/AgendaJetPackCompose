package com.antonio.agendajetpackcompose.ui.viewmodel

import com.antonio.agendajetpackcompose.R
import com.antonio.agendajetpackcompose.ui.model.Contactos

class AgendaViewModel {

    var lista= mutableListOf<Contactos>(
        Contactos(1,
            "Marc-André",
            "Ter Stegen",
            "Passeig de Gràcia 34 2ºB",
            "08007",
            "Barcelona",
            "Barcelona",
            "932145258",
            "678521465",
            "marcstegen@gmail.com",
            "30 Abril",
            "Portero sobrio y con grandes reflejos, destaca por el control aéreo y el dominio del juego de pies",
            R.drawable.marc_andre),
        Contactos(2,
            "João",
            "Cancelo",
            "La rambla 324 7º",
            "08002",
            "Barcelona",
            "Barcelona",
            "934545247",
            "677856465",
            "joaocancelo@gmail.com",
            "27 Mayo",
            "Dueño y señor del lateral derecho con una exuberancia física y una habilidad envidiable ha pasado por grandes clubs del nivel europeo",
            R.drawable.joao_cancelo),
        Contactos(3,
            "Alejandro",
            "Balde",
            "Avinguda Diagonal 214 Atico A",
            "08005",
            "Barcelona",
            "Barcelona",
            "934545245",
            "677456478",
            "alejandrobaldeo@gmail.com",
            "18 Octubre",
            "Dotado física y técnicamente, Alejandro Balde es un lateral explosivo y rápido con capacidad para incorporarse al ataque",
            R.drawable.alejandro_balde),
        Contactos(5,
            "Iñigo",
            "Martinez",
            "Carrer del Bisbe 146 5ºC",
            "08001 ",
            "Barcelona",
            "Barcelona",
            "934544744",
            "677786785",
            "iñigomartinez@gmail.com",
            "17 Mayo",
            "Después de una década ininterrumpida en la élite del fútbol español, Iñigo Martinez ha demostrado ser un central con una gran salida de balón y una importante capacidad goleadora pese a su posición",
            R.drawable.inigo_martinez),

    )


    fun getListaContactos():MutableList<Contactos>{
        return lista
    }

}