package my.rockpilgrim.timerforall.presenter.list;

import my.rockpilgrim.timerforall.presenter.timer.Timer;

public interface OnListPresenter {

    void start(int index);
    void connectToModel(OnListChanged listener);
    Timer getTimer(int index);
    void deleteTimer(int position);
    int size();
}
