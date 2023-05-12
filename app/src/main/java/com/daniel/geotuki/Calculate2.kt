package com.daniel.geotuki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Calculate2 : AppCompatActivity() {
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null
    var btn4: Button? = null
    var btn5: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate2)

        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)
        btn5 = findViewById(R.id.button5)

        btn1?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate2, Cube::class.java)
            startActivity(intent)
        })

        btn2?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate2, Sphere::class.java)
            startActivity(intent)
        })

        btn3?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate2, Cylinder::class.java)
            startActivity(intent)
        })

        btn4?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate2, Pyramid::class.java)
            startActivity(intent)
        })

        btn5?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate2, OptionActivity::class.java)
            startActivity(intent)
        })
    }
}