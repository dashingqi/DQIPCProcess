package com.dashingqi.threads.executor

/**
 * @desc : 线程调度器
 * @author : zhangqi
 * @time : 2024/1/6 08:40
 */
object ThreadExecutors {

    /**
     * 提交任务到调度器中
     */
    @JvmStatic
    fun postOnExecutors(runnable: Runnable, taskName: String, delay: Long = 0L) {


    }

    /**
     * 提交任务到单个调度器中
     */
    @JvmStatic
    fun postOnSingleExecutor(runnable: Runnable, taskName: String, delay: Long = 0L) {

    }
}