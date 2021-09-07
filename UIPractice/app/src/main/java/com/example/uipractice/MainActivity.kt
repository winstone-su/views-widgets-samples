package com.example.uipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uipractice.R.id.button
import com.example.uipractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val msgList = ArrayList<Msg>()
    private lateinit var adapter: MessageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMsg()

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.chatView.layoutManager = layoutManager
        if (!::adapter.isInitialized){
            adapter = MessageAdapter(msgList)
        }
        binding.chatView.adapter = adapter
        binding.button.setOnClickListener(this)
    }

    private fun initMsg(){
        val msg1 = Msg("Hello Guy.",Msg.TYPE_SENT)
        val msg2 = Msg("Hello,Who is that?",Msg.TYPE_RECEIVED)
        val msg3 = Msg("This is Tom. Nice talking to you",Msg.TYPE_SENT)
        msgList.add(msg1)
        msgList.add(msg2)
        msgList.add(msg3)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            button ->{
                val content = binding.editText.text.toString()
                if (content.isNotEmpty()){
                    val msg = Msg(content,Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter.notifyItemChanged(msgList.size -1)
                    binding.chatView.scrollToPosition(msgList.size -1)
                    binding.editText.setText("")
                }
            }
        }
    }
}