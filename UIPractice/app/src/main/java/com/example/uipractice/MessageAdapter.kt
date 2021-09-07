package com.example.uipractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @ClassName MessageAdapter
 * @Description TODO
 * @Author Carl
 * @Date 2021/9/7 11:36 上午
 * @Version 1.0
 */
class MessageAdapter(private val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder =
        if (viewType == Msg.TYPE_RECEIVED) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left, parent, false)
            LeftViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_right, parent, false)
            RightViewHolder(view)
        }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }

    override fun getItemCount(): Int {
        return msgList.size
    }


}