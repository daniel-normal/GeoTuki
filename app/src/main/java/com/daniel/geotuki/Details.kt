package com.daniel.geotuki

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Details : AppCompatActivity() {
    private lateinit var myDialog: Dialog
    private lateinit var triangleDialog: Dialog
    private lateinit var squareDialog: Dialog
    private lateinit var rectangleDialog: Dialog
    private lateinit var circleDialog: Dialog
    private lateinit var pentagonDialog: Dialog
    private lateinit var hexagonDialog: Dialog

    private lateinit var triangleDialogDetail: Dialog
    private lateinit var squareDialogDetail: Dialog
    private lateinit var rectangleDialogDetail: Dialog
    private lateinit var circleDialogDetail: Dialog
    private lateinit var pentagonDialogDetail: Dialog
    private lateinit var hexagonDialogDetail: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        myDialog = Dialog(this)
        triangleDialog = Dialog(this)
        squareDialog = Dialog(this)
        rectangleDialog = Dialog(this)
        circleDialog = Dialog(this)
        pentagonDialog = Dialog(this)
        hexagonDialog = Dialog(this)

        triangleDialogDetail = Dialog(this)
        squareDialogDetail = Dialog(this)
        rectangleDialogDetail = Dialog(this)
        circleDialogDetail = Dialog(this)
        pentagonDialogDetail = Dialog(this)
        hexagonDialogDetail = Dialog(this)
    }

    fun showPopup(v: View) {
        when (v.id) {
            R.id.btndetail -> {
                myDialog.setContentView(R.layout.detail_popup)
                val txtClose: TextView = myDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    myDialog.dismiss()
                }
                myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                myDialog.show()
            }
            R.id.btnviewtriangle -> {
                triangleDialog.setContentView(R.layout.triangle_view)
                val txtClose: TextView = triangleDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    triangleDialog.dismiss()
                }
                triangleDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                triangleDialog.show()
            }
            R.id.btnviewsquare -> {
                squareDialog.setContentView(R.layout.square_view)
                val txtClose: TextView = squareDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    squareDialog.dismiss()
                }
                squareDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                squareDialog.show()
            }
            R.id.btnviewrectangle -> {
                rectangleDialog.setContentView(R.layout.rectangle_view)
                val txtClose: TextView = rectangleDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    rectangleDialog.dismiss()
                }
                rectangleDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                rectangleDialog.show()
            }
            R.id.btnviewcircle -> {
                circleDialog.setContentView(R.layout.circle_view)
                val txtClose: TextView = circleDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    circleDialog.dismiss()
                }
                circleDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                circleDialog.show()
            }

            R.id.btnviewpentagon -> {
                pentagonDialog.setContentView(R.layout.pentagon_view)
                val txtClose: TextView = pentagonDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    pentagonDialog.dismiss()
                }
                pentagonDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                pentagonDialog.show()
            }

            R.id.btnviewhexagon-> {
                hexagonDialog.setContentView(R.layout.hexagon_view)
                val txtClose: TextView = hexagonDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    hexagonDialog.dismiss()
                }
                hexagonDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                hexagonDialog.show()
            }

            R.id.btncalculatetriangle -> {
                val intent = Intent(this@Details, TriangleA::class.java)
                startActivity(intent)
            }

            R.id.btncalculatesquare -> {
                val intent = Intent(this@Details, SquareA::class.java)
                startActivity(intent)
            }

            R.id.btncalculaterectangle -> {
                val intent = Intent(this@Details, RectangleA::class.java)
                startActivity(intent)
            }

            R.id.btncalculatecircle -> {
                val intent = Intent(this@Details, CircleA::class.java)
                startActivity(intent)
            }

            R.id.btncalculatepentagon -> {
                val intent = Intent(this@Details, PentagonA::class.java)
                startActivity(intent)
            }

            R.id.btncalculatehexagon -> {
                val intent = Intent(this@Details, HexagonA::class.java)
                startActivity(intent)
            }

            R.id.btndetail2 -> {
                triangleDialogDetail.setContentView(R.layout.triangle_detail)
                val txtClose: TextView = triangleDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    triangleDialogDetail.dismiss()
                }
                triangleDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                triangleDialogDetail.show()
            }
            R.id.btndetail3 -> {
                squareDialogDetail.setContentView(R.layout.square_detail)
                val txtClose: TextView = squareDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    squareDialogDetail.dismiss()
                }
                squareDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                squareDialogDetail.show()
            }
            R.id.btndetail4 -> {
                rectangleDialogDetail.setContentView(R.layout.rectangle_detail)
                val txtClose: TextView = rectangleDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    rectangleDialogDetail.dismiss()
                }
                rectangleDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                rectangleDialogDetail.show()
            }
            R.id.btndetail5 -> {
                circleDialogDetail.setContentView(R.layout.circle_detail)
                val txtClose: TextView = circleDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    circleDialogDetail.dismiss()
                }
                circleDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                circleDialogDetail.show()
            }

            R.id.btndetail6 -> {
                pentagonDialogDetail.setContentView(R.layout.pentagon_detail)
                val txtClose: TextView = pentagonDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    pentagonDialogDetail.dismiss()
                }
                pentagonDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                pentagonDialogDetail.show()
            }

            R.id.btndetail7 -> {
                hexagonDialogDetail.setContentView(R.layout.hexagon_detail)
                val txtClose: TextView = hexagonDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    hexagonDialogDetail.dismiss()
                }
                hexagonDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                hexagonDialogDetail.show()
            }
        }
    }
}