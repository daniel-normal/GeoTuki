package com.daniel.geotuki

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SquareA : AppCompatActivity() {
    var length: EditText? = null
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null

    var Area: TextView? = null
    var Perimeter: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        length = findViewById(R.id.length)
        btn1 = findViewById(R.id.btnres)
        btn2 = findViewById(R.id.btnreset)
        btn3 = findViewById(R.id.btnback)
        Area = findViewById(R.id.area)
        Perimeter = findViewById(R.id.perimeter)

        btn1?.setOnClickListener(View.OnClickListener {
            if (length?.text.isNullOrEmpty()) {
                length?.error = "Ingresa la longitud de uno de los lados"
                length?.requestFocus()
                Toast.makeText(this, "Ingrese un valor para el lado", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            val sideLength = length?.text.toString().toDouble()
            val area = sideLength * sideLength
            val perimeter = 4 * sideLength

            Area?.text = "Área = $area"
            Perimeter?.text = "Perímetro = $perimeter"
        })


        btn2?.setOnClickListener(View.OnClickListener {
            length?.setText(" ")
            Area?.setText(" ")
            Perimeter?.setText(" ")
        })

        btn3?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SquareA, Calculate::class.java)
            startActivity(intent)
        })
    }
}
