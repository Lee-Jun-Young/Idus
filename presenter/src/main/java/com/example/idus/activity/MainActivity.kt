package com.example.idus.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idus.MyApplication
import com.example.idus.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}