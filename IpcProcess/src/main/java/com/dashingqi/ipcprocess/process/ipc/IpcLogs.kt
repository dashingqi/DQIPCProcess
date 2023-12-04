package com.dashingqi.ipcprocess.process.ipc

import android.util.Log
import com.dashingqi.ipcprocess.BuildConfig


const val IPC_TAG = "IcpDelegateTag"

/** debug 开关*/
internal const val DEBUG = BuildConfig.IpcDebug

/**
 * 打印字符串 Debug等级
 * @receiver String?
 */
fun String?.logD() {
    if (DEBUG) {
        Log.d(IPC_TAG, this ?: "this is error")
    }
}

/**
 * 打印Throwable错误信息
 * @receiver Throwable
 */
fun Throwable.printStack() {
    if (DEBUG) {
        this.printStackTrace()
    }
}
