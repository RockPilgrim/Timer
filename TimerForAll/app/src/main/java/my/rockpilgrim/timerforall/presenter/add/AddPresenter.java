package my.rockpilgrim.timerforall.presenter.add;

import android.util.Log;

import javax.inject.Inject;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import my.rockpilgrim.timerforall.App;
import my.rockpilgrim.timerforall.model.Model;
import my.rockpilgrim.timerforall.presenter.timer.Timer;
import my.rockpilgrim.timerforall.view.add.MvpAddView;

@InjectViewState
public class AddPresenter extends MvpPresenter<MvpAddView> {

    private static final String TAG = "AddPresenter";

    @Inject
    Model model;

    public AddPresenter() {
        App.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        Log.i(TAG, "onFirstViewAttach");
        super.onFirstViewAttach();
    }

    public void addButton(int hours, int minutes, int seconds, String name) {
        Timer timer;
        if (hours != 0 || minutes != 0 || seconds != 0) {
            int t = hours * 3600 + minutes * 60 + seconds;
            timer = new Timer(t, name);
        } else {
            getViewState().makeToast("Insert time");
            return;
        }
        model.addTimer(timer);
    }
}
