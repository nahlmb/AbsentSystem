package com.idn.absentsystem.Login;

import android.util.Log;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.idn.absentsystem.BaseApp;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPresenter implements LoginContract.Presenter {
    LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void requestLogin(String email, String password) {
//        AndroidNetworking.post(BaseApp.BASE_URL + "LoginGuru")
//                .setPriority(Priority.HIGH)
//                .addBodyParameter("emailGuru", email)
//                .addBodyParameter("passwordGuru", password)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        view.loginGagal();
//                        try {
//
//                            if(response.getBoolean("status")){
//                                view.loginSukses();
//
//                            }else {
//                                view.loginGagal();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            view.loginGagal();
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//
//                    }
//                });

        AndroidNetworking.post(BaseApp.BASE_URL + "LoginGuru")
                .setPriority(Priority.HIGH)
                .addBodyParameter("emailGuru", email)
                .addBodyParameter("passwordGuru", password)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.getBoolean("status")){
                                view.loginSukses(response.getJSONObject("data").getString("id_guru"));
                            }else {
//                                view.loginGagal();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            view.loginGagal();
                            Log.d("coba", e.toString());
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

    @Override
    public void loginClicked(EditText email, EditText password) {
        view.showToastLoginin("sedang login");

    }
}
