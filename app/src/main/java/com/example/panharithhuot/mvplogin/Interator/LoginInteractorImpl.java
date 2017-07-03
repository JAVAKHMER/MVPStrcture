package com.example.panharithhuot.mvplogin.Interator;

import android.os.Handler;
import android.text.TextUtils;

import com.example.panharithhuot.mvplogin.Interface.LoginInterator;
import com.example.panharithhuot.mvplogin.Interface.OnLoginFinisListener;

/**
 * Created by panharithhuot on 6/29/17.
 */

public class LoginInteractorImpl implements LoginInterator {
    @Override
    public void login(final String userName, final String password, final OnLoginFinisListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(userName)){
                    listener.onUserNameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
