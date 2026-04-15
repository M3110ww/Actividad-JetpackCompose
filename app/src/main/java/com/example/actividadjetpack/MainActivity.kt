package com.example.actividadjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.actividadjetpack.Viewmodel.PerfilViewModel
import com.example.actividadjetpack.ui.screens.PerfilScreen
import com.example.actividadjetpack.ui.theme.ActividadJetpackTheme

class MainActivity : ComponentActivity() {
    private val viewModel: PerfilViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActividadJetpackTheme {
                PerfilScreen(viewModel = viewModel)
            }
        }
    }
}