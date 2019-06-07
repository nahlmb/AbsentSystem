package com.idn.absentsystem.Main;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.idn.absentsystem.BaseApp;
import com.idn.absentsystem.Model.DataGuru;

import org.json.JSONException;
import org.json.JSONObject;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getInformasiGuru(String idGuru) {
        AndroidNetworking.post(BaseApp.BASE_URL + "getInformasiGuru")
                .setPriority(Priority.HIGH)
                .addBodyParameter("idGuru", idGuru)
                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//
//                        try {
//                            if(response.getBoolean("status")){
//                                view.getInformasiGuruSucces();
//                                String responseIdGuru = response.getJSONObject("data").getString("id_guru");
//                                String responseNamaDepanGuru = response.getJSONObject("data").getString("nama_depan_guru");
//                                String responseNamaBelakangGuru = response.getJSONObject("data").getString("nama_belakang_guru");
//                                String responseStatusGuru = response.getJSONObject("data").getString("status_guru");
//                                view.getInformasiGuru(responseIdGuru, responseNamaDepanGuru, responseNamaBelakangGuru, responseStatusGuru);
//
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Log.d("coba", e.toString());
//                        }
//
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//
//                    }
//                });
                .getAsObject(DataGuru.class, new ParsedRequestListener<DataGuru>() {

                    @Override
                    public void onResponse(DataGuru response) {
                        String responseIdGuru = response.getData().getIdGuru();
                        String responseNamaDepanGuru = response.getData().getNamaDepanGuru();
                        String responseNamaBelakangGuru = response.getData().getNamaBelakangGuru();
                        String responseStatusGuru = response.getData().getStatusGuru();


                        if(response.isStatus()){
                            view.getInformasiGuru(responseIdGuru,responseNamaDepanGuru, responseNamaBelakangGuru, responseStatusGuru);
                            view.getInformasiGuruSucces();
                        }else {
                            view.getInformasiGuruFailed();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

    @Override
    public void goToListCategory(String idGuru) {

    }
}
