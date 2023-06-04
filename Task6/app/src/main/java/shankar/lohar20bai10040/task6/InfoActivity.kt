package shankar.lohar20bai10040.task6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import shankar.lohar20bai10040.task6.data.Doner
import shankar.lohar20bai10040.task6.ui.theme.Task6Theme
import shankar.lohar20bai10040.task6.ui.view.screen.InfoScreen

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InfoScreen(applicationContext)
                }
            }
        }
    }
}
