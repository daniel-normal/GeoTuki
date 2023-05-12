package com.daniel.geotuki

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Calculate : AppCompatActivity() {
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null
    var btn4: Button? = null
    var btn5: Button? = null
    var btn6: Button? = null
    var btn7: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)
        btn5 = findViewById(R.id.button5)
        btn6 = findViewById(R.id.button6)
        btn7 = findViewById(R.id.button7)

        btn1?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate, TriangleA::class.java)
            startActivity(intent)
        })

        btn2?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate, RectangleA::class.java)
            startActivity(intent)
        })

        btn3?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate, CircleA::class.java)
            startActivity(intent)
        })

        btn4?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate, SquareA::class.java)
            startActivity(intent)
        })

        btn5?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate, PentagonA::class.java)
            startActivity(intent)
        })

        btn6?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate, HexagonA::class.java)
            startActivity(intent)
        })

        btn7?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calculate, OptionActivity::class.java)
            startActivity(intent)
        })
    }
}