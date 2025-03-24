package com.websarva.wings.android.ntextbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.websarva.wings.android.ntextbook.databinding.AboutBinding

class AboutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val aboutBinding = AboutBinding.inflate(layoutInflater)
        setContentView(aboutBinding.root)

        val info = packageManager.getPackageInfo(packageName, 0)
        aboutBinding.imageView3.setImageResource(R.drawable.logo)
        aboutBinding.textView2.text = "Version " + info.versionName
    }
}