package com.example.calculate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    private lateinit var firstValueEditText: EditText
    private lateinit var secondValueEditText: EditText
    private lateinit var plusBtn: AppCompatButton
    private lateinit var minusBtn: AppCompatButton
    private lateinit var divBtn: AppCompatButton
    private lateinit var multiplyBtn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        window.addFlags(1024)
        val array = arrayOf(plusBtn, minusBtn, divBtn, multiplyBtn)
        val intent = Intent(this, ResultActivity::class.java)
        for (i in array.indices) {
            array[i].setOnClickListener {
                var getFirstValue = 0
                var getSecondValue = 0
                if (firstValueEditText.text.toString()
                        .isNotEmpty() && secondValueEditText.toString().isNotEmpty()
                ) {
                    getFirstValue = firstValueEditText.text.toString().toInt()
                    getSecondValue = secondValueEditText.text.toString().toInt()
                }
                when (i) {
                    0 -> {
                        intent.apply {
                            putExtra("first_value", getFirstValue)
                            putExtra("second_value", getSecondValue)
                            putExtra("operator", "+")
                        }
                        Log.d("TAG", "plus")
                    }
                    1 -> {
                        intent.apply {
                            putExtra("first_value", getFirstValue)
                            putExtra("second_value", getSecondValue)
                            putExtra("operator", "-")
                        }
                        Log.d("TAG", "minus")
                    }
                    2 -> {
                        intent.apply {
                            putExtra("first_value", getFirstValue)
                            putExtra("second_value", getSecondValue)
                            putExtra("operator", "/")
                        }
                        Log.d("TAG", "division")
                    }
                    3 -> {
                        intent.apply {
                            putExtra("first_value", getFirstValue)
                            putExtra("second_value", getSecondValue)
                            putExtra("operator", "*")
                        }
                        Log.d("TAG", "multiplication")
                    }
                }
                startActivity(intent)
            }
        }
    }

    private fun init() {
        firstValueEditText = findViewById(R.id.et_first_value)
        secondValueEditText = findViewById(R.id.et_second_value)
        plusBtn = findViewById(R.id.plus_btn)
        minusBtn = findViewById(R.id.minus_btn)
        divBtn = findViewById(R.id.div_btn)
        multiplyBtn = findViewById(R.id.multiply_btn)
    }
}