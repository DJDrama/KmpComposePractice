package com.dj.kmpcomposepractice

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // test
        var isChecking = true
        lifecycleScope.launch {
            delay(3000L)
            isChecking = false
        }
        installSplashScreen().apply {
            /*setKeepOnScreenCondition{
                viewModel.isCheckingSession
            }*/
            setKeepOnScreenCondition {
                isChecking
            }
        }
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}