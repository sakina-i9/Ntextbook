package com.websarva.wings.android.ntextbook

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.websarva.wings.android.ntextbook.databinding.OmikujiBinding
import kotlin.random.Random

class OmikujiActivity : AppCompatActivity() {
    lateinit var binding: OmikujiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OmikujiBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        //文字表示
        /*val rnd = Random
        val number = rnd.nextInt(20)
        val omikujiShelf = Array(20){"吉"}

        omikujiShelf[0] = "大吉"
        omikujiShelf[19]="凶"

        val str = omikujiShelf[number]

        if(number == 0){
            str = "吉"
        }else if(number == 1){
            str = "凶"
        }

        var str = when (number) {
            0 -> "吉"
            1 -> "凶"
            else -> "大吉"
        }

        binding.helloView.text = str
        */


    }

    fun onButtonClick(v:View){
        val translate = TranslateAnimation(0f,0f,0f,-200f)
        translate.repeatMode = Animation.REVERSE
        translate.repeatCount = 5
        translate.duration = 100
        binding.imageView.startAnimation(translate)

        //binding.imageView.setImageResource(R.drawable.daikiti)
    }
}