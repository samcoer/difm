package info.doitforme.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import info.doitforme.R;
import info.doitforme.integration.ServiceFactory;
import info.doitforme.integration.bo.User;
import info.doitforme.integration.service.UserService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ptanwar on 06/06/15.
 */
public class Login extends Fragment {
    private Button btnRegister;
    private Button btnLogin;
    private LoginButton btnLoginFB;
    private ImageButton btnLoginGP;
    private CallbackManager callbackManager;

    public Login() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login, container, false);
        createButtons(rootView);
        return rootView;
    }

    private void createButtons(View rootView) {
        btnLogin = (Button) rootView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TEST", "Login");
            }
        });

        initFB(rootView);

        btnLoginGP = (ImageButton) rootView.findViewById(R.id.btnLoginGP);
        btnLoginGP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TEST","GP Login");
            }
        });

        btnRegister = (Button) rootView.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TEST","Register");
//                ((UserService) ServiceFactory.getService(UserService.class)).get(0L, new Callback() {
//                    @Override
//                    public void success(Object user, Response response) {
//                       Log.d("TEST", "success");
//                    }
//
//                    @Override
//                    public void failure(RetrofitError retrofitError) {
//                       Log.d("TEST", "failure");
//                    }
//                });
                Fragment registrationFragment = Register.newInstance();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, registrationFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private void initFB(View rootView){
        callbackManager = CallbackManager.Factory.create();
        btnLoginFB = (LoginButton) rootView.findViewById(R.id.btnLoginFB);
        btnLoginFB.setReadPermissions("user_friends");
        //TODO Check if required, commented by Chetan
        //btnLoginFB.setFragment(this);
        btnLoginFB.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("TEST", "Login Success");
            }

            @Override
            public void onCancel() {
                Log.d("TEST", "Login Cancel");
            }

            @Override
            public void onError(FacebookException exception) {
                Log.d("TEST", "Login Error");
                Log.d("TEST", exception.getLocalizedMessage());
            }
        });
    }

}
