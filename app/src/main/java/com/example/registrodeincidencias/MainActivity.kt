package com.example.registrodeincidencias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.registrodeincidencias.ui.theme.RegistroDeIncidenciasTheme

// SARA PORTILLO 2924042022
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            RegistroDeIncidenciasTheme {
                RegistroIncidencias()
            }
        }
    }
}

@Composable
fun RegistroIncidencias() {

    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    var mensaje by remember {
        mutableStateOf("Aún no hay incidencias creadas")
    }

    // Indica si ya se creó una incidencia
    var incidenciaCreada by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Registro de Incidencias",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Ingresa la información de la incidencia que deseas reportar",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Título
        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = {
                Text("Título de la incidencia")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Descripción
        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = {
                Text("Descripción breve")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Botón Crear Reporte
        Button(
            onClick = {
                mensaje = "Reporte Creado: $titulo"
                incidenciaCreada = true

                titulo = ""
                descripcion = ""
            }
        ) {
            Text("Crear Reporte")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mensaje
        Text(
            text = mensaje,
            fontSize = 16.sp,
            color = if (incidenciaCreada) {
                Color(0xFF2E7D32)
            } else {
                Color.Unspecified
            },
            fontWeight = if (incidenciaCreada) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroIncidenciasPreview() {
    RegistroDeIncidenciasTheme {
        RegistroIncidencias()
    }
}