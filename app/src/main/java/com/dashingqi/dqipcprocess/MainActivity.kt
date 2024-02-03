package com.dashingqi.dqipcprocess

import android.app.Activity
import android.app.RemoteAction
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Rational
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.dashingqi.dqipcprocess.ui.theme.DQIPCProcessTheme
import com.dashingqi.ipcprocess.process.test.OtherProcessService
import com.dashingqi.pinp.canEnterPipMode
import com.dashingqi.pinp.enterPipMode

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DQIPCProcessTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode)
        if (isInPictureInPictureMode){
            Log.d(TAG, "进入画中画模式")
        }else {
            Log.d(TAG, "退出画中画模式")
        }
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        enterPinPMode(this)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    TextButton(onClick = {

    }) {
        Text(text = "测试画中画模式")
    }
}

private fun startOtherProcessService(context: Context) {
    context.startService(Intent(context, OtherProcessService::class.java))
}

private fun enterPinPMode(activity: Activity){
    if (canEnterPipMode(activity)){
        enterPipMode(activity){
            it.setAspectRatio(Rational(16,9))
            return@enterPipMode it
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DQIPCProcessTheme {
        Greeting("Android")
    }
}