package com.dashingqi.threads.executor.task

/**
 * @desc : 任务信息数据类
 * @author : zhangqi
 * @time : 2024/1/20 12:22
 */
data class TaskInfo(
    /** 任务*/
    val task: Runnable,
    /** 任务名称*/
    val taskName: String,
    /** 任务优先级*/
    @TaskPriority val priority: Int
)
