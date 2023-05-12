package com.daniel.geotuki

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Double.parseDouble

class CircleA : AppCompatActivity() {
    private lateinit var radioEditText: EditText
    private lateinit var diametroEditText: EditText
    private lateinit var circunferenciaEditText: EditText
    private lateinit var areaEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resetButton: Button
    private lateinit var backButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle)
        radioEditText = findViewById(R.id.radio)
        diametroEditText = findViewById(R.id.diametro)
        circunferenciaEditText = findViewById(R.id.circunferencia)
        areaEditText = findViewById(R.id.area)
        calculateButton = findViewById(R.id.btncalculate)
        resetButton = findViewById(R.id.btnreset)
        backButton = findViewById(R.id.btnback)
        calculateButton?.setOnClickListener {
            calculateValues()
        }
        resetButton?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@CircleA, CircleA::class.java)
            startActivity(intent)
            finish()
        })
        backButton?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@CircleA, Calculate::class.java)
            startActivity(intent)
        })

        radioEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        diametroEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        circunferenciaEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        areaEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                calculateButton.isEnabled = true
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun calculateValues() {
        val radioText = radioEditText.text.toString().trim()
        val diametroText = diametroEditText.text.toString().trim()
        val circunferenciaText = circunferenciaEditText.text.toString().trim()
        val areaText = areaEditText.text.toString().trim()

        val radio = parseDouble(radioText)
        val diametro = parseDouble(diametroText)
        val circunferencia = parseDouble(circunferenciaText)
        val area = parseDouble(areaText)

        if (TextUtils.isEmpty(radioText) && diametro != 0.0) {
            val radioFromDiametro = diametro / 2
            radioEditText.setText(radioFromDiametro.toString())
        } else if (TextUtils.isEmpty(diametroText) && radio != 0.0) {
            val diametroFromRadio = radio * 2
            diametroEditText.setText(diametroFromRadio.toString())
        }

        if (TextUtils.isEmpty(circunferenciaText) && radio != 0.0) {
            val circunferenciaFromRadio = 2 * Math.PI * radio
            circunferenciaEditText.setText(circunferenciaFromRadio.toString())
        } else if (TextUtils.isEmpty(radioText) && circunferencia != 0.0) {
            val radioFromCircunferencia = circunferencia / (2 * Math.PI)
            radioEditText.setText(radioFromCircunferencia.toString())
        }

        if (TextUtils.isEmpty(areaText) && radio != 0.0) {
            val areaFromRadio = Math.PI * radio * radio
            areaEditText.setText(areaFromRadio.toString())
        } else if (TextUtils.isEmpty(radioText) && area != 0.0) {
            val radioFromArea = Math.sqrt(area / Math.PI)
            radioEditText.setText(radioFromArea.toString())
        }

        if (TextUtils.isEmpty(diametroText) && circunferencia != 0.0) {
            val diametroFromCircunferencia = circunferencia / Math.PI
            diametroEditText.setText(diametroFromCircunferencia.toString())
        } else if (TextUtils.isEmpty(circunferenciaText) && diametro != 0.0) {
            val circunferenciaFromDiametro = Math.PI * diametro
            circunferenciaEditText.setText(circunferenciaFromDiametro.toString())
        }

        if (TextUtils.isEmpty(areaText) && circunferencia != 0.0) {
            val areaFromCircunferencia = (circunferencia * circunferencia) / (4 * Math.PI)
            areaEditText.setText(areaFromCircunferencia.toString())
        } else if (TextUtils.isEmpty(circunferenciaText) && area != 0.0) {
            val circunferenciaFromArea = (2 * Math.PI) * Math.sqrt(area / Math.PI)
            circunferenciaEditText.setText(circunferenciaFromArea.toString())
        }

        if (TextUtils.isEmpty(areaText) && diametro != 0.0) {
            val areaFromDiametro = (Math.PI * diametro * diametro) / 4
            areaEditText.setText(areaFromDiametro.toString())
        } else if (TextUtils.isEmpty(diametroText) && area != 0.0) {
            val diametroFromArea = Math.sqrt((4 * area) / Math.PI)
            diametroEditText.setText(diametroFromArea.toString())
        }
        calculateButton.isEnabled = false
    }


    private fun parseDouble(text: String): Double {
        return if (text.isNotEmpty()) {
            text.toDouble()
        } else {
            0.0
        }
    }
}