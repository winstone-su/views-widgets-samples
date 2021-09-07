package com.example.uipractice

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @ClassName MsgViewHolder
 * @Description TODO
 * @Author Carl
 * @Date 2021/9/7 2:26 下午
 * @Version 1.0
 */
sealed class MsgViewHolder(view: View): RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View) : MsgViewHolder(view) {
    val leftMsg: TextView = view.findViewById(R.id.leftMsg)
}

class RightViewHolder(view: View) : MsgViewHolder(view) {
    val rightMsg: TextView = view.findViewById(R.id.rightMsg)
}