package com.dashingqi.threads.executor.scheduler

import android.os.Message
import com.dashingqi.threads.executor.task.TaskInfo
import com.dashingqi.threads.executor.constant.MSG_INSERT_TASK

/**
 * @desc : 任务调度器管理者
 * @author : zhangqi
 * @time : 2024/1/20 12:18
 */
object TaskSchedulerMgr {

    /** 调度器的 Handler*/
    private val mSchedulerHandler by lazy {
        SchedulerHandler()
    }

    /**
     * 提交任务
     */
    fun postTask(task: Runnable, taskName: String, priority: Int, delay: Long) {
        val msg = Message.obtain()
        msg.obj = TaskInfo(task, taskName, priority)
        msg.what = MSG_INSERT_TASK
        mSchedulerHandler.sendMessageDelayed(msg, delay)
    }
}