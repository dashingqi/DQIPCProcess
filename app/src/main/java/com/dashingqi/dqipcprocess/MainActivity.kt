package com.dashingqi.dqipcprocess

import android.content.Context
import android.content.Intent
import android.os.Bundle
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
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    TextButton(onClick = {
        startOtherProcessService(context)
    }) {
        Text(text = "测试垮进程")
    }
}

private fun startOtherProcessService(context: Context) {
    context.startService(Intent(context, OtherProcessService::class.java))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DQIPCProcessTheme {
        Greeting("Android")
    }
}