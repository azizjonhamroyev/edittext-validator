package com.hamroyevazizjon.edittextinputvalidator

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.hamroyevazizjon.edittextinputvalidator.databinding.ActivityMainBinding
import com.hamroyevazizjon.edittextvalidator.EditTextValidator


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clearBtn.setOnClickListener {
            EditTextValidator.clearEditTexts(
                binding.emailAddress,
                binding.firstName,
                binding.ipAdress,
                binding.lastName,
                binding.password,
                binding.reEnterPass,
                binding.telNum,
                binding.userId,
                binding.zipCode,
                binding.year
            )
            EditTextValidator.clearSpinners(binding.spin)
        }

        val adapter =
            ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                arrayOf("<Please select one>", "uz", "en", "ru")
            )
        binding.spin.adapter = adapter

        binding.submitBtn.setOnClickListener {
            EditTextValidator.isSpinnerSelectedItem(binding.spin)
            EditTextValidator.isEmailAddressValid(binding.emailAddress)
            EditTextValidator.isEmpty(binding.firstName)
            EditTextValidator.isIPAddressValid(binding.ipAdress)
            EditTextValidator.isEmpty(binding.lastName)
            EditTextValidator.isEmpty(binding.password)
            EditTextValidator.isMatchReEnteredPassword(binding.password, binding.reEnterPass)
            EditTextValidator.isTelNumberValid(binding.telNum)
            EditTextValidator.isUserIdValid(binding.userId)
            EditTextValidator.isZipCodeValid(binding.zipCode)
            EditTextValidator.isYearValidValid(binding.year)
        }
    }
}