package shankar.lohar20bai10040.task6.ui.view.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import shankar.lohar20bai10040.task6.R
import shankar.lohar20bai10040.task6.ui.view.components.CustomBottomAppBar
import shankar.lohar20bai10040.task6.ui.view.components.CustomFloatingActionButton
import shankar.lohar20bai10040.task6.ui.view.components.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen(
    context: Context,
    modifier: Modifier = Modifier,
){
    Scaffold(
        topBar = { CustomTopAppBar() },
        floatingActionButton = { CustomFloatingActionButton(context)},
        floatingActionButtonPosition = FabPosition.End,
        content = { padding ->
            Column(
                modifier = modifier
                    .padding(padding)
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.blood_donation),
                        contentDescription = "Blood Donation Image",
                        modifier = Modifier.fillMaxWidth()
                    )
                    var name by remember {
                        mutableStateOf("")
                    }
                    var phone by remember {
                        mutableStateOf("+(91) ")
                    }
                    Spacer(modifier = modifier.padding(16.dp))
                    Text(text = "Name of doner")
                    Spacer(modifier = modifier.padding(16.dp))
                    TextField(value = name, onValueChange = {name = it})
                    Spacer(modifier = modifier.padding(16.dp))
                    Text(text = "Phone Number")
                    Spacer(modifier = modifier.padding(16.dp))
                    TextField(value = phone, onValueChange = {phone = it})
                }
            } },
        bottomBar = { CustomBottomAppBar()},
    )
}