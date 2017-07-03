package com.example.panharithhuot.mvplogin.Interface;

/**
 * Created by panharithhuot on 6/29/17.
 */

public interface LoginPresenter {
    void validateCredential(String userName, String password);
    void onDestroy();
}
