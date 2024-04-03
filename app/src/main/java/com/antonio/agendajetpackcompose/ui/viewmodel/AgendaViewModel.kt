package com.antonio.agendajetpackcompose.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
            "Portero sobrio y con grandes reflejos, destaca por el control aéreo y el dominio del juego de pies.",
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
            "Dueño y señor del lateral derecho con una exuberancia física y una habilidad envidiable ha pasado por grandes clubs del nivel europeo.",
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
            "Dotado física y técnicamente, Alejandro Balde es un lateral explosivo y rápido con capacidad para incorporarse al ataque.",
            R.drawable.alejandro_balde),
        Contactos(4,
            "Ronald",
            "Araujo",
            "Avinguda Diagonal 214 Atico B",
            "08005",
            "Barcelona",
            "Barcelona",
            "934543457",
            "677768903",
            "ronaldaraujo@gmail.com",
            "7 Marzo",
            "Central uruguayo con proyección, con buena salida de balón y dominio del juego aéreo.",
            R.drawable.ronald_araujo),
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
            "Después de una década ininterrumpida en la élite del fútbol español, Iñigo Martinez ha demostrado ser un central con una gran salida de balón.",
            R.drawable.inigo_martinez),
        Contactos(6,
            "Pablo",
            "Paez Gavira",
            "Passeig del Born 6 4ºA",
            "08001 ",
            "Barcelona",
            "Barcelona",
            "934564745",
            "677787852",
            "gavibarca@gmail.com",
            "5 Agosto",
            "Centrocampista con una gran calidad técnica y visión de juego, con carácter e intensidad, que le convierten en un jugador importante en el medio del campo.",
            R.drawable.gavi),
        Contactos(7,
            "Ferran",
            "Torres",
            "Carrer Petritxol 56",
            "08012 ",
            "Barcelona",
            "Barcelona",
            "934523445",
            "677787458",
            "ferrantorres@gmail.com",
            "29 Febrero",
            "Puede ocupar cualquier posición ofensiva, exhibiendo velocidad, verticalidad, calidad e inteligencia.",
            R.drawable.ferran_torres),
        Contactos(7,
            "Pedro",
            "Gonzalez Lopez",
            "Carrer Petritxol 76",
            "08012 ",
            "Barcelona",
            "Barcelona",
            "934578451",
            "677782365",
            "pedribarcelona@gmail.com",
            "25 Noviembre",
            "Gusto por el fútbol combinativo, el joven futbolista tiene una excelente conducción del balón y sus milimétricos pases rompen líneas defensivas.",
            R.drawable.pedri),

    )
    private set

    var contacto by mutableStateOf(Contactos(0,"","","","","","","","","","","",0))
        private set


    fun setaContacto(contacto:Contactos){//se le llama setaContacto por ya existir otro metodo setContacto
        this.contacto=contacto
    }


    fun getListaContactos():MutableList<Contactos>{
        return lista
    }

    fun IrInicio() {
        contacto=lista.first()
    }

    fun IrFinal() {
        contacto=lista.last()
    }

    fun IrDelante() {
        var indice=0
        lista.forEach { item ->
            if (item == contacto) {
                indice=lista.indexOf(item)+1

            }

        }
        if(indice<lista.size){
            contacto=lista[indice]
        }else{
            contacto=lista[indice-1]
        }
    }

    fun IrAtras() {
        var indice=0
        lista.forEach { item ->
            if (item == contacto) {
                indice=lista.indexOf(item)-1

            }

        }
        if(indice>=0){
            contacto=lista[indice]
        }else{
            contacto=lista[indice+1]
        }
    }

}