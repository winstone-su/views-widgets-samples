package com.example.fragmentbestpracticekotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragmentbestpracticekotlin.base.BaseActivity
import com.example.fragmentbestpracticekotlin.base.BaseFragment
import com.example.fragmentbestpracticekotlin.databinding.ActivityNewsContentBinding
import com.example.fragmentbestpracticekotlin.fragment.NewsContentFragment

class NewsContentActivity : BaseActivity<ActivityNewsContentBinding>(ActivityNewsContentBinding::inflate) {

    companion object{
        fun actionStart(context: Context,title: String,content: String){
            val intent = Intent(context,NewsContentActivity::class.java).apply {
                putExtra("news_title",title)
                putExtra("news_content",content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")

        if (title != null && content != null){
            val newsContentFragment = supportFragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
            newsContentFragment.refresh(title,content)
        }

    }
}