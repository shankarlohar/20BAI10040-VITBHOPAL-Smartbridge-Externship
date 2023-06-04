package shankar.lohar20bai10040.task8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import shankar.lohar20bai10040.task8.ui.theme.Task8Theme
import shankar.lohar20bai10040.task8.ui.view.screen.DropDownScreen
import shankar.lohar20bai10040.task8.ui.view.screen.SomeScreen

class DropDownActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task8Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val info = intent.getStringExtra("info")
                    DropDownScreen(context = this@DropDownActivity,info.toString())
                }
            }
        }
    }
}
