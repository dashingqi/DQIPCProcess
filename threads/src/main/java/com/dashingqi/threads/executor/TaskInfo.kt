package com.dashingqi.threads.executor

/**
 * @desc : 任务信息数据类
 * @author : zhangqi
 * @time : 2024/1/20 12:22
 */
data class TaskInfo(val task: Runnable, val taskName: String, val priority: Int)
