package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Finding views by their ID
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val heightFeetEditText = findViewById<EditText>(R.id.heightFeet)
        val heightInchesEditText = findViewById<EditText>(R.id.heightInches)
        val weightEditText = findViewById<EditText>(R.id.weight)
        val ageEditText = findViewById<EditText>(R.id.age)
        val genderGroup = findViewById<RadioGroup>(R.id.genderGroup)

        // Set up the Calculate BMI button
        calculateButton.setOnClickListener {
            // Retrieve values from the input fields
            val heightFeet = heightFeetEditText.text.toString().toIntOrNull() ?: 0
            val heightInches = heightInchesEditText.text.toString().toIntOrNull() ?: 0
            val weight = weightEditText.text.toString().toDoubleOrNull() ?: 0.0
            val age = ageEditText.text.toString().toIntOrNull() ?: 0

            // Validate inputs
            if (heightFeet == 0 && heightInches == 0 || weight == 0.0 || age == 0) {
                Toast.makeText(this, "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
            } else {
                // Calculate the total height in inches
                val totalHeightInches = heightFeet * 12 + heightInches

                // Calculate BMI using the formula: weight (lbs) / [height (in)]^2 x 703
                val bmi = if (totalHeightInches > 0) (weight / (totalHeightInches * totalHeightInches)) * 703 else 0.0

                // Start ResultActivity and pass the BMI value
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("BMI", bmi)
                startActivity(intent)
            }
        }
    }
}
