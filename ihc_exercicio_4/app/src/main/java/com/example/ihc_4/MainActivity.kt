package com.example.ihc_4

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ihc_4.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat


class MainActivity : AppCompatActivity(), SensorEventListener, LocationListener {

    private lateinit var binding: ActivityMainBinding

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getLocation()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sensorManager = (getSystemService(SENSOR_SERVICE) as SensorManager)

        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            sensorManager.registerListener(
                this,
                sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManager.SENSOR_DELAY_NORMAL
            )
        } else {
            binding.tv1.text = "Light sensor not available"
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            sensorManager.registerListener(
                this,
                sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),
                SensorManager.SENSOR_DELAY_NORMAL
            )
        } else {
            binding.tv2.text = "Temperature sensor not available"
        }

        binding.getGPS.setOnClickListener {
            getLocation()
        }
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        if (p0?.sensor?.type == Sensor.TYPE_LIGHT) {
            binding.tv1.text = "Light intensity: ${p0.values?.get(0).toString()}"
        }
        if (p0?.sensor?.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            binding.tv2.text = "Temperature: ${p0.values?.get(0).toString()}"
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onLocationChanged(p0: Location) {
        getLocation()
    }

    private fun getLocation() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
        ) {
            binding.tv3.text = "Permission not granted"
            requestPermissionLauncher.launch(
                android.Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            val lm = this.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isGPSEnabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
            if (isGPSEnabled) {
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10f, this)
                val location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                binding.tv3.text =
                    "LAT: ${roundOffDecimal(location?.latitude ?: 0.0)}\n" +
                        "LONG: ${roundOffDecimal(location?.longitude ?: 0.0)}"
            } else {
                binding.tv3.text = "Please enable GPS"
            }
        }
    }

    private fun roundOffDecimal(number: Double): Double {
        val df = DecimalFormat("#.#####")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number).toDouble()
    }
}