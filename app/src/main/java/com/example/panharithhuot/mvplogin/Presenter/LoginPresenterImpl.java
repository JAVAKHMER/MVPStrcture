package com.example.panharithhuot.mvplogin.Presenter;

import com.example.panharithhuot.mvplogin.Interator.LoginInteractorImpl;
import com.example.panharithhuot.mvplogin.Interface.LoginInterator;
import com.example.panharithhuot.mvplogin.Interface.LoginPresenter;
import com.example.panharithhuot.mvplogin.Interface.LoginView;
import com.example.panharithhuot.mvplogin.Interface.OnLoginFinisListener;

/**
 * Created by panharithhuot on 6/29/17.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinisListener {
    private LoginView loginView;
    private LoginInterator loginInterator;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInterator = new LoginInteractorImpl();
    }


    @Override
    public void validateCredential(String userName, String password) {
        if (null != loginView) {
            loginView.showProgress();
        }

        loginInterator.login(userName, password, this);

    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUserNameError() {
        if (null != loginView) {
            loginView.setUserNameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (null != loginView) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (null != loginView) {
            loginView.navigateToHome();
            loginView.hideProgress();
        }
    }
}
