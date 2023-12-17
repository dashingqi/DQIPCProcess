package com.dashingqi.ipcprocess.process.ipc

import android.net.Uri
/**
 * @desc : 主进程代理的 Provider
 * @author : zhangqi
 * @time : 2023/12/3 11:22
 */

internal val PROVIDER_URI: Uri =
    Uri.parse("content://com.dashingqi.dqipcprocess.IpcMainDelegateProvider")

class IpcMainProcessDelegateProvider : IpcDelegateProvider()