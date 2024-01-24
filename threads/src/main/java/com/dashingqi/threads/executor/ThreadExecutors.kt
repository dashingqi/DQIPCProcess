package com.dashingqi.threads.executor

import com.dashingqi.threads.executor.scheduler.TaskSchedulerMgr
import com.dashingqi.threads.executor.task.TaskPriority

/**
 * @desc : 线程调度器
 * @author : zhangqi
 * @time : 2024/1/6 08:40
 */
object ThreadExecutors {

    /**
     * 提交任务到智能执行器中
     * @param task Runnable 任务
     * @param taskName String 任务名称
     * @param priority Int 任务优先级
     * @param delay Long 延迟时间
     */
    @JvmStatic
    fun postOnSmartExe(
        task: Runnable, taskName: String, @TaskPriority priority: Int, delay: Long = 0L
    ) {
        TaskSchedulerMgr.postTask(task, taskName, priority, delay)
    }

    /**
     * 提交任务到单执行器中
     * @param task Runnable 任务
     * @param taskName String 任务名称
     * @param delay Long 延迟时间
     */
    @JvmStatic
    fun postOnSingleExe(task: Runnable, taskName: String, delay: Long = 0L) {

    }
}
