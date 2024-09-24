package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Get the BMI value passed from MainActivity
        val bmi = intent.getDoubleExtra("BMI", 0.0)

        // Find the TextView and set the BMI value
        val bmiTextView = findViewById<TextView>(R.id.bmiTextView)
        bmiTextView.text = "Your BMI is: %.2f".format(bmi)
    }
}
