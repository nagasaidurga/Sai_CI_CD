package com.example.sai_ci_cd_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sai_ci_cd_app.ui.theme.Sai_CI_CD_appTheme
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCenter.start(
            application, "3a3a062e-be87-41e8-b3f5-2ec722bc9788",
            Analytics::class.java, Crashes::class.java
        )
        setContent {
            Sai_CI_CD_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {

        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        TextField(value = "Username", onValueChange ={} )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            Crashes.generateTestCrash()
        }) {
            Text("Click me")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Sai_CI_CD_appTheme {
        Greeting("Android")
    }
}