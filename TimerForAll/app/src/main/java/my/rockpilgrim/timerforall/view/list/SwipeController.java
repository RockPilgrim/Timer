package my.rockpilgrim.timerforall.view.list;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class SwipeController extends ItemTouchHelper.Callback {

    public static final String TAG = "SwipeController";
    private AdapterDeleteListener adapter;

    public SwipeController(AdapterDeleteListener adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.LEFT);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if (direction == ItemTouchHelper.LEFT) {
            adapter.deleteView(viewHolder.getAdapterPosition());
            Log.i(TAG, "onSwiped: left");
        } else if (direction == ItemTouchHelper.RIGHT) {
            Log.i(TAG, "onSwiped: right");
        }
    }
}
