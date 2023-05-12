package com.daniel.geotuki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlin.math.sqrt

class HexagonA : AppCompatActivity() {
    private lateinit var sideEditText: EditText
    private lateinit var perimeterEditText: EditText
    private lateinit var areaEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resetButton: Button
    private lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hexagon)
        sideEditText = findViewById(R.id.side)
        perimeterEditText = findViewById(R.id.perimeter)
        areaEditText = findViewById(R.id.area)
        calculateButton = findViewById(R.id.btncalculate)
        resetButton = findViewById(R.id.btnreset)
        backButton = findViewById(R.id.btnback)

        calculateButton.setOnClickListener {
            calculateValues()
        }

        resetButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HexagonA, HexagonA::class.java)
            startActivity(intent)
            finish()
        })

        backButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HexagonA, Calculate::class.java)
            startActivity(intent)
        })

        sideEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        perimeterEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        areaEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun calculateValues() {
        val sideText = sideEditText.text.toString().trim()
        val areaText = areaEditText.text.toString().trim()
        val perimeterText = perimeterEditText.text.toString().trim()

        if (!TextUtils.isEmpty(sideText)) {
            val side = parseDouble(sideText)
            val area = side * side
            val perimeter = 4 * side
            areaEditText.setText(area.toString())
            perimeterEditText.setText(perimeter.toString())
        }

        if (!TextUtils.isEmpty(areaText)) {
            val area = parseDouble(areaText)
            val side = sqrt(area)
            val perimeter = 4 * side
            sideEditText.setText(side.toString())
            perimeterEditText.setText(perimeter.toString())
        }

        if (!TextUtils.isEmpty(perimeterText)) {
            val perimeter = parseDouble(perimeterText)
            val side = perimeter / 4
            val area = side * side
            sideEditText.setText(side.toString())
            areaEditText.setText(area.toString())
        }
    }


    private fun parseDouble(text: String): Double {
        return if (text.isNotEmpty()) {
            text.toDouble()
        } else {
            0.0
        }
    }

}