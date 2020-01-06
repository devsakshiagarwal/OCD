package com.sakshi.ocdformapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var indiaCitiesList = arrayOf("Delhi", "Bombay", "Bangalore", "Lucknow", "Chennai")
    private var uaeCitiesList = arrayOf(
        "Dubai",
        "Abu Dhabi",
        "Ajman",
        "Fujairah",
        "Ras Al Khaimah",
        "Sharjah",
        "Umm Al Quwain"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        buttonSubmit.setOnClickListener {
            if (isNameValid() && isEmailValid()) {
                goToNextActivity()
            }
        }
        val spinnerIndia = ArrayAdapter(this, android.R.layout.simple_spinner_item, indiaCitiesList)
        val spinnerUae = ArrayAdapter(this, android.R.layout.simple_spinner_item, uaeCitiesList)
        spinnerCountry.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                i: Int,
                l: Long
            ) {
                if (i == 0) {
                    spinnerIndia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinnerCity.adapter = spinnerIndia
                } else {
                    spinnerUae.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinnerCity.adapter = spinnerUae
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
    }

    private fun goToNextActivity() {
        OutputActivity().startOutPutActivity(
            this, etName.text.toString(), etEmail.text.toString(),
            getGender(), spinnerCountry.selectedItem.toString(), spinnerCity.selectedItem.toString()
        )
    }

    private fun isNameValid(): Boolean {
        errorName.text = ""
        if (etName.text.toString().isEmpty()) {
            errorName.text = getString(R.string.err_name_blank)
        } else if (!Utils.isNameValid(etName.text.toString())) {
            errorName.text = getString(R.string.err_name)
        } else {
            return true
        }
        return false
    }

    private fun isEmailValid(): Boolean {
        errorEmail.text = ""
        if (etEmail.text.toString().isEmpty()) {
            errorEmail.text = getString(R.string.err_email_blank)
        } else if (!Utils.isEmailValid(etEmail.text.toString())) {
            errorEmail.text = getString(R.string.err_email)
        } else {
            return true
        }
        return false
    }

    private fun getGender(): String {
        return if (rgGender.checkedRadioButtonId == 0) {
            getString(R.string.male)
        } else {
            getString(R.string.female)
        }
    }
}
