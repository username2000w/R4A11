package com.example.tp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

const val EXTRA_TEXT = "text_to_display"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val premierBouton : Button = findViewById(R.id.buttonValider)
        val premierTextView : TextView = findViewById(R.id.textView)
        val premierTextInput : TextInputEditText = findViewById(R.id.textInputEditText)
        premierBouton.setOnClickListener {
            premierTextView.text = premierTextInput.text.toString()
        }
        val buttonNext : Button = findViewById(R.id.buttonNext)
        buttonNext.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(EXTRA_TEXT, premierTextView.text.toString())
            startActivity(intent)
        }
    }
}