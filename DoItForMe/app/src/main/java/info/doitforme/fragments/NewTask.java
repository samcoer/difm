package info.doitforme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.doitforme.R;

/**
 * Created by ptanwar on 06/06/15.
 */
public class NewTask extends Fragment {

    public NewTask() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.new_task, container, false);
        return rootView;
    }
}
