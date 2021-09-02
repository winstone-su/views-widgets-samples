package com.example.cardview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @ClassName CardViewActivity
 * @Description TODO
 * @Author Carl
 * @Date 2021/9/2  上午
 * @Version 1.0
 */

class CardViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.container, CardViewFragment())
                .commit()
        }

    }
}