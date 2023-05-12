package com.daniel.geotuki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Cylinder : AppCompatActivity() {
    var height: EditText? = null
    var radius: EditText? = null
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null
    var Area: TextView? = null
    var Volume: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cylinder)
        height = findViewById(R.id.height)
        radius = findViewById(R.id.radius)
        Area = findViewById(R.id.area)
        Volume = findViewById(R.id.volume)
        btn1 = findViewById(R.id.btnres)
        btn2 = findViewById(R.id.btnreset)
        btn3 = findViewById(R.id.btnback)

        btn1?.setOnClickListener(View.OnClickListener {
            val strRadius = radius?.text.toString()
            val strHeight = height?.text.toString()

            if (strHeight.isNullOrEmpty()) {
                height?.error = "Ingresa la altura"
                height?.requestFocus()
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            if (strRadius.isNullOrEmpty()) {
                radius?.error = "Ingresa el radio"
                radius?.requestFocus()
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            val radius = strRadius.toFloat()
            val height = strHeight.toFloat()

            val area = (2 * Math.PI * radius * height) + (2 * Math.PI * radius * radius)
            val volume = Math.PI * radius * radius * height

            Area?.text = "Área: $area"
            Volume?.text = "Volumen: $volume"
        })

        btn2?.setOnClickListener(View.OnClickListener {
            height?.setText("")
            radius?.setText("")
            Area?.text = ""
            Volume?.text = ""
        })

        btn3?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Cylinder, Calculate2::class.java)
            startActivity(intent)
        })
    }
}