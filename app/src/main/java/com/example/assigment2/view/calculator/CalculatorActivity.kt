package com.example.assigment2.view.calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.assigment2.R
import com.example.assigment2.view.main.DashboardActivity
import kotlinx.android.synthetic.main.activity_calculator.*
import java.lang.String


class CalculatorActivity : AppCompatActivity() {

    var height = 0f
    var weight = 0f
    var bmiResult = 0f

    var heightTextView: TextView? = null
    var weightTextView: TextView? = null
    var bmiResultTextView: TextView? = null
    var heightSeekBar: SeekBar? = null
    var weightSeekBar: SeekBar? = null
    var backButon: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        backButon = findViewById(R.id.buttonBack)
        heightSeekBar = findViewById(R.id.heightSeekbar)
        weightSeekBar = findViewById(R.id.weightSeekbar)
        bmiResultTextView = findViewById(R.id.bmiValue)
        heightTextView = findViewById(R.id.heightText)
        weightTextView = findViewById(R.id.weightText)

        height()
        weight()
        initBtn()
    }

    private fun height() {
        heightSeekBar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                height = seekBar.progress.toFloat()
                heightTextView!!.text = height.toString() + "m"
                bmiResultTextView?.setText(String.valueOf(calculateBmi(weight, height)))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                height = seekBar.progress.toFloat()
                heightTextView!!.text = height.toString() + "m"
                bmiResultTextView?.setText(String.valueOf(calculateBmi(weight, height)))
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                height = seekBar.progress.toFloat()
                heightTextView!!.text = height.toString() + "m"
                bmiResultTextView?.setText(String.valueOf(calculateBmi(weight, height)))
            }
        })
    }

    private fun weight() {
        weightSeekBar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                weight = seekBar.progress.toFloat()
                weightTextView!!.text = weight.toString() + "kg"
                bmiResultTextView?.setText(String.valueOf(calculateBmi(weight, height)))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                weight = seekBar.progress.toFloat()
                weightTextView!!.text = weight.toString() + "kg"
                bmiResultTextView?.setText(String.valueOf(calculateBmi(weight, height)))
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                weight = seekBar.progress.toFloat()
                weightTextView!!.text = weight.toString() + "kg"
                bmiResultTextView?.setText(String.valueOf(calculateBmi(weight, height)))
            }
        })
    }

    private fun initBtn() {
        backButon!!.setOnClickListener {
            val intent = Intent(this@CalculatorActivity, DashboardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculateBmi(weight: Float, height: Float): kotlin.String {
        if (male_checkbox.isChecked) {
            male(weight, height)
        } else if (female_checkbox.isChecked) {
            female(weight, height)
        } else if (male_checkbox.isChecked && female_checkbox.isChecked) {
            Toast.makeText(applicationContext, "Pilih Satu Gender", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Masukan Gender", Toast.LENGTH_SHORT).show()
        }

        return bmiResult.toString()
}

    private fun male(weight: Float, height: Float) {
        val heightValue = height / 100
        bmiResult = weight / (heightValue * heightValue)
    }

    private fun female(weight: Float, height: Float) {
        val heightValue = height - 100
        bmiResult = (heightValue*90) / 100
    }
}

