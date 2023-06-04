package shankar.lohar20bai10040.task9

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import shankar.lohar20bai10040.task9.ui.theme.Task9Theme
import shankar.lohar20bai10040.task9.util.WaterNotificationService

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task9Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(8.dp)
                    ) {

                        val notificationPermissionState =
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                rememberPermissionState(
                                    permission = Manifest.permission.POST_NOTIFICATIONS
                                )
                            } else {
                                TODO("VERSION.SDK_INT < TIRAMISU")
                            }

                        val waterNotificationService = remember {
                            WaterNotificationService(this@MainActivity)
                        }

                        Text(text = "Just Notification App")
                        Spacer(modifier = Modifier.padding(8.dp))
                        Button(onClick = {
                            if (!notificationPermissionState.status.isGranted) {
                                notificationPermissionState.launchPermissionRequest()
                            } else {
                                waterNotificationService.showBasicNotification()
                            }

                        }) {
                            Text(text = "Show Notification")
                        }
                    }
                }
            }
        }
    }
}
