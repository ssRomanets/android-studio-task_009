package com.example.task_009

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {

    private lateinit var resultData: String

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var buttonSumBTN: Button
    private lateinit var buttonDifBTN: Button
    private lateinit var buttonMultBTN: Button
    private lateinit var buttonDivBTN: Button

    private lateinit var transmitDataBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        resultData = ""

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)

        buttonSumBTN = findViewById(R.id.buttonSumBTN)
        buttonDifBTN = findViewById(R.id.buttonDifBTN)
        buttonMultBTN = findViewById(R.id.buttonMultBTN)
        buttonDivBTN = findViewById(R.id.buttonDivBTN)

        transmitDataBTN = findViewById(R.id.transmitDataBTN)
        transmitDataBTN.setOnClickListener{
            val intent = Intent()
            intent.putExtra("resultData", resultData)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun onButtonClick(v: View) {
        var first = firstOperandET.text.toString().toDouble()
        var second = secondOperandET.text.toString().toDouble()

        resultData = when(v.id) {
            R.id.buttonSumBTN -> Operation(first,second).sum()
            R.id.buttonDifBTN -> Operation(first,second).dif()
            R.id.buttonMultBTN -> Operation(first,second).mult()
            R.id.buttonDivBTN -> Operation(first,second).div()
            else -> 0.0
        }.toString()

        firstOperandET.setText("")
        secondOperandET.setText("")
    }
}