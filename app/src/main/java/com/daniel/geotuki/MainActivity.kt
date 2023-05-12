package com.daniel.geotuki

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var btn1: Button? = null
    var btn2: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)

        btn1?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, OptionActivity::class.java)
            startActivity(intent)
        })

        btn2?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, FigureOption::class.java)
            startActivity(intent)
        })
    }
}