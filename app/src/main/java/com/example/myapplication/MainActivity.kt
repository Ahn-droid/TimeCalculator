package com.example.myapplication

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var onoff = 0
    private var startTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calbtn.setOnClickListener {
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{

            if (onoff == 0){
                startShift()
            }
            else if (onoff == 1){
                endShift()
            }
        }
    }

    private fun startShift(){
        Calendar time = Calendar.getInstance()
        flipf(fsb)
        flipn(nsb)
        onoff = 1
        startTime = time
    }

    private fun endShift(){
        flipf(nsb)
        flipn(fsb)
        onoff = 0
    }


    private fun flipf(view: View) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, scaleX)
        animator.duration = 500
        animator.buttonDisable(button)
        animator.start()
    }
    private fun flipn(view: View) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, scaleX)
        animator.startDelay = 500
        animator.duration = 500
        animator.buttonDisable(button)
        animator.start()
    }

    private fun ObjectAnimator.buttonDisable(view: View) {
        addListener(object: AnimatorListenerAdapter(){
            override fun onAnimationStart(animation: Animator?, isReverse: Boolean) {
                view.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?, isReverse: Boolean) {
                view.isEnabled = true
            }
        })
    }
}