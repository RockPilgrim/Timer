package my.rockpilgrim.timerforall.presenter.list;

import javax.inject.Inject;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import my.rockpilgrim.timerforall.App;
import my.rockpilgrim.timerforall.model.Model;
import my.rockpilgrim.timerforall.presenter.timer.TimeListener;
import my.rockpilgrim.timerforall.presenter.timer.Timer;
import my.rockpilgrim.timerforall.presenter.timer.TimerHandler;
import my.rockpilgrim.timerforall.view.MvpMainView;

@InjectViewState
public class ListPresenter extends MvpPresenter<MvpMainView> implements OnListPresenter {

    private static final String TAG = "ListPresenter";
    public static final String FINISHED = "Finished";
    public static final String START = "Start!";

    @Inject
    public Model model;
    @Inject
    public TimerHandler timerHandler;

    public ListPresenter() {
        App.getComponent().inject(this);
//        initTimerList();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        initNotification();
    }

    private void initNotification() {
        timerHandler.setNotificationListener(new TimeListener() {
            @Override
            public void start(int index) {
                getViewState().notification(index,model.getTimer(index).getName(), START);
            }

            @Override
            public void finish(int index) {
                getViewState().notification(index,model.getTimer(index).getName(), FINISHED);
            }

            @Override
            public void onTick(int index, long millis) {
                getViewState().notification(index, model.getTimer(index).getName(), String.format("%s", (millis / 1000)));
            }
        });
    }

    private void initTimerList() {
        model.addTimer(new Timer(3));
        model.addTimer(new Timer(4));
        model.addTimer(new Timer(2));
    }



    @Override
    public void start(int index) {
        timerHandler.start(index);
    }

    @Override
    public void connectToModel(OnListChanged listener) {
        model.setListChangeListener(listener);
    }

    @Override
    public Timer getTimer(int index) {
        return model.getTimer(index);
    }

    @Override
    public void deleteTimer(int position) {
        model.delete(position);
    }

    @Override
    public int size() {
        return model.size();
    }
}
