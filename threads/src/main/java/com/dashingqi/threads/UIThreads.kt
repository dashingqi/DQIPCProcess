package com.dashingqi.threads

import android.os.Handler
import android.os.Looper

/**
 * @desc : 主线程工作类
 * @author : zhangqi
 * @time : 2023/12/23 18:54
 */
object UIThreads {
    /**
     * Main Handler
     */
    private val mainHandler by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Handler(Looper.getMainLooper())
    }

    /**
     * 是否是在主线程
     */
    private val isOnUIThread: Boolean
        get() = Looper.getMainLooper().thread == Thread.currentThread()

    /**
     * 在主线程执行任务
     * @param task 执行的任务
     */
    @JvmStatic
    fun runOnUiThread(task: Runnable) {
        if (isOnUIThread) {
            task.run()
        } else {
            mainHandler.post(task)
        }
    }

    /**
     * 在主线程执行任务
     * @param task 任务
     * @param delayMillis 延迟【millis】任务执行
     */
    @JvmStatic
    fun runOnUiThread(task: Runnable, delayMillis: Long) {
        if (delayMillis > 0L) {
            mainHandler.postDelayed(task, delayMillis)
        } else {
            runOnUiThread(task)
        }
    }
}