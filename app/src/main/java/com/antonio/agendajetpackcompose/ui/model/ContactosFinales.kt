package com.antonio.agendajetpackcompose.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class ContactosFinales(
    var id:Int,
    var nombre:String,
    var apellidos:String,
    var Direccion:String,
    var codigoPostal:String,
    var ciudad:String,
    var provincia:String,
    var telefonoFijo:String,
    var telefonoMovil:String,
    var email:String,
    var cumpleaños:String,
    var observaciones:String,
    var foto:ByteArray,
)