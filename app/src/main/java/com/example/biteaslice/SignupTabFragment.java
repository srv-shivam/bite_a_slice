package com.example.biteaslice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SignupTabFragment extends Fragment {

    EditText email, mobilNo, password, confirmPass;
    Button signup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_signup_tab, container, false);

        email = root.findViewById(R.id.email_signup);
        mobilNo = root.findViewById(R.id.mobile_signup);
        password = root.findViewById(R.id.pass_signup);
        confirmPass = root.findViewById(R.id.confirm_pass);
        signup = root.findViewById(R.id.signup_btn);

        email.setTranslationX(800);
        mobilNo.setTranslationX(800);
        password.setTranslationX(800);
        confirmPass.setTranslationX(800);
        signup.setTranslationX(800);

        email.setAlpha(0);
        mobilNo.setAlpha(0);
        password.setAlpha(0);
        confirmPass.setAlpha(0);
        signup.setAlpha(0);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        mobilNo.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        confirmPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return root;
    }
}