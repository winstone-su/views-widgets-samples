package com.example.fragmentbestpracticekotlin.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * @ClassName BaseActivity
 * @Description Activity基类
 * @Author Carl
 * @Date 2021/9/7 4:11 下午
 * @Version 1.0
 */
abstract class BaseActivity<VB : ViewBinding>(private val inflate: (LayoutInflater) -> VB) :
    AppCompatActivity() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }
}