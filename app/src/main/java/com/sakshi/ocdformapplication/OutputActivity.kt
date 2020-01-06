package com.sakshi.ocdformapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_output.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class OutputActivity : AppCompatActivity() {

    private val nameVal = "name"
    private val emailVal = "email"
    private val genderVal = "gender"
    private val countryVal = "country"
    private val cityVal = "city"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)
        initViews()
    }

    private fun initViews() {
        etName.text = intent.getStringExtra(nameVal).toString()
        etEmail.text = intent.getStringExtra(emailVal).toString()
        etGender.text = intent.getStringExtra(genderVal).toString()
        spinnerCountry.text = intent.getStringExtra(countryVal).toString()
        spinnerCity.text = intent.getStringExtra(cityVal).toString()
    }
    
    fun startOutPutActivity(
        activity: MainActivity,
        name: String,
        email: String,
        gender: String,
        country: String,
        city: String
    ) {
        val intent = Intent(activity, OutputActivity::class.java).apply {
            putExtra(nameVal, name)
                .putExtra(emailVal, email)
                .putExtra(genderVal, gender)
                .putExtra(countryVal, country)
                .putExtra(cityVal, city)
        }
        activity.startActivity(intent)
    }


}
