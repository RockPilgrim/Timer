package my.rockpilgrim.timerforall.view;

import moxy.MvpView;

public interface MvpMainView extends MvpView {

    void notification(int index, String title, String text);
}
