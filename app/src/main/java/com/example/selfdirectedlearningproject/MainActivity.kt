package com.example.selfdirectedlearningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

/**
 * Main activity
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAverage = findViewById<Button>(R.id.btn_calculate_avg)
        btnAverage.setOnClickListener { calculateAverage()}

        val btnStd = findViewById<Button>(R.id.btn_calculate_std)
        btnStd.setOnClickListener { calculateStd()}

        val btnAdd = findViewById<Button>(R.id.btn_calculate_add)
        btnAdd.setOnClickListener { calculateAddition() }

        val btnSubtract = findViewById<Button>(R.id.btn_calculate_subtract)
        btnSubtract.setOnClickListener { calculateSubtraction()}

        val btnDivide = findViewById<Button>(R.id.btn_calculate_divide)
        btnDivide.setOnClickListener { calculateDivision()}
    }

    /**
     * Subtracts the values that are provided in the edit_number text box.
     */
    private fun calculateSubtraction() {
        val editText = findViewById<EditText>(R.id.edit_number)
        val textOutput = findViewById<TextView>(R.id.text_output)
        val strInput = editText.text.toString()

        val numbers = strInput.split(",").mapNotNull { it.toDoubleOrNull() }

        if (numbers.isNotEmpty()) {
            val result = numbers.reduce { acc, number -> acc - number }
            textOutput.text = result.toString()
        } else {
            textOutput.text = getString(R.string.NaN)
        }
    }

    /**
     * Performs division on the values that are provided in the edit_number text box.
     */
    private fun calculateDivision() {
        val editText = findViewById<EditText>(R.id.edit_number)
        val textOutput = findViewById<TextView>(R.id.text_output)
        val strInput = editText.text.toString()

        val numbers = strInput.split(",").mapNotNull { it.toDoubleOrNull() }

        if (numbers.isNotEmpty()) {
            val result = numbers.reduce { acc, number -> acc / number }
            textOutput.text = result.toString()
        } else {
            textOutput.text = getString(R.string.NaN)
        }
    }

    /**
     * Adds the values that are provided in the edit_number text box.
     */
    private fun calculateAddition() {
        val editText = findViewById<EditText>(R.id.edit_number)
        val textOutput = findViewById<TextView>(R.id.text_output)
        val strInput = editText.text.toString()

        val result = strInput.split(",").mapNotNull { it.toDoubleOrNull() }.sum()
        textOutput.text = result.toString()
    }

    /**
     * Calculates the Standard Deviation of the values that are provided in the edit_number text box.
     */
    private fun calculateStd() {
        val editText = findViewById<EditText>(R.id.edit_number)
        val textOutput = findViewById<TextView>(R.id.text_output)
        val strInput = editText.text.toString()

        val numbers = strInput.split(",").mapNotNull { it.toDoubleOrNull() }

        // get the average of the numbers
        val mean = numbers.average()

        // get the sum of squared differences from the mean
        val sumOfSquaredDifferences = numbers.sumOf { (it - mean) * (it - mean) }

        // Calculate the variance (average of squared differences)
        val variance = sumOfSquaredDifferences / (numbers.size - 1)

        // Calculate the standard deviation (square root of variance)
        val standardDeviation = sqrt(variance)

        textOutput.text = standardDeviation.toString()
    }

    /**
     * Calculates the average of the values that are provided in the edit_number text box.
     */
    private fun calculateAverage() {
        val editText = findViewById<EditText>(R.id.edit_number)
        val textOutput = findViewById<TextView>(R.id.text_output)
        val strInput = editText.text.toString()

        val numbers = strInput.split(",").mapNotNull { it.toDoubleOrNull() }

        val result = numbers.average()
        textOutput.text = result.toString()
    }
}