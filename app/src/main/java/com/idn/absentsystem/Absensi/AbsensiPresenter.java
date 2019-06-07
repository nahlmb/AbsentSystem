package com.idn.absentsystem.Absensi;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.idn.absentsystem.BaseApp;
import com.idn.absentsystem.Model.DataAbsensi;

public class AbsensiPresenter implements AbsensiContract.Presenter {
    AbsensiContract.View view;

    public AbsensiPresenter(AbsensiContract.View view) {
        this.view = view;
    }

    @Override
    public void getAbsensi(final String idAgenda) {
        AndroidNetworking.post(BaseApp.BASE_URL + "getAbsensiBySubAgenda")
                .setPriority(Priority.HIGH)
                .addBodyParameter("idAgenda", idAgenda)
                .build()
                .getAsObject(DataAbsensi.class, new ParsedRequestListener<DataAbsensi>() {

                    @Override
                    public void onResponse(DataAbsensi response) {
                        if(response.getData()==null){
                            view.showAbsensiFailed();
                        }

                        view.showAbsensiSucces();
                        view.showAbsensi(response.getData());
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }
}
