package com.example.uipractice

/**
 * @ClassName Msg
 * @Description TODO
 * @Author Carl
 * @Date 2021/9/7 11:36 上午
 * @Version 1.0
 */
class Msg(val content: String,val type: Int) {
    companion object{
        const val TYPE_RECEIVED = 0
        const val TYPE_SENT = 1
    }
}