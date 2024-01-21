package com.dashingqi.threads.executor.queue

import com.dashingqi.threads.executor.config.SMART_QUEUE_NUM
import com.dashingqi.threads.executor.task.TaskInfo
import com.dashingqi.threads.executor.task.TaskPriority

/**
 * @desc : 队列管理类
 * @author : zhangqi
 * @time : 2024/1/21 10:19
 */
object QueueMgr {

    /** 优先级队列、高优先级在前*/
    private val mQueues: Array<SmartQueue> = arrayOf()

    init {
        initQueue()
    }

    /**
     *  初始化队列
     */
    private fun initQueue() {
        for (index in 0 until SMART_QUEUE_NUM) {
            mQueues[index] = SmartQueue()
        }
    }

    /**
     * 插入任务到队列中
     * @param taskInfo TaskInfo 任务信息
     */
    internal fun insertTask(taskInfo: TaskInfo) {
        getQueue(taskInfo.priority)

    }

    /**
     * 获取队列【根据任务优先级匹配到存储任务的队列】
     * @param priority Int 任务优先级
     */
    private fun getQueue(@TaskPriority priority: Int): SmartQueue {
        return SmartQueue()
    }

}