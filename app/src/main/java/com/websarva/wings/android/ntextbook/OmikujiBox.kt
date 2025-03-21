package com.websarva.wings.android.ntextbook

import kotlin.random.Random

class OmikujiBox {
    val number : Int
        get(){
            val rnd = Random
            return rnd.nextInt(20)
        }
}