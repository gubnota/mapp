
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mapp.ReactiveViewModel
import com.mapp.ui.theme.MappTheme

@Composable
fun ReactiveView(viewModel: ReactiveViewModel) {
    val ui by viewModel.state.collectAsState()

    Scaffold(modifier = Modifier.fillMaxHeight().clickable(onClick= { viewModel.onClick() }), contentColor = Color(0xff000000), containerColor = ui.color) { innerPadding ->
        Column(modifier = Modifier.fillMaxHeight()
            .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                , horizontalArrangement = Arrangement.SpaceBetween){
                Text(ui.name1, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp))
                Text(text = ui.name2, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp))
                Text(ui.name3, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp))
            }
        }

    }
}

@Preview(name = "Small Screen", widthDp = 390, heightDp = 844)
@Composable
fun ReactiveViewPreview() {
    MappTheme {
        val viewModel = ReactiveViewModel()
        ReactiveView(viewModel)
    }
}