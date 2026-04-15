package com.example.actividadjetpack.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actividadjetpack.Model.PerfilModel

@Composable
fun InfoAdicionalCard(perfil: PerfilModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F4FD)),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Información adicional", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Edad: ${perfil.edad} años", fontSize = 14.sp)
            Text("Ciudad: ${perfil.ciudad}", fontSize = 14.sp)
            Text("Correo: ${perfil.correo}", fontSize = 14.sp)
        }
    }
}