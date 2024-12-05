package my.rockpilgrim.timerforall.view.add;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatDialogFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import my.rockpilgrim.timerforall.R;
import my.rockpilgrim.timerforall.presenter.add.AddPresenter;

public class AddFragment extends MvpAppCompatDialogFragment implements MvpAddView {

    public static final String TAG = "AddFragment";
    @BindView(R.id.hours_picker)
    public NumberPicker hourPicker;

    @BindView(R.id.minutes_picker)
    public NumberPicker minutesPicker;

    @BindView(R.id.seconds_picker)
    public NumberPicker secondsPicker;

    @BindView(R.id.name_editText)
    public EditText nameEditText;

    @BindView(R.id.add_button)
    Button addButton;

    @InjectPresenter
    public AddPresenter presenter;

    @ProvidePresenter
    public AddPresenter providePresenter() {
        return new AddPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_fragment, container, false);
        ButterKnife.bind(this, root);

        initView();
        return root;
    }

    private void initView() {
        hourPicker.setMaxValue(23);
        hourPicker.setMinValue(0);

        minutesPicker.setMaxValue(59);
        minutesPicker.setMinValue(0);

        secondsPicker.setMaxValue(59);
        secondsPicker.setMinValue(0);
    }

    @OnClick(R.id.add_button)
    public void onAddClick() {
        Log.i(TAG, String.format("Add: %s ,%d:%d:%d"
                , nameEditText.getText().toString()
                , hourPicker.getValue()
                , minutesPicker.getValue()
                , secondsPicker.getValue()));

        presenter.addButton(hourPicker.getValue()
                , minutesPicker.getValue()
                , secondsPicker.getValue()
                , nameEditText.getText().toString());
        dismiss();
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getContext(), message,Toast.LENGTH_SHORT).show();
    }
}
