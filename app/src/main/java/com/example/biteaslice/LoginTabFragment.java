package com.example.biteaslice;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment {

    EditText email, password;
    Button login;
    TextView forgotPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_login_tab, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.pass);
        login = root.findViewById(R.id.login_btn);
        forgotPass = root.findViewById(R.id.forgot_pass);

        email.setTranslationX(800);
        password.setTranslationX(800);
        login.setTranslationX(800);
        forgotPass.setTranslationX(800);

        email.setAlpha(0);
        password.setAlpha(0);
        login.setAlpha(0);
        forgotPass.setAlpha(0);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }
}