package com.example.task_009

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var calculatorBTN: Button
    private lateinit var resultDataTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultDataTV    = findViewById(R.id.resultDataTV)
        calculatorBTN = findViewById(R.id.calculatorBTN)

        calculatorBTN.setOnClickListener{
            val intent = Intent(this, CalculatorActivity::class.java)
            launchSomeActivity.launch(intent)
        }
    }

    private val launchSomeActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val resultData = data!!.getStringExtra("resultData")
            resultDataTV.text = resultData;

            Toast.makeText(this, "result - $resultData", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
        }
    }
}