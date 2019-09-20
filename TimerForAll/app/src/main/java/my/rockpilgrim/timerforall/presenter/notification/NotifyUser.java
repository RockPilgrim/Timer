package my.rockpilgrim.timerforall.presenter.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.list.ListPresenter;

public class NotifyUser {

    public static final String TIMER_INFO = "Timer info";
    public static final String CHANNEL_ID = "timer_channel_id";
    public static final String TAG = "NotifyUser";

    private NotificationManager notificationManager;
    private NotificationCompat.Builder builder;

    private Context context;

    public NotifyUser(NotificationManager notificationManager, Context context) {
        this.notificationManager = notificationManager;
        this.context = context;
    }

    private NotificationCompat.Builder getBuilder() {
        if (builder == null) {
            builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_add)
                    .setContentTitle("Timer")
                    .setContentText("Now")
//                        .setOngoing(running)
                    .setOnlyAlertOnce(true)
                    .setAutoCancel(true);
        }
        return builder;
    }

    public void notification(int index, String title, String text) {
        Log.i(TAG, "notification"+index);

        getBuilder().setContentTitle(title)
                .setContentText(text);
        if (text.equals(ListPresenter.FINISHED)) {
            getNotificationManager().cancel(index);
        }
        getNotificationManager().notify(index, getBuilder().build());
    }

    private NotificationManager getNotificationManager() {
        if (notificationManager == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                notificationManager = getSystemService(NotificationManager.class);
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "name", NotificationManager.IMPORTANCE_DEFAULT);
                channel.setDescription(TIMER_INFO);

                notificationManager.createNotificationChannel(channel);
            }
        }
        return notificationManager;
    }
}