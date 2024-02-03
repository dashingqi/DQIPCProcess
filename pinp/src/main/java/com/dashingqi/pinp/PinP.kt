package com.dashingqi.pinp

import android.app.Activity
import android.app.PictureInPictureParams
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build


/**
 * 是否能够进入画中画模式
 * @param context Context 上下文
 * @return Boolean true/false 是/否
 */
fun canEnterPipMode(context: Context): Boolean {
    val isOverN = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
    val hasSystemFeature = context.packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)
    return isOverN && hasSystemFeature
}

/**
 * 进入画中画模式
 * @param activity Activity activity
 * @param pinParamsBuilder Function1<Builder, Builder> pinParamsBuilder参数构造
 */
fun enterPipMode(
    activity: Activity, pinParamsBuilder: (PictureInPictureParams.Builder) -> PictureInPictureParams.Builder
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val pipBuilder = PictureInPictureParams.Builder()
        activity.enterPictureInPictureMode(pinParamsBuilder.invoke(pipBuilder).build())
    } else {
        activity.enterPictureInPictureMode()
    }
}

