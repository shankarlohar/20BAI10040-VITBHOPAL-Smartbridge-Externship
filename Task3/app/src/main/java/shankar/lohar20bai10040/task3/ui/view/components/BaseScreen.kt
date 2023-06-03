package shankar.lohar20bai10040.task3.ui.view.components

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
fun BaseScreen(
    context:Context,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var topText by remember{
            mutableStateOf("None")
        }
        val open1 = remember {
            mutableStateOf(false)
        }
        val open2 = remember {
            mutableStateOf(false)
        }

        if (open1.value){
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onCloseRequest.
                    open1.value = false
                },
                title = {
                    Text(text = "You have pressed One")
                },
                confirmButton = {
                    Button(

                        onClick = {
                            open1.value = false
                            Toast.makeText(context,"One pressed",Toast.LENGTH_SHORT).show()
                        }) {
                        Text("Okay")
                    }
                }
            )
        }

        if (open2.value){
            AlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onCloseRequest.
                    open2.value = false
                },
                title = {
                    Text(text = "You have pressed Two")
                },
                confirmButton = {
                    Button(

                        onClick = {
                            open2.value = false
                            Toast.makeText(context,"Two pressed",Toast.LENGTH_SHORT).show()
                        }) {
                        Text("Two")
                    }
                },
                dismissButton = {
                    Button(

                        onClick = {
                            open2.value = false
                            Toast.makeText(context,"One pressed",Toast.LENGTH_SHORT).show()
                        }) {
                        Text("One")
                    }
                }
            )
        }


        Text(text = "Pressed button is: $topText", fontSize = 16.sp, color = Color.Blue)
        Spacer(modifier = modifier.padding(8.dp))
        Button(onClick = {
            topText = "One"
            open1.value = true
        }) {
            Text(text = "One")
        }
        Spacer(modifier = modifier.padding(8.dp))
        Button(onClick = {
            topText = "Two"
            open2.value = true
        }) {
            Text(text = "Two")
        }
    }
}