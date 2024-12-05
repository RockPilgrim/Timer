package my.rockpilgrim.timerforall.view.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.list.OnListPresenter;


public class TimerListAdapter extends RecyclerView.Adapter<ListHolder> implements AdapterDeleteListener{

    private OnListPresenter listPresenter;

    public TimerListAdapter(OnListPresenter presenter) {
        listPresenter = presenter;
        listPresenter.connectToModel(this::onAcceptChange);
    }

    private void onAcceptChange() {
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.timer_card,
                viewGroup,
                false);
        return new ListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder timerListHolder, int index) {
        timerListHolder.setPresenter(listPresenter);
//        timerListHolder.setTimer(listPresenter.getTimer(index));
//        if (listPresenter.getTimer(index) != null) {
            timerListHolder.bindView(index);
//        }
    }


    @Override
    public int getItemCount() {
        return listPresenter != null ? listPresenter.size() : 0;
    }

    @Override
    public void deleteView(int position) {
        listPresenter.deleteTimer(position);
        notifyItemRemoved(position);
    }
}
