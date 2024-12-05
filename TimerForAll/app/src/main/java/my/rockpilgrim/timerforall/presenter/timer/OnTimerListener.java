package my.rockpilgrim.timerforall.presenter.timer;

public interface OnTimerListener {

    void onStart(int index);
    void onFinish(int index);
//    void onTick(int index,long millis);
}
