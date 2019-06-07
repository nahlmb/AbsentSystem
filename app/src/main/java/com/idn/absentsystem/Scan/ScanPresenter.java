package com.idn.absentsystem.Scan;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.idn.absentsystem.BaseApp;

import org.json.JSONException;
import org.json.JSONObject;

public class ScanPresenter implements ScanContract.Presenter {
    ScanContract.View view;

    public ScanPresenter(ScanContract.View view) {
        this.view = view;
    }

    @Override
    public void insertAbsen(final String idAgenda, final String namaSiswa) {
        AndroidNetworking.post(BaseApp.BASE_URL + "insertAbsensiBySubAgenda")
                .setPriority(Priority.HIGH)
                .addBodyParameter("idAgenda", idAgenda)
                .addBodyParameter("namaSiswa", namaSiswa)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.getBoolean("status")){
                                view.insertSucces(idAgenda, namaSiswa);
                            }else {
                                view.insertGagal();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            view.insertGagal();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        view.insertGagal();


                    }
                });

    }
}
