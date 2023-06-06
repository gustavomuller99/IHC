package com.example.ihc_3

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.ihc_3.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.abs

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var binding: ActivityMainBinding
    private var a = arrayListOf(0.0, 0.0, 0.0)
    private val threshold = 2.0
    private var thresholdFired = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        if (sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) != null) {
            sensorManager.registerListener(
                this,
                sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        thresholdFired = false
    }

    private fun onAccelerationThreshold() {
        if (!thresholdFired) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.MESSAGE, "Accelerometer Threshold")
            startActivity(intent)
        }
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        if (p0?.sensor?.type == Sensor.TYPE_LINEAR_ACCELERATION) {
            for (i in 0..2) {
                a[i] = (p0.values?.get(i)?.toDouble() ?: 0.0)
                if (abs(a[i]) >= threshold) {
                    onAccelerationThreshold()
                    thresholdFired = true
                }
            }
            binding.et1.setText(roundOffDecimal(a[0]).toString())
            binding.et2.setText(roundOffDecimal(a[1]).toString())
            binding.et3.setText(roundOffDecimal(a[2]).toString())
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    private fun roundOffDecimal(number: Double): Double {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number).toDouble()
    }
}