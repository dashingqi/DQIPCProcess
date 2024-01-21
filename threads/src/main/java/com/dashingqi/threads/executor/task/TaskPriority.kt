package com.dashingqi.threads.executor.task

import androidx.annotation.IntDef

/**
 * @desc : 任务优先级
 * @author : zhangqi
 * @time : 2024/1/21 11:43
 */
@IntDef(
    TaskPriority.TASK_PRIORITY_IMMEDIATE,
    TaskPriority.TASK_PRIORITY_USER_UI,
    TaskPriority.TASK_PRIORITY_IN_TIME,
    TaskPriority.TASK_PRIORITY_BACKGROUND
)
annotation class TaskPriority {
    companion object {
        /** 顶优先级*/
        internal const val TASK_PRIORITY_IMMEDIATE = 0

        /** 第一优先级：异步数据请求、数据返回后立即更新 UI*/
        internal const val TASK_PRIORITY_USER_UI = 1

        /** 第二优先级：策略网络请求、非UI相关数据操作*/
        internal const val TASK_PRIORITY_IN_TIME = 2

        /** 第三优先级：实时性不高，比如后台上报、下载*/
        internal const val TASK_PRIORITY_BACKGROUND = 3
    }
}
