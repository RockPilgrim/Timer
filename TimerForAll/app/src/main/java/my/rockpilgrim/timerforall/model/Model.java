package my.rockpilgrim.timerforall.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import my.rockpilgrim.timerforall.model.Tree.TreeHolder;
import my.rockpilgrim.timerforall.presenter.list.OnListChanged;
import my.rockpilgrim.timerforall.presenter.timer.Timer;

public class Model {

    public static final String TAG = "Model";

    OnListChanged listener;
    private TreeHolder<Timer> timerList;
    private Map<Integer, ArrayList<Timer>> timerMap;
    private ArrayList<Timer> timers;

    public Model() {
        timerList = new TreeHolder<>();
        timerMap = new TreeMap<>();
        timers = new ArrayList<>();
    }


    public void addTimer(Timer timer) {
        timer.setIndex(timers.size());
        timers.add(timer);

        onChange();
    }

    public Timer getTimer(int index) {
        return timers.get(index);
    }

    public void delete(int index) {
        Log.i(TAG, "Delete");
        timers.remove(index);
        refreshTimers();
    }

    private void refreshTimers() {
        for (int i = 0; i < size(); i++) {
            timers.get(i).setIndex(i);
        }
    }

    public int size() {
        return timers.size();
    }

    private void onChange() {
        if (listener != null) {
            listener.onListChange();
        }
    }

    public void setListChangeListener(OnListChanged listener) {
        this.listener = listener;
    }
}
