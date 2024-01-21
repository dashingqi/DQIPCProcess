package com.dashingqi.threads.executor.scheduler

import android.os.Handler
import android.os.Looper
import android.os.Message
import com.dashingqi.threads.executor.task.TaskInfo
import com.dashingqi.threads.executor.constant.MSG_INSERT_TASK
import com.dashingqi.threads.executor.queue.QueueMgr

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
                if (msg.obj is TaskInfo) {
                    // 插入消息进队列
                    val taskInfo = msg.obj as TaskInfo
                    QueueMgr.insertTask(taskInfo)
                }

            }
        }
    }
}