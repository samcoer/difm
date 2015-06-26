package info.doitforme.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import info.doitforme.R;
import info.doitforme.integration.ServiceFactory;
import info.doitforme.integration.bo.User;
import info.doitforme.integration.service.UserService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Register.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    private static SimpleDateFormat sdfStandard = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Register.
     */
    // TODO: Rename and change types and number of parameters
    public static Register newInstance() {
        Register fragment = new Register();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        return fragment;
    }

    public Register() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_register, container, false);
        Button btnRegisterUser = (Button) rootView.findViewById(R.id.btnRegisterUser);
        btnRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                TextView txtFullName = (TextView)rootView.findViewById(R.id.txtFullName);
                //TODO validate full name
                user.setFullName(txtFullName.getText().toString());

                TextView txtEmail = (TextView) rootView.findViewById(R.id.txtEmail);
                //TODO validate email
                user.setEmail(txtEmail.getText().toString());

                TextView txtPassword = (TextView) rootView.findViewById(R.id.txtPassword);
                TextView txtRetypePassword = (TextView) rootView.findViewById(R.id.txtRetypePassword);
                if(!txtPassword.getText().toString().equals(txtRetypePassword.getText().toString())){
                    txtRetypePassword.setError("Password does not match");
                    return;
                }
                //TODO validate password
                user.setPassword(txtPassword.getText().toString());

                TextView txtDob = (TextView)rootView.findViewById(R.id.txtDob);
                String dob = txtDob.getText().toString();
                //TODO Validate dob
                try {
                    user.setDateOfBirth(sdfStandard.format(sdf.parse(dob)));
                }catch (ParseException pe){
                    Log.d("TEST", "Unable to parse date of birth");
                }

                RadioGroup rgGender = (RadioGroup)rootView.findViewById(R.id.rgGender);
                //TODO validate gender
                if(rgGender.getCheckedRadioButtonId()!=-1){
                    int id= rgGender.getCheckedRadioButtonId();
                    View radioButton = rgGender.findViewById(id);
                    int radioId = rgGender.indexOfChild(radioButton);
                    RadioButton btnGender = (RadioButton) rgGender.getChildAt(radioId);
                    String gender = (String) btnGender.getText();
                    user.setGender(gender);
                }

                TelephonyManager tMgr = (TelephonyManager)getActivity().getSystemService(Context.TELEPHONY_SERVICE);
                String mPhoneNumber = tMgr.getLine1Number();
                user.setPhoneNumber(mPhoneNumber);

                ((UserService)ServiceFactory.getService(UserService.class)).create(user, new Callback<User>() {
                    @Override
                    public void success(User user, Response response) {
                        Log.d("TEST", "Successfully created user");
                        //Go to add task screen
                        Fragment newTaskFragment = new NewTask();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.container, newTaskFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d("TEST", error.getMessage());
                    }
                });
            }
        });
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
