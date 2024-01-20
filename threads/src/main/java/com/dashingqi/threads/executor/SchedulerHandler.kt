package com.dashingqi.threads.executor

import android.os.Handler
import android.os.Looper
import android.os.Message

/**
 * @desc : 任务调度 Handler
 * @author : zhangqi
 * @time : 2024/1/20 12:28
 */
class SchedulerHandler(looper: Looper = Looper.getMainLooper()) : Handler(looper) {
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        when (msg.what) {
            MSG_INSERT_TASK -> {

            }
        }
    }
}