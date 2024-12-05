package my.rockpilgrim.timerforall.view;

import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.list.ListPresenter;
import my.rockpilgrim.timerforall.presenter.notification.NotifyHandler;
import my.rockpilgrim.timerforall.view.add.AddFragment;
import my.rockpilgrim.timerforall.view.list.SwipeController;
import my.rockpilgrim.timerforall.view.list.TimerListAdapter;

public class MainActivity extends MvpAppCompatActivity implements MvpMainView {


    public static final String TAG = "MainActivity";

    @BindView(R.id.floatingActionButton)
    public FloatingActionButton actionButton;

    private RecyclerView recyclerView;
    private TimerListAdapter listAdapter;

    private NotifyHandler notifyHandler;

    @InjectPresenter
    public ListPresenter presenter;

    @ProvidePresenter
    public ListPresenter providePresenter() {
        return new ListPresenter();
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);
        initList();
        initNotification();
    }

    private void initNotification() {
        notifyHandler = new NotifyHandler(getSystemService(NotificationManager.class), this);
    }


    private void initList() {
        listAdapter = new TimerListAdapter(presenter);
        recyclerView = findViewById(R.id.recycler_view);
        // More productivity
//        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listAdapter);

        SwipeController swipeController = new SwipeController(listAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @OnClick(R.id.floatingActionButton)
    public void onActionButtonClick() {

        AddFragment addFragment = new AddFragment();
        addFragment.show(getSupportFragmentManager(), "add");
    }

    @Override
    public void notification(int index, String title, String text) {
        Log.i(TAG, "notification: " + index);
        notifyHandler.notify(index, title, text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        notification(2, "Time", "Pause");
    }
}
