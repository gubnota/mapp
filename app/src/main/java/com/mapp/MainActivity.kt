package com.mapp

import ReactiveView
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mapp.ui.theme.MappTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
        val viewModel = ReactiveViewModel()
		enableEdgeToEdge()
		setContent {
			MappTheme {
                ReactiveView(viewModel)
			}
		}
	}
}

@Preview(name = "Small Screen", widthDp = 390, heightDp = 844)
@Composable
fun GreetingPreview() {
    val viewModel = ReactiveViewModel()
	MappTheme {
        ReactiveView(viewModel)
	}
}