package info.doitforme.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.doitforme.R;

/**
 * Created by ptanwar on 06/06/15.
 */
public class Profile extends Fragment {

    public Profile() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile, container, false);
        return rootView;
    }
}
