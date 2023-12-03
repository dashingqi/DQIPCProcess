package com.dashingqi.ipcprocess.process.ipc

import android.content.Context

/**
 * @desc :
 * @author : zhangqi
 * @time : 2023/12/3 22:06
 */

internal class ContextProvider : SimpleContentProvider(){

    override fun onCreate(): Boolean {
        init(context!!)
        return true
    }

    // 其他方法直接 return
}
// Context.kt
private lateinit var application : Context

fun init(context : Context){
    application= context
}

fun context() : Context{
    return application
}