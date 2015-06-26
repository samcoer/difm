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
public class ParcelStep1 extends WizardStep {

    String toAddr;
    String toPh;
    String fromAddr;
    String fromPh;

    EditText toAddrEl;
    EditText toPhEl;
    EditText fromAddrEl;
    EditText fromPhEl;

    //Wire the layout to the step
    public ParcelStep1() {
    }

    //Set your layout here
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.parcel_step_1, container, false);
        toAddrEl = (EditText)v.findViewById(R.id.to_addr);
        toPhEl = (EditText)v.findViewById(R.id.to_phone);
        fromAddrEl = (EditText)v.findViewById(R.id.from_addr);
        fromPhEl = (EditText)v.findViewById(R.id.from_phone);

        toAddrEl.setText(toAddr);
        toPhEl.setText(toPh);
        fromAddrEl.setText(fromAddr);
        fromPhEl.setText(fromPh);
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
        toAddr = toAddrEl.getText().toString();
        toPh = toPhEl.getText().toString();
        fromAddr = fromAddrEl.getText().toString();
        fromPh = fromPhEl.getText().toString();
    }
}
