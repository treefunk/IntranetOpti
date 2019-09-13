package com.myoptimind.intranet.main.controller;

import android.util.Log;

import com.google.android.material.textfield.TextInputEditText;
import com.myoptimind.intranet.BaseActivity;
import com.myoptimind.intranet.main.activity.LoginActivity;
import com.myoptimind.intranet.main.model.LoginModel;

public class LoginController {

    BaseActivity mActivity;
    LoginModel mModel;



    public LoginController(BaseActivity activity){
        this.mActivity = activity;
        this.mModel = new LoginModel(activity);
    }

    public void handleLogin(TextInputEditText etUsername, TextInputEditText etPassword){

        String username = etUsername.getEditableText().toString().trim();
        String password = etPassword.getEditableText().toString().trim();

        if(!username.isEmpty() && !password.isEmpty()){
            Log.i("Controller","login condition");
            mModel.processLogin(username,password);
        }

    }
}
