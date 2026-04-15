package com.example.actividadjetpack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import com.example.actividadjetpack.Viewmodel.PerfilViewModel
import com.example.actividadjetpack.ui.components.SeccionLista
import com.example.actividadjetpack.ui.components.InfoAdicionalCard

@Composable
fun PerfilScreen(viewModel: PerfilViewModel) {
    val perfil by viewModel.perfil.collectAsStateWithLifecycle()
    val mostrarInfo by viewModel.mostrarInfoAdicional.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Foto de perfil con Coil
        SubcomposeAsyncImage(
            model = perfil.fotoUrl,
            contentDescription = "Foto de perfil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            loading = {
                CircularProgressIndicator(modifier = Modifier.size(40.dp))
            },
            error = {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFCCCCCC)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("", fontSize = 40.sp)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre
        Text(
            text = perfil.nombre,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1A2E)
        )

        // Programa y semestre
        Text(
            text = "${perfil.programa} • ${perfil.semestre}",
            fontSize = 14.sp,
            color = Color(0xFF666666)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Descripción
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Text(
                text = perfil.descripcion,
                modifier = Modifier.padding(16.dp),
                fontSize = 14.sp,
                color = Color(0xFF444444)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Botón mostrar/ocultar info adicional
        Button(
            onClick = { viewModel.toggleInfoAdicional() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1A1A2E))
        ) {
            Text(if (mostrarInfo) "Ocultar información adicional" else "Ver información adicional")
        }

        // Info adicional (interactiva)
        if (mostrarInfo) {
            Spacer(modifier = Modifier.height(8.dp))
            InfoAdicionalCard(perfil = perfil)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Secciones
        SeccionLista(titulo = "🎮 Hobbies", items = perfil.hobbies)
        SeccionLista(titulo = "🎨 Pasatiempos", items = perfil.pasatiempos)
        SeccionLista(titulo = "⚽ Deportes favoritos", items = perfil.deportes)
        SeccionLista(titulo = "💡 Intereses", items = perfil.intereses)

        Spacer(modifier = Modifier.height(24.dp))
    }
}