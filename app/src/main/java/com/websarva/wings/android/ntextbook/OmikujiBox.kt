package com.websarva.wings.android.ntextbook

import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import kotlin.random.Random

class OmikujiBox : Animation.AnimationListener {
    lateinit var  omikujiView: ImageView
    var finish = false
    val number : Int
        get(){
            val rnd = Random
            return rnd.nextInt(20)
        }

    fun shake(){
        val translate = TranslateAnimation(0f,0f,0f,-200f)
        translate.repeatMode = Animation.REVERSE
        translate.repeatCount = 5
        translate.duration = 100

        val rotate = RotateAnimation(0f,36f,omikujiView.width/2f,omikujiView.height/2f)
        rotate.duration = 200

        val set = AnimationSet(true)
        set.addAnimation(rotate)
        set.addAnimation(translate)

        set.setAnimationListener(this)

        omikujiView.startAnimation(set)
    }

    override fun onAnimationStart(animation: Animation?) {
    }

    override fun onAnimationEnd(animation: Animation?) {
        omikujiView.setImageResource(R.drawable.omikuji2)
        finish = true
    }

    override fun onAnimationRepeat(animation: Animation?) {
    }
}