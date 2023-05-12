package com.daniel.geotuki

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RectangleA : AppCompatActivity() {
    var height: EditText? = null
    var width: EditText? = null
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null
    var Area: TextView? = null
    var Perimeter: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectangle)

        height = findViewById(R.id.height)
        width = findViewById(R.id.width)
        Area = findViewById(R.id.area)
        Perimeter = findViewById(R.id.perimeter)
        btn1 = findViewById(R.id.btnres)
        btn2 = findViewById(R.id.btnreset)
        btn3 = findViewById(R.id.btnback)

        btn1?.setOnClickListener(View.OnClickListener {
            val Strwidth = width?.text.toString()
            val Strheight = height?.text.toString()
            if (Strheight.isNullOrEmpty()) {
                height?.error = "Ingresa la altura"
                height?.requestFocus()
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            if (Strwidth.isNullOrEmpty()) {
                width?.error = "Ingresa la base"
                width?.requestFocus()
                Toast.makeText(this, "Ingrese un valor válido", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val width = Strwidth.toFloat()
            val height = Strheight.toFloat()
            val area = width * height
            val perimeter = 2 * (width + height)

            Area?.text = "ÁREA = $area"
            Perimeter?.text = "PERÍMETRO = $perimeter"
        })

        btn2?.setOnClickListener(View.OnClickListener {
            height?.setText("")
            width?.setText("")
            Area?.text = ""
            Perimeter?.text = ""
        })

        btn3?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@RectangleA, Calculate::class.java)
            startActivity(intent)
        })
    }
}
