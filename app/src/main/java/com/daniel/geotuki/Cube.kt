package com.daniel.geotuki

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.cbrt
import kotlin.math.sqrt

class Cube : AppCompatActivity() {
    private lateinit var lengthEditText: EditText
    private lateinit var diagonalEditText: EditText
    private lateinit var areaEditText: EditText
    private lateinit var volumeEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resetButton: Button
    private lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cube)
        lengthEditText = findViewById(R.id.length)
        diagonalEditText = findViewById(R.id.diagonal)
        areaEditText = findViewById(R.id.area)
        volumeEditText = findViewById(R.id.volume)
        calculateButton = findViewById(R.id.btncalculate)
        resetButton = findViewById(R.id.btnreset)
        backButton = findViewById(R.id.btnback)
        calculateButton.setOnClickListener {
            calculateValues()
        }

        resetButton.setOnClickListener {
            val intent = Intent(this@Cube, Cube::class.java)
            startActivity(intent)
            finish()
        }

        backButton.setOnClickListener {
            val intent = Intent(this@Cube, Calculate::class.java)
            startActivity(intent)
        }

        lengthEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        diagonalEditText.addTextChangedListener(object : TextWatcher {
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

        volumeEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }
            override fun afterTextChanged(s: Editable?) {}
        })

    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun calculateValues() {
        val lengthText = lengthEditText.text.toString().trim()
        val diagonalText = diagonalEditText.text.toString().trim()
        val areaText = areaEditText.text.toString().trim()
        val volumeText = volumeEditText.text.toString().trim()

        if (!TextUtils.isEmpty(lengthText)) {
            val length = parseDouble(lengthText)
            val diagonal = sqrt(3.0) * length
            val area = 6 * length * length
            val volume = length * length * length
            diagonalEditText.setText(diagonal.toString())
            areaEditText.setText(area.toString())
            volumeEditText.setText(volume.toString())
        }

        if (!TextUtils.isEmpty(diagonalText)) {
            val diagonal = parseDouble(diagonalText)
            val length = diagonal / (sqrt(3.0))
            val area = 6 * length * length
            val volume = length * length * length
            lengthEditText.setText(length.toString())
            areaEditText.setText(area.toString())
            volumeEditText.setText(volume.toString())
        }

        if (!TextUtils.isEmpty(areaText)) {
            val area = parseDouble(areaText)
            val length = sqrt(area / 6)
            val diagonal = sqrt(3.0) * length
            val volume = length * length * length
            lengthEditText.setText(length.toString())
            diagonalEditText.setText(diagonal.toString())
            volumeEditText.setText(volume.toString())
        }

        if (!TextUtils.isEmpty(volumeText)) {
            val volume = parseDouble(volumeText)
            val length = cbrt(volume)
            val diagonal = sqrt(3.0) * length
            val area = 6 * length * length
            lengthEditText.setText(length.toString())
            diagonalEditText.setText(diagonal.toString())
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