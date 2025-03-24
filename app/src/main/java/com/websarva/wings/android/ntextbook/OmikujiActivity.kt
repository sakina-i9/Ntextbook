package com.websarva.wings.android.ntextbook

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.websarva.wings.android.ntextbook.databinding.FortuneBinding
import com.websarva.wings.android.ntextbook.databinding.OmikujiBinding

class OmikujiActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /*
        val toast = Toast.makeText(this, item.title, Toast.LENGTH_LONG)
        toast.show()
        */

        if(item.itemId == R.id.item1){
            val intent = Intent(this, OmikujiPreferenceActivity::class.java)
            startActivity(intent)
        }else{
            val intent = Intent(this,AboutActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

    val omikujiShelf = Array(20){
        OmikujiParts(R.drawable.kiti,R.string.contents1)
    }
    var omikujiNumber = -1
    val omikujiBox = OmikujiBox()
    lateinit var binding: OmikujiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OmikujiBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val value = pref.getBoolean("button", false)
        binding.button.visibility = if(value)View.VISIBLE else View.INVISIBLE

        omikujiBox.omikujiView = binding.imageView

        omikujiShelf[0].drawID = R.drawable.daikiti
        omikujiShelf[0].fortuneID = R.string.contents2
        omikujiShelf[1].drawID = R.drawable.kyou
        omikujiShelf[1].fortuneID = R.string.contents9
        omikujiShelf[2].fortuneID = R.string.contents3
        omikujiShelf[3].fortuneID = R.string.contents4
        omikujiShelf[4].fortuneID = R.string.contents5
        omikujiShelf[5].fortuneID = R.string.contents6

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
        omikujiBox.shake()
/*
        val translate = TranslateAnimation(0f,0f,0f,-200f)
        translate.repeatMode = Animation.REVERSE
        translate.repeatCount = 5
        translate.duration = 100

        val rotate = RotateAnimation(0f,36f,binding.imageView.width/2f,binding.imageView.height/2f)
        rotate.duration = 200

        val set = AnimationSet(true)
        set.addAnimation(rotate)
        set.addAnimation(translate)

        binding.imageView.startAnimation(set)

        //binding.imageView.setImageResource(R.drawable.daikiti)

 */
    }

    fun drawResult(){
        omikujiNumber = omikujiBox.number

        val op = omikujiShelf[omikujiNumber]

        val fortuneBinding = FortuneBinding.inflate(layoutInflater)
        setContentView(fortuneBinding.root)

        fortuneBinding.imageView2.setImageResource(op.drawID)
        fortuneBinding.textView.setText(op.fortuneID)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_DOWN){
            if(omikujiNumber < 0 && omikujiBox.finish){
                drawResult()
            }
        }
        return super.onTouchEvent(event)
    }
}

