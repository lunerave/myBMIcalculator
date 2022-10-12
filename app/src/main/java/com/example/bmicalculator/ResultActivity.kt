package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("Height", 0)
        val weight = intent.getIntExtra("Weight", 0)

        val bmi = weight / (height / 100.0).pow(2.0)
        val resultText = when{
            bmi >= 23.0 -> "Overweight"
            bmi <= 18.5 -> "Normal"
            else -> "Underweight"
        }
        val resultValueTextView = findViewById<TextView>(R.id.txt_bmi)
        val resultStringTextView = findViewById<TextView>(R.id.txt_result)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}