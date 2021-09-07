package com.example.fragmentbestpracticekotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentbestpracticekotlin.base.BaseFragment
import com.example.fragmentbestpracticekotlin.databinding.FragNewsContentBinding

class NewsContentFragment: BaseFragment<FragNewsContentBinding>(FragNewsContentBinding::inflate) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun refresh(title: String,content: String){
        binding.apply {
            contentLayout.visibility = View.VISIBLE
            newsTitle.text = title  //refresh news title
            newsContent.text = content  //refresh news content
        }
    }

}