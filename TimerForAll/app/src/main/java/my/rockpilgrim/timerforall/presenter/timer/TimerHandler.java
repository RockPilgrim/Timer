package my.rockpilgrim.timerforall.presenter.timer;

import android.util.Log;
import my.rockpilgrim.timerforall.model.Model;

public class TimerHandler implements TimeListener {

    private static final String TAG = "TimerHandler";
    public Model model;
    private TimeListener notificationListener;

    public TimerHandler(Model model) {
        this.model = model;
    }

    public void setNotificationListener(TimeListener notificationListener) {
        this.notificationListener = notificationListener;
    }

    public void start(int index) {
        try {
            model.getTimer(index).start();
            model.getTimer(index).setListener(this);
            Log.i(TAG, "start: " + index);
            notificationListener.start(index);
        } catch (NullPointerException e) {
            Log.e(TAG, "start: " + index, e);
        }
    }


    public void finish(int index) {
        Log.i(TAG, "finished: " + index);
        notificationListener.finish(index);
        start(++index);
    }

    @Override
    public void onTick(int index, long millis) {
        if (1000 * (Math.floor(millis / 1000)) == 100 * (Math.floor(millis / 100))) {
            notificationListener.onTick(index,millis);
        }
    }
}
