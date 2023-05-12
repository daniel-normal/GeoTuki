package com.daniel.geotuki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class FigureOption : AppCompatActivity() {
    var btn1: Button? = null
    var btn2: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_figure_option)
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)

        btn1?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@FigureOption, Details::class.java)
            startActivity(intent)
        })

        btn2?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@FigureOption, DetailsShape::class.java)
            startActivity(intent)
        })
    }
}