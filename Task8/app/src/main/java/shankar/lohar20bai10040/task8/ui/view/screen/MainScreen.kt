package shankar.lohar20bai10040.task8.ui.view.screen

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shankar.lohar20bai10040.task8.DropDownActivity
import shankar.lohar20bai10040.task8.NextActivity
import shankar.lohar20bai10040.task8.SomeActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    context: Context,
    modifier: Modifier = Modifier
    ){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        val name = remember { mutableStateOf("") }
        Text(text = "Name")
        TextField(value = name.value, onValueChange = {name.value = it})
        Spacer(modifier = modifier.padding(8.dp))

        val location = remember { mutableStateOf("") }
        Text(text = "Location")
        TextField(value = location.value, onValueChange = {location.value = it})
        Spacer(modifier = modifier.padding(8.dp))

        val mobile = remember { mutableStateOf("") }
        Text(text = "Mobile")
        TextField(value = mobile.value, onValueChange = {mobile.value = it})
        Spacer(modifier = modifier.padding(8.dp))

        val mail = remember { mutableStateOf("") }
        Text(text = "Mail")
        TextField(value = mail.value, onValueChange = {mail.value = it})
        Spacer(modifier = modifier.padding(8.dp))

        val checkedState = remember { mutableStateOf(false) }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Checkbox(checked = checkedState.value, onCheckedChange = {checkedState.value = it})
            Text(text = "Agree TnC")
        }
        Spacer(modifier = modifier.padding(8.dp))
        val text = remember {
            mutableStateOf("")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(onClick = {
                if (checkedState.value) {
                    Toast.makeText(context, "Name: ${name.value}\nLocation: ${location.value}\nMobile: ${mobile.value}\nMail: ${mail.value}", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context, "Please mark check first!", Toast.LENGTH_LONG).show()

                }
            }) {
                Text(text = "Toast")
            }
            Button(onClick = {
                if (checkedState.value) {
                    text.value = "Name: ${name.value}\nLocation: ${location.value}\nMobile: ${mobile.value}\nMail: ${mail.value}"
                }else{
                    Toast.makeText(context, "Please mark check first!", Toast.LENGTH_LONG).show()
                }
            }) {
                Text(text = "Text")
            }
        }
        Spacer(modifier = modifier.padding(8.dp))
        Button(onClick = {
            if (checkedState.value) {
                val intent = Intent(context, NextActivity::class.java).apply {
                    putExtra("info","Name: ${name.value}\nLocation: ${location.value}\nMobile: ${mobile.value}\nMail: ${mail.value}")
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(intent)
            }else{
                Toast.makeText(context, "Please mark check first!", Toast.LENGTH_SHORT).show()
            }

        }) {
            Text(text = "Next")
        }
        Spacer(modifier = modifier.padding(8.dp))
        Text(text = text.value)
        Spacer(modifier = modifier.padding(8.dp))
        Row() {
            Spacer(modifier = modifier.padding(8.dp))
            Button(onClick = {
                if (checkedState.value) {
                    val intent = Intent(context, SomeActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                    context.startActivity(intent)
                }else{
                    Toast.makeText(context, "Please mark check first!", Toast.LENGTH_SHORT).show()
                }

            }) {
                Text(text = "Something")
            }

            Spacer(modifier = modifier.padding(8.dp))
            Button(onClick = {
                if (checkedState.value) {
                    val intent = Intent(context, DropDownActivity::class.java).apply {
                        putExtra("info","Name: ${name.value}\nLocation: ${location.value}\nMobile: ${mobile.value}\nMail: ${mail.value}")
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                    context.startActivity(intent)
                }else{
                    Toast.makeText(context, "Please mark check first!", Toast.LENGTH_SHORT).show()
                }

            }) {
                Text(text = "Dropdown")
            }
        }


    }
}