package com.hamroyevazizjon.edittextvalidator

import android.graphics.Color
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.util.regex.Pattern

object EditTextValidator {

    fun isUserIdValid(editText: EditText) {
        if (editText.text.toString().contains(' ') || editText.text.isEmpty()) {
            editText.error = "It is not valid username. Valid username must not contain any space!"
        }
    }

    fun isEmailAddressValid(editText: EditText) {
        val regex = "^(.+)@(.+)$"
        val pattern = Pattern.compile(regex)
        if (!pattern.matcher(editText.text.toString()).matches()) {
            editText.error = "It is not valid email address!\nExample: abcde@gmail.com"
        }
    }

    fun isMatchReEnteredPassword(editText1: EditText, editText2: EditText) {
        if (editText1.text.toString() != editText2.text.toString())
            editText2.error = "Please re-enter password"
    }

    fun isEmpty(editText: EditText) {
        if (editText.text.isEmpty()) editText.error = "Please fill the field";
    }

    fun isSpinnerSelectedItem(spinner: Spinner) {
        if (spinner.selectedItemPosition == 0) {
            val errorText = spinner.selectedView as TextView
            errorText.error = ""
            errorText.setTextColor(Color.RED) //just to highlight that this is an error
            errorText.text = "<Please select one>" //changes the selected item text to this

        }
    }

    fun isIPAddressValid(editText: EditText) {
        val pattern =
            Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!\$)|\$)){4}\$")
        if (!pattern.matcher(editText.text.toString()).matches()) {
            editText.error = "It is not valid ip address\nExample: 192.168.0.1"
        }
    }

    fun isTelNumberValid(editText: EditText) {
        val pattern = Pattern.compile("^\\d{9}$")
        if (!pattern.matcher(editText.text.toString()).matches()) {
            editText.error = "it not valid telephone number\nExample: 936882200"
        }
    }

    fun isZipCodeValid(editText: EditText) {
        val pattern = Pattern.compile("^\\d{6}$")
        if (!pattern.matcher(editText.text.toString()).matches()) {
            editText.error = "It is not valid  zip code\nExample: 110111"
        }
    }

    fun isYearValidValid(editText: EditText) {
        if (editText.text.isEmpty() || !(editText.text.toString()
                .toInt() in 1900..2022)
        ) {
            editText.error = "It is not valid year. Year must be in [1900,2022] range"
        }
    }

    fun clearEditTexts(vararg editTexts: EditText) {
        for (et in editTexts) {
            et.text.clear()
            et.error = null
        }
    }

    fun clearSpinners(vararg spinners: Spinner) {
        for (spinner in spinners) {
            val errorText = spinner.selectedView as TextView
            errorText.error = null
            errorText.setTextColor(Color.BLACK)
        }
    }

}