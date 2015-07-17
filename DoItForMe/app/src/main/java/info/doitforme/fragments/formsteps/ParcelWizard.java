package info.doitforme.fragments.formsteps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.doitforme.R;

/**
 * Created by ptanwar on 17/07/15.
 */
public class ParcelWizard extends Fragment {
    public ParcelWizard() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.parcel_wizard_loader, container, false);
        return rootView;
    }
}
