package com.daniel.geotuki

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class DetailsShape : AppCompatActivity() {
    private lateinit var cubeDialog: Dialog
    private lateinit var sphereDialog: Dialog
    private lateinit var cylinderDialog: Dialog
    private lateinit var pyramidDialog: Dialog

    private lateinit var cubeDialogDetail: Dialog
    private lateinit var sphereDialogDetail: Dialog
    private lateinit var cylinderDialogDetail: Dialog
    private lateinit var pyramidDialogDetail: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_shape)
        cubeDialog = Dialog(this)
        sphereDialog = Dialog(this)
        cylinderDialog = Dialog(this)
        pyramidDialog = Dialog(this)
        cubeDialogDetail = Dialog(this)
        sphereDialogDetail = Dialog(this)
        cylinderDialogDetail = Dialog(this)
        pyramidDialogDetail = Dialog(this)
    }

    fun showPopup(v: View) {
        when (v.id) {
            R.id.btndetail1 -> {
                cubeDialogDetail.setContentView(R.layout.cube_detail)
                val txtClose: TextView = cubeDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    cubeDialogDetail.dismiss()
                }
                cubeDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                cubeDialogDetail.show()
            }

            R.id.btndetail2 -> {
                sphereDialogDetail.setContentView(R.layout.sphere_detail)
                val txtClose: TextView = sphereDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    sphereDialogDetail.dismiss()
                }
                sphereDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                sphereDialogDetail.show()
            }

            R.id.btndetail3 -> {
                cylinderDialogDetail.setContentView(R.layout.cylinder_detail)
                val txtClose: TextView = cylinderDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    cylinderDialogDetail.dismiss()
                }
                cylinderDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                cylinderDialogDetail.show()
            }

            R.id.btndetail4 -> {
                pyramidDialogDetail.setContentView(R.layout.pyramid_detail)
                val txtClose: TextView = pyramidDialogDetail.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    pyramidDialogDetail.dismiss()
                }
                pyramidDialogDetail.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                pyramidDialogDetail.show()
            }

            R.id.btnviewcube -> {
                cubeDialog.setContentView(R.layout.cube_view)
                val txtClose: TextView = cubeDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    cubeDialog.dismiss()
                }
                cubeDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                cubeDialog.show()
            }

            R.id.btnviewsphere -> {
                sphereDialog.setContentView(R.layout.sphere_view)
                val txtClose: TextView = sphereDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    sphereDialog.dismiss()
                }
                sphereDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                sphereDialog.show()
            }

            R.id.btnviewcylinder -> {
                cylinderDialog.setContentView(R.layout.cylinder_view)
                val txtClose: TextView = cylinderDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    cylinderDialog.dismiss()
                }
                cylinderDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                cylinderDialog.show()
            }

            R.id.btnviewpyramid -> {
                pyramidDialog.setContentView(R.layout.pyramid_view)
                val txtClose: TextView = pyramidDialog.findViewById(R.id.txtclose)
                txtClose.text = "X"
                txtClose.setOnClickListener {
                    pyramidDialog.dismiss()
                }
                pyramidDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                pyramidDialog.show()
            }

            R.id.btncalculatecube -> {
                val intent = Intent(this@DetailsShape, Cube::class.java)
                startActivity(intent)
            }

            R.id.btncalculatesphere -> {
                val intent = Intent(this@DetailsShape, Sphere::class.java)
                startActivity(intent)
            }

            R.id.btncalculatecylinder -> {
                val intent = Intent(this@DetailsShape, Cylinder::class.java)
                startActivity(intent)
            }

            R.id.btncalculatepyramid-> {
                val intent = Intent(this@DetailsShape, Pyramid::class.java)
                startActivity(intent)
            }
        }
    }
}