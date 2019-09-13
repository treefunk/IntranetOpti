package com.myoptimind.intranet.main.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.myoptimind.intranet.BaseActivity;
import com.myoptimind.intranet.R;
import com.myoptimind.intranet.main.controller.LoginController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button btnLogin;
    private TextInputEditText etUsername,etPassword;
    private LoginController mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        mController = new LoginController(this);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_login:
                Log.i("Loginbutton ","pressed");
                mController.handleLogin(etUsername,etPassword);
                break;
        }
    }
}
