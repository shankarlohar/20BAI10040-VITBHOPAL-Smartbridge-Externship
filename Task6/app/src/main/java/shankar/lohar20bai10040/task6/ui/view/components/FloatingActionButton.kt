package shankar.lohar20bai10040.task6.ui.view.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomFloatingActionButton(context: Context){
    FloatingActionButton(onClick = {
        Toast.makeText(context,"Doner added to database.",Toast.LENGTH_SHORT).show()
    }) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ){
            Icon(imageVector = Icons.Default.Check, contentDescription = "fab icon")
            Text(text = "Add Doner")
        }
    }
}

