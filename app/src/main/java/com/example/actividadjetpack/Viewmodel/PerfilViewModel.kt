package com.example.actividadjetpack.Viewmodel

import androidx.lifecycle.ViewModel
import com.example.actividadjetpack.Model.PerfilModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PerfilViewModel : ViewModel() {

    private val _perfil = MutableStateFlow(
        PerfilModel(
            nombre = "Jamer Ardila Ramirez",
            programa = "Ingeniería de Software",
            semestre = "5to Semestre",
            descripcion = "Estudiante apasionado por el desarrollo de software y las nuevas tecnologías.",
            edad = 20,
            ciudad = "Bogotá",
            correo = "jjardila@ucundinamarca.edu.co",
            fotoUrl = "https://s2.coinmarketcap.com/static/img/coins/200x200/34125.png",
            hobbies = listOf("Programar", "Montar bici", "Leer", "Escuchar música"),
            pasatiempos = listOf("Ver series", "Cocinar", "Dibujar", "Viajar"),
            deportes = listOf("BMX", "Skate", "Basquetball"),
            intereses = listOf("Inteligencia Artificial", "Desarrollo móvil", "Diseño de aplicaciones")
        )
    )
    val perfil: StateFlow<PerfilModel> = _perfil

    private val _mostrarInfoAdicional = MutableStateFlow(false)
    val mostrarInfoAdicional: StateFlow<Boolean> = _mostrarInfoAdicional

    fun toggleInfoAdicional() {
        _mostrarInfoAdicional.value = !_mostrarInfoAdicional.value
    }
}