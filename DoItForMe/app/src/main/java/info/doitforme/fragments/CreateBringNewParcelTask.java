package info.doitforme.fragments;

import org.codepond.wizardroid.WizardFlow;
import org.codepond.wizardroid.layouts.BasicWizardLayout;

import info.doitforme.fragments.formsteps.ParcelStep1;
import info.doitforme.fragments.formsteps.ParcelStep2;
import info.doitforme.fragments.formsteps.ParcelStep3;

/**
 * Created by ptanwar on 06/06/15.
 */
public class CreateBringNewParcelTask extends BasicWizardLayout {

    public static String TAG = CreateBringNewParcelTask.class.getName();

    public CreateBringNewParcelTask() {
        super();
    }

    @Override
    public WizardFlow onSetup() {
        /* Optionally, you can set different labels for the control buttons
        setNextButtonLabel("Advance");
        setBackButtonLabel("Return");
        setFinishButtonLabel("Finalize"); */

        return new WizardFlow.Builder()
                .addStep(ParcelStep1.class)
                .addStep(ParcelStep2.class)
                .addStep(ParcelStep3.class)
                .create();
    }
}
