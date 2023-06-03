package shankar.lohar20bai10040.task5.ui.view.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.unit.dp
import shankar.lohar20bai10040.task5.data.Details
import shankar.lohar20bai10040.task5.data.dataList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(
    context: Context,
    modifier: Modifier = Modifier
){
    Column( 
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = modifier.fillMaxSize()
    ) {
        val name  = remember{
            mutableStateOf("")
        }
        val age  = remember{
            mutableStateOf("")
        }
        val mobile  = remember{
            mutableStateOf("")
        }
        val location  = remember{
            mutableStateOf("")
        }

        val info by remember {
            mutableStateOf(dataList)
        }

        TextField(value = name.value, onValueChange = { name.value = it })
        Spacer(modifier = modifier.padding(8.dp))
        TextField(value = age.value, onValueChange = { age.value = it })
        Spacer(modifier = modifier.padding(8.dp))
        TextField(value = mobile.value, onValueChange = { mobile.value = it })
        Spacer(modifier = modifier.padding(8.dp))
        TextField(value = location.value, onValueChange = { location.value = it })
        Spacer(modifier = modifier.padding(8.dp))
        Button(onClick = {
            val newDetails = Details(
                name = name.value,
                age = age.value,
                mobile = mobile.value,
                location = location.value
            )
            name.value = ""
            age.value = ""
            mobile.value = ""
            location.value = ""
            info.add(newDetails)
            Toast.makeText(context,"Data sent!", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Send")
        }
        Spacer(modifier = modifier.padding(8.dp))
        LazyColumn(){
            items(info){data->
                ShowCard(data)
                Spacer(modifier = modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun ShowCard(data: Details) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { },
    ) {
        Text(text = "Name = ${data.name}")
        Text(text = "Age = ${data.age}")
        Text(text = "Mobile = ${data.mobile}")
        Text(text = "Location = ${data.location}")
    }
}
