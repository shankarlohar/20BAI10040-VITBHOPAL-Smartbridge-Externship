package shankar.lohar20bai10040.task4.ui.view.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen( 
    context: Context,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        var var1 by remember {
            mutableStateOf("")
        }
        var var2 by remember {
            mutableStateOf("")
        }
        var var3 by remember {
            mutableStateOf("")
        }
        TextField(value = var1, onValueChange = {var1 = it})
        Spacer(modifier = modifier.padding(8.dp))
        TextField(value = var2, onValueChange = {var2 = it})
        Spacer(modifier = modifier.padding(8.dp))
        Button(onClick = {
            Toast.makeText(context,"This is : $var1 $var2",Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Toast")
        }
        Button(onClick = {
            var3 = "Here is : $var1 $var2"
        }) {
            Text(text = "Text")
        }
        Text(text = var3, fontSize = 16.sp, color = Color.Blue)
    }
}