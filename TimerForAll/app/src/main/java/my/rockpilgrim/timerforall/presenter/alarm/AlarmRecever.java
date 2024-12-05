package my.rockpilgrim.timerforall.presenter.alarm;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import my.rockpilgrim.timerforall.R;

public class AlarmRecever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_add)
                .setContentTitle("Lol")
                .setContentText("Finished")
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND);
    }
}
