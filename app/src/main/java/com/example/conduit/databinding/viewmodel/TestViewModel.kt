package com.example.conduit.databinding.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class TestViewModel : ViewModel() {
    var textData = MutableLiveData<String>()
    var btnText = MutableLiveData<String>()
    var etTextInput = MutableLiveData<String>()
    var etTextInputLayout = MutableLiveData<String>()
    var imageUrl = MutableLiveData<String>()
    var errorMsg = MutableLiveData<String>()



    fun handleClick(view: View) {
        textData.value = "Success"
        btnText.value = "Done"
    }

    /*   var emailTextWatcher: TextWatcher = object : TextWatcher {
           override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               TODO("Not yet implemented")
           }

           override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               TODO("Not yet implemented")
           }

           override fun afterTextChanged(p0: Editable?) {
               TODO("Not yet implemented")
               Log.e("cfghjkl", "afterTextChanged: " + p0.toString())
           }

       }*/
    fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches();
    }
}