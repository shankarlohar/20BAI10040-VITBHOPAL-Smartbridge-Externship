package shankar.lohar20bai10040.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import shankar.lohar20bai10040.task2.util.add
import shankar.lohar20bai10040.task2.util.div
import shankar.lohar20bai10040.task2.util.mul
import shankar.lohar20bai10040.task2.util.sub

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "Simple Calculator", fontSize = 32.sp)
                Spacer(modifier = Modifier.padding(8.dp))
                var a by remember{ mutableStateOf("0") }
                var b by remember{ mutableStateOf("0") }
                var c by remember{ mutableStateOf("0") }
                TextField(value = a, onValueChange = {a = it})
                Spacer(modifier = Modifier.padding(8.dp))
                TextField(value = b, onValueChange = {b = it})
                Spacer(modifier = Modifier.padding(8.dp))
                Row {
                    Button(onClick = { c = add(a,b) }) {
                        Text(text = "Addition")
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Button(onClick = { c = sub(a,b) }) {
                        Text(text = "Subtraction")
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row {
                    Button(onClick = { c = mul(a,b) }) {
                    Text(text = "Multiplication")
                }
                    Spacer(modifier = Modifier.padding(8.dp))
                    Button(onClick = { c = div(a,b) }) {
                        Text(text = "Division")
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Answer is: $c", color = Color.Blue, fontSize = 16.sp)
            }
        }
    }
}
