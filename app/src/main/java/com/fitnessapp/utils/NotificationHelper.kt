
package com.fitnessapp.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class NotificationHelper(private val context: Context) {

    private val WORKOUT_CHANNEL_ID = "workout_channel"
    private val WORKOUT_CHANNEL_NAME = "Уведомления о тренировках"
    private val WORKOUT_CHANNEL_DESCRIPTION = "Уведомления о предстоящих тренировках"

    private val NUTRITION_CHANNEL_ID = "nutrition_channel"
    private val NUTRITION_CHANNEL_NAME = "Уведомления о питании"
    private val NUTRITION_CHANNEL_DESCRIPTION = "Уведомления о приеме пищи"

    init {
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Workout Channel
            val workoutChannel = NotificationChannel(
                WORKOUT_CHANNEL_ID,
                WORKOUT_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = WORKOUT_CHANNEL_DESCRIPTION
            }
            // Nutrition Channel
            val nutritionChannel = NotificationChannel(
                NUTRITION_CHANNEL_ID,
                NUTRITION_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = NUTRITION_CHANNEL_DESCRIPTION
            }

            val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(workoutChannel)
            notificationManager.createNotificationChannel(nutritionChannel)
        }
    }

    fun sendWorkoutNotification(title: String, message: String, notificationId: Int) {
        val builder = NotificationCompat.Builder(context, WORKOUT_CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, builder.build())
        }
    }

    fun sendNutritionNotification(title: String, message: String, notificationId: Int) {
        val builder = NotificationCompat.Builder(context, NUTRITION_CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, builder.build())
        }
    }
}

