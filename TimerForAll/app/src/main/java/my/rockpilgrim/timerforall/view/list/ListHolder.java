package my.rockpilgrim.timerforall.view.list;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.list.ListPresenter;
import my.rockpilgrim.timerforall.presenter.list.OnListPresenter;
import my.rockpilgrim.timerforall.presenter.timer.Timer;


public class ListHolder extends RecyclerView.ViewHolder {

    private static final String LOG = "ListHolder";
    public static final String TAG = "ListHolder";
    private TextView textBegin;
    private CardView cardView;
    private Timer timer;

    private OnListPresenter presenter;


    public ListHolder(@NonNull View itemView) {
        super(itemView);
        textBegin = itemView.findViewById(R.id.inner_text);
        cardView = itemView.findViewById(R.id.card_view);
    }

    public void bindView(int index) {
        textBegin.setText(timer.getName());
        Log.i(TAG, "bind: " + index);
        onClickListener(index);
    }

    public void setPresenter(OnListPresenter presenter) {
        this.presenter = presenter;
        timer = presenter.getTimer(getAdapterPosition());
        timer.setChangeListener(this);
        Log.i(LOG, "Set");
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
        timer.setChangeListener(this);
        Log.i(LOG, "Set timer");
    }

    public void setTimerText(String time) {
        textBegin.setText(time);
    }

    private void onClickListener(final int index) {
        cardView.setOnClickListener(v -> {
            presenter.start(index);
        });
    }
}
