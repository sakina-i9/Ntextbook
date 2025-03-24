package com.websarva.wings.android.ntextbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OmikujiPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentTranceaction = supportFragmentManager.beginTransaction()
        fragmentTranceaction.replace(android.R.id.content,OmikujiPreferenceFragment())
        fragmentTranceaction.commit()
    }
}