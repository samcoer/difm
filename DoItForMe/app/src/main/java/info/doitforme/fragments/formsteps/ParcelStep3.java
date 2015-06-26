package info.doitforme.fragments.formsteps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.codepond.wizardroid.WizardStep;

import info.doitforme.R;

/**
 * Created by ptanwar on 27/06/15.
 */
public class ParcelStep3 extends WizardStep {

    String desc;
    EditText descEl;


    //Wire the layout to the step
    public ParcelStep3() {
    }

    //Set your layout here
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.parcel_step_3, container, false);
        descEl = (EditText)v.findViewById(R.id.desc);
        descEl.setText(desc);
        return v;
    }


    /**
     * Called whenever the wizard proceeds to the next step or goes back to the previous step
     */
    @Override
    public void onExit(int exitCode) {
        switch (exitCode) {
            case WizardStep.EXIT_NEXT:
                bindDataFields();
                break;
            case WizardStep.EXIT_PREVIOUS:
                //Do nothing...
                break;
        }
    }


    private void bindDataFields() {
        //Do some work
        //...
        //The values of these fields will be automatically stored in the wizard context
        //and will be populated in the next steps only if the same field names are used.
        desc = descEl.getText().toString();
    }
}
