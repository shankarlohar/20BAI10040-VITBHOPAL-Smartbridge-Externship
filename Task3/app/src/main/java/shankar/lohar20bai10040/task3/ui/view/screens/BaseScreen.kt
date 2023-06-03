package shankar.lohar20bai10040.task3.ui.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BaseScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var topText by remember{ mutableStateOf("None") }
        Text(text = "Pressed button is: $topText", fontSize = 16.sp, color = Color.Blue)
        Spacer(modifier = modifier.padding(8.dp))
        Button(onClick = { topText = "One" }) {
            Text(text = "One")
        }
        Spacer(modifier = modifier.padding(8.dp))
        Button(onClick = { topText = "Two" }) {
            Text(text = "Two")
        }
    }
}