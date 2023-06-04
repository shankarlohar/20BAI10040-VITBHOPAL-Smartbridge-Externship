package shankar.lohar20bai10040.task9

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

class WaterApplication : Application() {
    @androidx.annotation.RequiresApi(android.os.Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        val notificationChannel = NotificationChannel(
            "water_notification", // id
            "Water", // name
            NotificationManager.IMPORTANCE_HIGH // importance
        )

        notificationChannel.description = "A channel used to send water reminders"


        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)
    }
}