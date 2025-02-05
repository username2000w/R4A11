package com.example.tp2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.tp2.ui.theme.TP2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column (
                        modifier = Modifier.padding(innerPadding).fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Greeting (
                            modifier = Modifier.padding(innerPadding)
                        )
                        yipee(
                            modifier = Modifier.padding(innerPadding),
                            onNavigate = { name ->
                                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                                intent.putExtra("USER_NAME", name)
                                startActivity(intent)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text (
        text = "Bienvenue",
        fontWeight = FontWeight.W600,
        modifier = modifier
    )
}

@Composable
fun yipee(modifier: Modifier = Modifier, onNavigate: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text (
            text = text
        )
        TextField (
            value = text,
            onValueChange = { text = it },
            label = { Text("Saisir votre nom") }
        )
        Button(onClick = { onNavigate(text) }) {
            Text("Valider")
        }
    }
}