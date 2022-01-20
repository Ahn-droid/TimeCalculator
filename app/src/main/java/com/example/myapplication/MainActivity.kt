package com.example.myapplication

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private var mainBtn : Button? = null;
    private lateinit var offSft : ImageView
    private lateinit var onSft : ImageView
    private lateinit var flip1: Animation
    private lateinit var flip2: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainBtn = findViewById(R.id.button) as Button
        mainBtn!!.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                offSft.startAnimation(flip1)
                onSft.startAnimation(flip2)
            }
        })

    }
}