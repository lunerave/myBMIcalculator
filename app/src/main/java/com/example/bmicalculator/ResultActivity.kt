package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("Height", 0)
        val weight = intent.getIntExtra("Weight", 0)

        val bmi = round((weight / (height / 100.0).pow(2.0))*10)/10
        val resultText = when{
            bmi >= 23 -> "Overweight"
            bmi >= 18.5 -> "Normal"
            else -> "Underweight"
        }
        val resultValueTextView = findViewById<TextView>(R.id.txt_bmi)
        val resultStringTextView = findViewById<TextView>(R.id.txt_result)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText

        val closeButton = findViewById<Button>(R.id.buttonClose)

        closeButton.setOnClickListener {
            finish()
        }
    }
}