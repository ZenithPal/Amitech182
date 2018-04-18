package fgc.amitech18;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class EventDialogFragment extends DialogFragment{

    private int id;
    public EventDialogFragment() {
        super();
    }
    @SuppressLint("ValidFragment")
    public EventDialogFragment(int id) {
        super();
        this.id = id;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.event_dialog_fragment, container,
                false);
        ImageView eventImage = rootView.findViewById(R.id.event_dialog_fragment_imageView);
        eventImage.setImageResource(id);
        return rootView;
    }
}
