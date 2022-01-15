package com.example.phonesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phonesapp.Object.Object
import com.example.phonesapp.Object.ObjectPhone
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        tv_phone_Name.text = ObjectPhone.stringName
        tv_phoneFeatures.text = ObjectPhone.stringFeatures
    }
}