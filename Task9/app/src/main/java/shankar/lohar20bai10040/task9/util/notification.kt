package shankar.lohar20bai10040.task9.util

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import kotlin.random.Random

class WaterNotificationService(
    private val context: Context
){
    fun showBasicNotification() {
        val notification = NotificationCompat.Builder(context, "water_notification")
            .setSmallIcon(android.R.drawable.btn_dropdown)
            .setContentTitle("Drink some water!")
            .setContentText("It passed one hour since you drank some water")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            // Disappears after clicking the notification
            .setAutoCancel(true)
            .build()

        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.notify(Random.nextInt(), notification)
    }
}