package com.idn.absentsystem.Login;

import android.widget.EditText;

public interface LoginContract {
    interface View {
        void showToastLoginin(String toast);
        void showToastFormNotValid();
        void loginSukses(String idGuru);
        void loginGagal();


    }

    interface Presenter {
        void requestLogin(String email, String password);
        void loginClicked(EditText email, EditText password);
    }


}
