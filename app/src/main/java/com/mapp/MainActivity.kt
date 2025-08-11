package com.mapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mapp.ui.theme.MappTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		val names:List<String> = listOf(
			"Harold","Darren","Jean","François","Eloise","Kean","Patrick","Teo","Yan","Alice","Tiago")
		val colors: List<Color> = listOf(Color(0x02394f8ff),Color(0xff0f82394),Color(0xff023f894),Color(0xfff9d83d),Color(0xfff839dd))
		val randomName = names.random()

		enableEdgeToEdge()
		setContent {
			MappTheme {
				Greeting(randomName,names.random(),names.random(), bg = colors.random())
			}
		}
	}
}

@Composable
fun Greeting(name1: String = "Android",name2: String = "Android",name3: String = "Android",bg:Color = Color(0x0ff0ffff), innerPadding: PaddingValues= PaddingValues(32.dp)) {
	Scaffold(modifier = Modifier.fillMaxHeight(), contentColor = Color(0xff000000), containerColor = bg) { innerPadding ->

		Column(modifier = Modifier.fillMaxHeight()
			.padding(horizontal = 32.dp)//innerPadding.calculateLeftPadding(LayoutDirection.Ltr)
//			.background(bg)
			, verticalArrangement = Arrangement.Center

		) {
			Row(
				modifier = Modifier
//									//.fillMaxHeight()
					.fillMaxWidth()
					.padding(innerPadding)
				, horizontalArrangement = Arrangement.SpaceBetween){
				Text(name1, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp))
				Text(text = name2, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp))
				Text(name3, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp))
			}
		}

	}
}

@Preview(name = "Small Screen", widthDp = 390, heightDp = 844)
//@Preview(name = "Default")
@Composable
fun GreetingPreview() {
	MappTheme {
		val names:List<String> = listOf(
            "Harold","Darren","Jean","François","Eloise","Kean","Patrick","Teo","Yan","Alice","Tiago")
		val colors: List<Color> = listOf(Color(0x02394f8ff),Color(0xff0f82394),Color(0xff023f894),Color(0xfff9d83d),Color(0xfff839dd))
		val randomName = names.random()
		Greeting(randomName,names.random(),names.random(), bg = colors.random())
	}
}