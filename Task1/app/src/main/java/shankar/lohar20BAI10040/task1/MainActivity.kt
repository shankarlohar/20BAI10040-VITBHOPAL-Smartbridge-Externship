package shankar.lohar20BAI10040.task1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Column(
                ) {
                    var username by remember {
                        mutableStateOf("")
                    }
                    var password by remember {
                        mutableStateOf("")
                    }
                    Image(
                        painter = painterResource(R.drawable.vit_logo),
                        contentDescription = "vit logo image",
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(text = "Username")
                    TextField(value = username, onValueChange = { username = it })
                    Spacer(modifier = Modifier.padding(16.dp))
                    Text(text = "Password")
                    TextField(value = password, onValueChange = { password = it })
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Row(

                ) {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Sign In")
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Sign Up")
                    }
                }

            }
        }
    }
}

