package com.example.fragmentbestpracticekotlin.base

import android.app.Activity

/**
 * @ClassName ActivityCollector
 * @Description TODO
 * @Author Carl
 * @Date 2021/9/7 4:14 下午
 * @Version 1.0
 */
object ActivityCollector {
    private  var activities =  ArrayList<Activity>()

    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    fun finishAll(){
        for (activity in activities){
            if (!activity.isFinishing){
                activity.finish()
            }
        }
        activities.clear()
        android.os.Process.killProcess(android.os.Process.myPid())
    }
}