package shankar.lohar20bai10040.task6.ui.view.screen

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shankar.lohar20bai10040.task6.MainActivity
import shankar.lohar20bai10040.task6.data.donerInfo
import shankar.lohar20bai10040.task6.ui.view.components.CustomBottomAppBar
import shankar.lohar20bai10040.task6.ui.view.components.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(
    context: Context,
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = { CustomTopAppBar() },
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

                        items(donerInfo){ doner->
                            Card() {
                                Text(text = "Name: ${doner.name}")
                                Text(text = "Age: ${doner.age}")
                                Text(text = "Blood group: ${doner.bloogGroup}")
                                Text(text = "Phone: ${doner.phone}")
                            }
                        }
                    }
                Button(onClick = {
                    val intent = Intent(context,MainActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                    context.startActivity(intent)
                }) {
                    Text(text = "Back to main")
                }
                }
            },
        bottomBar = { CustomBottomAppBar()},
    )
}