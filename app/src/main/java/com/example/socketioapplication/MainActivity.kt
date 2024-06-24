package com.example.socketioapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.socketioapplication.SocketHandler.mSocket
import com.example.socketioapplication.ui.theme.SocketIOApplicationTheme

class MainActivity : ComponentActivity() {
    private val socketManager = SocketManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocketIOApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context=this

                    Greeting("Amene jooon")
                    socketManager.connect()
                    socketManager.sendRequest()
                    socketManager.onVersionJSONReceived { videos ->
                        Log.i("received message","this is $videos")
                        val userVersion=videos
//                        Toast.makeText(context," this is version code : $version",Toast.LENGTH_LONG).show()
                        // Handle received message
                    }
                }
            }
            DisposableEffect(key1 = null) {

                onDispose {
                    socketManager.disconnect()

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
        Button(onClick = { },
            modifier=Modifier.fillMaxWidth()) {
            Text(
                text = "Click me!",
                modifier = modifier
            )
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SocketIOApplicationTheme {
        Greeting("Android")
    }
}