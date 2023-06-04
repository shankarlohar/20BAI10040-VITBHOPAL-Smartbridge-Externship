package shankar.lohar20bai10040.task6.ui.view.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import shankar.lohar20bai10040.task6.R
import shankar.lohar20bai10040.task6.data.Doner
import shankar.lohar20bai10040.task6.data.donerInfo
import shankar.lohar20bai10040.task6.ui.view.components.CustomBottomAppBar
import shankar.lohar20bai10040.task6.ui.view.components.CustomFloatingActionButton
import shankar.lohar20bai10040.task6.ui.view.components.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(
    context: Context,
    modifier: Modifier = Modifier,
) {
    val info by remember { mutableStateOf(donerInfo) }
    Scaffold(
        topBar = { CustomTopAppBar() },
        floatingActionButton = { CustomFloatingActionButton(context) },
        floatingActionButtonPosition = FabPosition.End,
        content = { padding ->
            Column(
                modifier = modifier
                    .padding(padding)
                    .fillMaxWidth()
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    item {
                        Image(
                            painter = painterResource(R.drawable.blood_donation),
                            contentDescription = "Blood Donation Image",
                            modifier = Modifier.fillMaxWidth()
                        )
                        val name = remember {
                            mutableStateOf("")
                        }
                        val age = remember {
                            mutableStateOf("")
                        }
                        val bloodGroup = remember {
                            mutableStateOf("")
                        }
                        val phone = remember {
                            mutableStateOf("+(91) ")
                        }


                        Spacer(modifier = modifier.padding(8.dp))
                        Text(text = "Name of doner")
                        Spacer(modifier = modifier.padding(8.dp))
                        TextField(value = name.value, onValueChange = { name.value = it })
                        Spacer(modifier = modifier.padding(8.dp))
                        Text(text = "Age of doner")
                        Spacer(modifier = modifier.padding(8.dp))
                        TextField(value = age.value, onValueChange = { age.value = it })
                        Spacer(modifier = modifier.padding(8.dp))
                        Text(text = "Blood group of doner")
                        Spacer(modifier = modifier.padding(8.dp))
                        TextField(
                            value = bloodGroup.value,
                            onValueChange = { bloodGroup.value = it })
                        Spacer(modifier = modifier.padding(8.dp))
                        Text(text = "Phone number of doner")
                        Spacer(modifier = modifier.padding(8.dp))
                        TextField(value = phone.value, onValueChange = { phone.value = it })
                        Spacer(modifier = modifier.padding(8.dp))
                        Button(onClick = {
                            info.add(Doner(name.value,age.value, bloodGroup.value,phone.value))
                            Toast.makeText(context,"Doner ${name.value} added successfully!",Toast.LENGTH_SHORT).show()
                            name.value = ""
                            age.value = ""
                            bloodGroup.value = ""
                            phone.value = "+91 "
                        }) {
                            Text(text = "Add doner")
                        }
                    }
                }
            }
        },
        bottomBar = { CustomBottomAppBar() },
    )
}