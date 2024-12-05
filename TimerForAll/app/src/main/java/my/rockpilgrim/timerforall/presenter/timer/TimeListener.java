package my.rockpilgrim.timerforall.presenter.timer;

public interface TimeListener {

    void start(int index);
    void finish(int index);
    void onTick(int index,long millis);


}
