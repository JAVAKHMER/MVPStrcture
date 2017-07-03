package com.example.panharithhuot.mvplogin.Interface;

/**
 * Created by panharithhuot on 6/29/17.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPasswordError();
    void navigateToHome();
}
