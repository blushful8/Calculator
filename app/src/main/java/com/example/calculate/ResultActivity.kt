package com.example.calculate

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    private lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        textResult = findViewById(R.id.result_number)
        window.addFlags(1024)
        val getOperator = intent.getStringExtra("operator")
        val firstValue = intent.getIntExtra("first_value", 0)
        val secondValue = intent.getIntExtra("second_value", 0)
        check(
            operator = getOperator.toString(),
            firstValue = firstValue.toString().toInt(),
            secondValue = secondValue.toString().toInt()
        )
    }

    private fun check(operator: String, firstValue: Int, secondValue: Int) {
        var sum = 0
        when (operator) {
            "+" -> sum = firstValue + secondValue
            "-" -> sum = firstValue - secondValue
            "*" -> sum = firstValue * secondValue
            "/" -> sum = firstValue / secondValue
        }
        if (sum != 0) textResult.text = sum.toString() else textResult.text = "Немає відповіді"
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}