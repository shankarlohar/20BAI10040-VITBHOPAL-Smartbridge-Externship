package shankar.lohar20bai10040.task6.ui.view.components

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shankar.lohar20bai10040.task6.InfoActivity

@Composable
fun CustomFloatingActionButton(
    context: Context,
){
    FloatingActionButton(onClick = {
        val intent = Intent(context, InfoActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        Toast.makeText(context,"Showing Doners.",Toast.LENGTH_LONG).show()
        context.startActivity(intent)
    }) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ){
            Icon(imageVector = Icons.Default.Person, contentDescription = "fab icon")
            Text(text = "See Doners")
        }
    }
}

