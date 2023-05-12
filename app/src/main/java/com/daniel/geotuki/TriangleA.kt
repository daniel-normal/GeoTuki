package com.daniel.geotuki

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.sqrt
import kotlin.math.sqrt

class TriangleA : AppCompatActivity() {
    var Base: EditText? = null
    var Side1: EditText? = null
    var Side2: EditText? = null
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null
    var Perimeter: TextView? = null
    var Area: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triangle)

        Base = findViewById(R.id.base)
        Side1 = findViewById(R.id.side1)
        Side2 = findViewById(R.id.side2)
        btn1 = findViewById(R.id.btnres)
        btn2 = findViewById(R.id.btnreset)
        btn3 = findViewById(R.id.btnback)
        Perimeter = findViewById(R.id.perimeter)
        Area = findViewById(R.id.area)

        btn1?.setOnClickListener(View.OnClickListener {
            val StrBase = Base?.text.toString()
            val StrSide1 = Side1?.text.toString()
            val StrSide2 = Side2?.text.toString()

            if (StrBase.isNullOrEmpty()) {
                Base?.error = "Ingresa la base"
                Base?.requestFocus()
                Toast.makeText(this@TriangleA, "La base no puede estar vacía", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            if (StrSide1.isNullOrEmpty()) {
                Side1?.error = "Ingresa el lado A"
                Side1?.requestFocus()
                Toast.makeText(this@TriangleA, "El lado 1 no puede estar vacío", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            if (StrSide2.isNullOrEmpty()) {
                Side2?.error = "Ingresa el lado B"
                Side2?.requestFocus()
                Toast.makeText(this@TriangleA, "El lado 2 no puede estar vacío", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            val base = StrBase.toFloat()
            val side1 = StrSide1.toFloat()
            val side2 = StrSide2.toFloat()

            if (!isTriangleValid(base, side1, side2)) {
                Toast.makeText(this@TriangleA, "Los lados no forman un triángulo válido", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }

            val area = calculateTriangleArea(base, side1, side2)
            val perimeter = base + side1 + side2

            Area?.text = "Área = $area"
            Perimeter?.text = "Perímetro = $perimeter"
        })

        btn2?.setOnClickListener(View.OnClickListener {
            Base?.setText("")
            Side1?.setText("")
            Side2?.setText("")
            Area?.text = ""
        })

        btn3?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@TriangleA, Calculate::class.java)
            startActivity(intent)
        })
    }

    private fun isTriangleValid(base: Float, side1: Float, side2: Float): Boolean {
        return (base + side1 > side2) && (base + side2 > side1) && (side1 + side2 > base)
    }

    private fun calculateTriangleArea(base: Float, side1: Float, side2: Float): Float {
        val semiPerimeter = (base + side1 + side2) / 2
        return sqrt(semiPerimeter * (semiPerimeter - base) * (semiPerimeter - side1) * (semiPerimeter))
    }
}
