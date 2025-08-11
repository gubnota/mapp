package com.mapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mapp.ui.theme.MappTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val names:List<String> = listOf(
			"Harold","Darren","Jean","François","Eloise","Kean","Patrick","Teo","Yan","Alice","Tiago")
        val colors: List<Color> = listOf(Color(0xFF9C27B0),Color(0xFF2196F3),
            Color(0xFF4CAF50),Color(0xFF00BCD4),Color(0xFFFFC107)
        )
		val randomName = mutableStateOf(names.random())
        fun onClick() = {
            randomName.value = names.random()
        }
		enableEdgeToEdge()
		setContent {
			MappTheme {
				Greeting(randomName,names.random(),names.random(), bg = colors.random(),onClick= onClick())
			}
		}
	}
}

@Composable
fun Greeting(name1: MutableState<String> = mutableStateOf("Android"), name2: String = "Android", name3: String = "Android", bg:Color = Color(0x0ff0ffff), onClick:()->Unit={ println("Hello") }) {
	Scaffold(modifier = Modifier.fillMaxHeight().clickable(onClick=onClick), contentColor = Color(0xff000000), containerColor = bg) { innerPadding ->

		Column(modifier = Modifier.fillMaxHeight()
			.padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Center,
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.padding(innerPadding)
				, horizontalArrangement = Arrangement.SpaceBetween){
				Text(name1.value, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp))
                Text(text = name2, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp))
				Text(name3, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp))
			}
		}

	}
}

@Preview(name = "Small Screen", widthDp = 390, heightDp = 844)
@Composable
fun GreetingPreview() {
	MappTheme {
		val names:List<String> = listOf(
            "Harold","Darren","Jean","François","Eloise","Kean","Patrick","Teo","Yan","Alice","Tiago")
		val colors: List<Color> = listOf(Color(0xFF9C27B0),Color(0xFF2196F3),
            Color(0xFF4CAF50),Color(0xFF00BCD4),Color(0xFFFFC107)
        )
		val randomName = names.random()
		Greeting(mutableStateOf(randomName),names.random(),names.random(), bg = colors.random())
	}
}