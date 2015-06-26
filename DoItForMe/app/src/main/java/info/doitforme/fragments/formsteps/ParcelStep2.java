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
public class ParcelStep2 extends WizardStep {

    String weight;
    String distance;
    String urgency;
    String count;

    EditText weightEl;
    EditText distanceEl;
    EditText urgencyEl;
    EditText countEl;


    //Wire the layout to the step
    public ParcelStep2() {
    }

    //Set your layout here
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.parcel_step_2, container, false);
        weightEl = (EditText)v.findViewById(R.id.weight);
        distanceEl = (EditText)v.findViewById(R.id.distance);
        urgencyEl = (EditText)v.findViewById(R.id.urgency);
        countEl = (EditText)v.findViewById(R.id.count);

        weightEl.setText(weight);
        distanceEl.setText(distance);
        urgencyEl.setText(urgency);
        countEl.setText(count);
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
        weight = weightEl.getText().toString();
        distance = distanceEl.getText().toString();
        urgency = urgencyEl.getText().toString();
        count = countEl.getText().toString();
    }

}
