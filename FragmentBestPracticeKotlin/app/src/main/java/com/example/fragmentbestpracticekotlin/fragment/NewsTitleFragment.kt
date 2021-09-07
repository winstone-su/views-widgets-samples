package com.example.fragmentbestpracticekotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentbestpracticekotlin.NewsContentActivity
import com.example.fragmentbestpracticekotlin.R
import com.example.fragmentbestpracticekotlin.base.BaseFragment
import com.example.fragmentbestpracticekotlin.databinding.FragmentNewsTitleBinding
import com.example.fragmentbestpracticekotlin.entity.News
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class NewsTitleFragment : BaseFragment<FragmentNewsTitleBinding>(FragmentNewsTitleBinding::inflate) {
    private var isTowPane = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        isTowPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
        val layoutManager = LinearLayoutManager(activity)
        val adapter = NewsAdapter(getNews())
        binding.apply {
            newsTitleRecyclerView.layoutManager = layoutManager
            newsTitleRecyclerView.adapter = adapter
        }

    }

    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        for (i in 1..50) {
            val news = News("This is news title $i", getRandomLengthString("This is news content $i. "))
            newsList.add(news)
        }
        return newsList
    }

    private fun getRandomLengthString(str: String): String {
        val n = Random().nextInt(20) + 1
        val stringBuilder = StringBuilder()
        repeat(n){
            stringBuilder.append(str)
        }
        return stringBuilder.toString()
    }

    inner class NewsAdapter(private val newsList: List<News>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val newsTitle : TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
           val view = LayoutInflater.from(parent.context)
               .inflate(R.layout.item_news_title,parent,false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener{
                val news = newsList[holder.adapterPosition]
                if (isTowPane){
                    val fragment = activity?.supportFragmentManager?.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
                    fragment.refresh(news.title,content = news.content )
                }else{
                    NewsContentActivity.actionStart(parent.context,news.title,news.content)
                }
            }
            return  holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }

        override fun getItemCount(): Int {
            return  newsList.size
        }
    }
}