package com.daniel.geotuki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Pyramid : AppCompatActivity() {
    private var height: EditText? = null
    private var base: EditText? = null
    private var btnCalculate: Button? = null
    private var btnReset: Button? = null
    private var btnBack: Button? = null
    private var area: TextView? = null
    private var volume: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pyramid)
        height = findViewById(R.id.height)
        base = findViewById(R.id.base)
        area = findViewById(R.id.area)
        volume = findViewById(R.id.volume)
        btnCalculate = findViewById(R.id.btnres)
        btnReset = findViewById(R.id.btnreset)
        btnBack = findViewById(R.id.btnback)
        btnCalculate?.setOnClickListener(View.OnClickListener {
            val strHeight = height?.text.toString()
            val strBase = base?.text.toString()

            if (strHeight.isNullOrEmpty()) {
                height?.error = "Ingresa la altura"
                height?.requestFocus()
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            if (strBase.isNullOrEmpty()) {
                base?.error = "Ingresa la base"
                base?.requestFocus()
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            val pyramidHeight = strHeight.toFloat()
            val pyramidBase = strBase.toFloat()

            val pyramidArea = calculatePyramidArea(pyramidBase, pyramidHeight)
            val pyramidVolume = calculatePyramidVolume(pyramidBase, pyramidHeight)

            area?.text = "Área: $pyramidArea"
            volume?.text = "Volumen: $pyramidVolume"
        })

        btnReset?.setOnClickListener(View.OnClickListener {
            height?.setText("")
            base?.setText("")
            area?.text = ""
            volume?.text = ""
        })

        btnBack?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Pyramid, Calculate::class.java)
            startActivity(intent)
        })
    }

    private fun calculatePyramidArea(base: Float, height: Float): Float {
        val baseArea = base * base
        val sideArea = base * height

        return baseArea + (2 * sideArea)
    }

    private fun calculatePyramidVolume(base: Float, height: Float): Float {
        return (base * base * height) / 3
    }
}