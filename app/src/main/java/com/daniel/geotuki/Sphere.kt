package com.daniel.geotuki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import java.lang.Math.PI
import kotlin.math.pow

class Sphere : AppCompatActivity() {
    private lateinit var volumeEditText: EditText
    private lateinit var areaEditText: EditText
    private lateinit var diameterEditText: EditText
    private lateinit var circumferenceEditText: EditText
    private lateinit var radiusEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resetButton: Button
    private lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sphere)
        volumeEditText = findViewById(R.id.volume)
        areaEditText = findViewById(R.id.area)
        diameterEditText = findViewById(R.id.diameter)
        circumferenceEditText = findViewById(R.id.circumference)
        radiusEditText = findViewById(R.id.radius)
        calculateButton = findViewById(R.id.btncalculate)
        resetButton = findViewById(R.id.btnreset)
        backButton = findViewById(R.id.btnback)

        resetButton.setOnClickListener {
            val intent = Intent(this@Sphere, Sphere::class.java)
            startActivity(intent)
            finish()
        }

        backButton.setOnClickListener {
            val intent = Intent(this, Calculate2::class.java)
            startActivity(intent)
        }

        volumeEditText.addTextChangedListener(createTextWatcher())
        areaEditText.addTextChangedListener(createTextWatcher())
        diameterEditText.addTextChangedListener(createTextWatcher())
        circumferenceEditText.addTextChangedListener(createTextWatcher())
        radiusEditText.addTextChangedListener(createTextWatcher())

        calculateButton.setOnClickListener {
            calculateValues()
        }
    }

    private fun createTextWatcher(): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }
            override fun afterTextChanged(s: Editable?) {}
        }
    }

    private fun calculateValues() {
        val volumeText = volumeEditText.text.toString().trim()
        val areaText = areaEditText.text.toString().trim()
        val diameterText = diameterEditText.text.toString().trim()
        val circumferenceText = circumferenceEditText.text.toString().trim()
        val radiusText = radiusEditText.text.toString().trim()

        if (!TextUtils.isEmpty(volumeText)) {
            val volume = parseDouble(volumeText)
            val radius = calculateRadiusFromVolume(volume)
            val diameter = 2 * radius
            val circumference = 2 * PI * radius
            val area = 4 * PI * radius.pow(2)

            radiusEditText.setText(radius.toString())
            diameterEditText.setText(diameter.toString())
            circumferenceEditText.setText(circumference.toString())
            areaEditText.setText(area.toString())
        } else if (!TextUtils.isEmpty(areaText)) {
            val area = parseDouble(areaText)
            val radius = calculateRadiusFromArea(area)
            val diameter = 2 * radius
            val circumference = 2 * PI * radius
            val volume = (4.0 / 3.0) * PI * radius.pow(3)

            radiusEditText.setText(radius.toString())
            diameterEditText.setText(diameter.toString())
            circumferenceEditText.setText(circumference.toString())
            volumeEditText.setText(volume.toString())
        } else if (!TextUtils.isEmpty(diameterText)) {
            val diameter = parseDouble(diameterText)
            val radius = diameter / 2
            val circumference = 2 * PI * radius
            val area = 4 * PI * radius.pow(2)
            val volume = (4.0 / 3.0) * PI * radius.pow(3)

            radiusEditText.setText(radius.toString())
            diameterEditText.setText(diameter.toString())
            circumferenceEditText.setText(circumference.toString())
            areaEditText.setText(area.toString())
            volumeEditText.setText(volume.toString())
        } else if (!TextUtils.isEmpty(circumferenceText)) {
            val circumference = parseDouble(circumferenceText)
            val radius = circumference / (2 * PI)
            val diameter = 2 * radius
            val area = 4 * PI * radius.pow(2)
            val volume = (4.0 / 3.0) * PI * radius.pow(3)

            radiusEditText.setText(radius.toString())
            diameterEditText.setText(diameter.toString())
            areaEditText.setText(area.toString())
            volumeEditText.setText(volume.toString())
        } else if (!TextUtils.isEmpty(radiusText)) {
            val radius = parseDouble(radiusText)
            val diameter = 2 * radius
            val circumference = 2 * PI * radius
            val area = 4 * PI * radius.pow(2)
            val volume = (4.0 / 3.0) * PI * radius.pow(3)

            diameterEditText.setText(diameter.toString())
            circumferenceEditText.setText(circumference.toString())
            areaEditText.setText(area.toString())
            volumeEditText.setText(volume.toString())
        }
    }

    private fun calculateRadiusFromVolume(volume: Double): Double {
        return (3 * volume / (4 * PI)).pow(1/3.0)
    }

    private fun calculateRadiusFromArea(area: Double): Double {
        return kotlin.math.sqrt(area / (4 * PI))
    }


    private fun parseDouble(text: String): Double {
        return if (text.isNotEmpty()) {
            text.toDouble()
        } else {
            0.0
        }
    }
}