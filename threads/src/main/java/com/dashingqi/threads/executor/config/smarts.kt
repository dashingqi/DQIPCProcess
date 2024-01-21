package com.dashingqi.threads.executor.config

import com.dashingqi.threads.executor.task.TaskPriority

/** smart-线程池中任务优先级*/
internal const val TASK_PRIORITY_SMART = 4

/** smart队列优先级映射表*/
internal val SMART_QUEUE_PRIORITY_TABLE: IntArray = intArrayOf(
    TaskPriority.TASK_PRIORITY_IMMEDIATE,
    TaskPriority.TASK_PRIORITY_USER_UI,
    TaskPriority.TASK_PRIORITY_IN_TIME,
    TaskPriority.TASK_PRIORITY_BACKGROUND

)

/** smart queue 队列的个数*/
internal val SMART_QUEUE_NUM = SMART_QUEUE_PRIORITY_TABLE.size