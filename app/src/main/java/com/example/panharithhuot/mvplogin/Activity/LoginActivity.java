package com.example.panharithhuot.mvplogin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.panharithhuot.mvplogin.Interface.LoginPresenter;
import com.example.panharithhuot.mvplogin.Interface.LoginView;
import com.example.panharithhuot.mvplogin.Presenter.LoginPresenterImpl;
import com.example.panharithhuot.mvplogin.R;

/**
 * Created by panharithhuot on 6/29/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private LoginPresenter presenter;
    private ProgressBar progressBar;
    private EditText userName;
    private EditText password;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar) this.findViewById(R.id.progress);
        userName = (EditText) this.findViewById(R.id.username);
        password = (EditText) this.findViewById(R.id.password);
        submit = (Button)findViewById(R.id.button);
        submit.setOnClickListener(this);
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
userName.setError("User Name Error");
    }

    @Override
    public void setPasswordError() {
password.setError("Invalid Password");
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        presenter.validateCredential(userName.getText().toString(),password.getText().toString());
    }
}
