package com.example.registrodeincidencias
import androidx.compose.ui.platform.LocalFocusManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val focusManager = LocalFocusManager.current
        var mensaje by remember {
        mutableStateOf("Aún no hay incidencias creadas")
    }


    var incidenciaCreada by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF2563EB), Color(0xFF1D4ED8), Color(0xFF1E293B))
                    )
                )
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    color = Color.White.copy(alpha = 0.1f),
                    radius = size.width * 0.4f,
                    center = androidx.compose.ui.geometry.Offset(size.width * 0.1f, size.height * 0.2f)
                )
                drawCircle(
                    color = Color.White.copy(alpha = 0.05f),
                    radius = size.width * 0.6f,
                    center = androidx.compose.ui.geometry.Offset(size.width * 0.9f, size.height * 0.4f)
                )
            }


            IconButton(
                onClick = {  },
                modifier = Modifier
                    .padding(top = 20.dp, start = 16.dp)
                    .align(Alignment.TopStart)
            ) {
                Text(
                    text = "←",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }


        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 220.dp),
            color = Color.White,
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                // TITULO PPAL
                Text(
                    text = "Registro de Incidencias",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                //SUBTITULO
                Text(
                    text = "Ingresa la información de la incidencia que deseas reportar",
                    fontSize = 14.sp,
                    color = Color(0xFF64748B),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                //TITULO
                OutlinedTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    label = { Text("Título de la incidencia") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2563EB),
                        unfocusedBorderColor = Color(0xFFE2E8F0),
                        unfocusedContainerColor = Color(0xFFF8FAFC),
                        focusedContainerColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // DESCRIPCION
                OutlinedTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    label = { Text("Descripción breve") },
                    modifier = Modifier.fillMaxWidth().height(130.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF2563EB),
                        unfocusedBorderColor = Color(0xFFE2E8F0),
                        unfocusedContainerColor = Color(0xFFF8FAFC),
                        focusedContainerColor = Color.White
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                // BOTON
                Button(
                    onClick = {
                        mensaje = "Reporte Creado: $titulo"
                        incidenciaCreada = true

                        titulo = ""
                        descripcion = ""
                        focusManager.clearFocus()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2563EB)
                    )
                ) {
                    Text(
                        text = "Crear Reporte",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                // MENSAJE FINAL
                if (mensaje.isNotEmpty()) {
                    Surface(
                        color = if (incidenciaCreada) Color(0xFFE8F5E9) else Color(0xFFF1F5F9),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = mensaje,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            fontSize = 14.sp,
                            color = if (incidenciaCreada) Color(0xFF2E7D32) else Color(0xFF64748B),
                            fontWeight = if (incidenciaCreada) FontWeight.Bold else FontWeight.Normal,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroIncidenciasPreview() {
    RegistroDeIncidenciasTheme {
        RegistroIncidencias()
    }
}