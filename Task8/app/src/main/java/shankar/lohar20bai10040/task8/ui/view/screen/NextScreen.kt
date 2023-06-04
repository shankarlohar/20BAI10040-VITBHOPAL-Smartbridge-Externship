package shankar.lohar20bai10040.task8.ui.view.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NextScreen(
    context: Context,
    text: String,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(text = text)
        Spacer(modifier = modifier.padding(8.dp))
        val alertFlag = remember {
            mutableStateOf(false)
        }
        Button(onClick = {
            alertFlag.value = true
        }) {
            Text(text = "Send Message")
        }
        if (alertFlag.value){
            AlertDialog(
                onDismissRequest = { alertFlag.value = false },
                title = { Text(text = "Confirm Message Sending") },
                confirmButton = {
                    Button(onClick = {
                        Toast.makeText(context,"Sms Sent!",Toast.LENGTH_SHORT).show()
                        alertFlag.value = false
                    }) {
                        Text(text = "Confirm")
                    }
                },
                dismissButton = {
                    Button(onClick = {
                        alertFlag.value = false
                    }) {
                        Text(text = "Dismiss")
                    }
                }
            )
        }
    }
}