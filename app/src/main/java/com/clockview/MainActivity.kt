package com.clockview

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.library.clockview.ClockView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clockView = findViewById<ClockView>(R.id.clockImageView)
        clockView.setClockBgColor(ContextCompat.getColor(this, R.color.colorPrimary))
        setupClockView(clockView)
    }

    private fun setupClockView(clockView: ClockView) {
        val startTime = Date()
        val calendar = Calendar.getInstance()
        calendar.time = startTime
        clockView.setHour(calendar.get(Calendar.HOUR_OF_DAY))
        clockView.setMinute(calendar.get(Calendar.MINUTE))

        clockView.setClockColor(ContextCompat.getColor(this, R.color.colorAccent))
    }

}
