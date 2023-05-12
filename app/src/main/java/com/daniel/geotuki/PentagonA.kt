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
import java.lang.Double.parseDouble

class PentagonA : AppCompatActivity() {
    private lateinit var sideEditText: EditText
    private lateinit var perimeterEditText: EditText
    private lateinit var areaEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resetButton: Button
    private lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pentagon)

        sideEditText = findViewById(R.id.side)
        perimeterEditText = findViewById(R.id.perimeter)
        areaEditText = findViewById(R.id.area)
        calculateButton = findViewById(R.id.btncalculate)
        resetButton = findViewById(R.id.btnreset)
        backButton = findViewById(R.id.btnback)
        calculateButton?.setOnClickListener {
            calculateValues()
        }

        resetButton?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@PentagonA, PentagonA::class.java)
            startActivity(intent)
            finish()
        })

        backButton?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@PentagonA, Calculate::class.java)
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

        val side = parseDouble(sideText)
        val area = parseDouble(areaText)
        val perimeter = parseDouble(perimeterText)

        if (TextUtils.isEmpty(sideText) && area != 0.0) {
            val sideFromArea = Math.sqrt((area * 4) / (Math.sqrt(5.0 * (5.0 + 2.0 * Math.sqrt(5.0)))))
            sideEditText.setText(sideFromArea.toString())
        } else if (TextUtils.isEmpty(areaText) && side != 0.0) {
            val areaFromSide = (0.25 * Math.sqrt(5.0 * (5.0 + 2.0 * Math.sqrt(5.0))) * side * side)
            areaEditText.setText(areaFromSide.toString())
        }

        if (TextUtils.isEmpty(sideText) && perimeter != 0.0) {
            val sideFromPerimeter = perimeter / 5
            sideEditText.setText(sideFromPerimeter.toString())
        } else if (TextUtils.isEmpty(perimeterText) && side != 0.0) {
            val perimeterFromSide = side * 5
            perimeterEditText.setText(perimeterFromSide.toString())
        }

        if (TextUtils.isEmpty(areaText) && perimeter != 0.0) {
            val areaFromPerimeter = (perimeter * perimeter) / (4 * Math.sqrt(5.0 * (5.0 + 2.0 * Math.sqrt(5.0))))
            areaEditText.setText(areaFromPerimeter.toString())
        } else if (TextUtils.isEmpty(perimeterText) && area != 0.0) {
            val perimeterFromArea = Math.sqrt((area * 4) / (Math.sqrt(5.0 * (5.0 + 2.0 * Math.sqrt(5.0)))))
            perimeterEditText.setText(perimeterFromArea.toString())
        }
        calculateButton.isEnabled = false
    }


    private fun parseDouble(text: String): Double {
        return if (text.isNotEmpty()) {
            text.toDouble()
        } else {
            0.0
        }
    }

}