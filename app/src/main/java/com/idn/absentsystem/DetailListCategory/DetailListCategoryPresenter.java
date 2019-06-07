package com.idn.absentsystem.DetailListCategory;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.idn.absentsystem.BaseApp;
import com.idn.absentsystem.Model.DataSubCategory;

import org.json.JSONException;
import org.json.JSONObject;

public class DetailListCategoryPresenter implements DetailListCategoryContract.Presenter {
    DetailListCategoryContract.View view;

    public DetailListCategoryPresenter(DetailListCategoryContract.View view) {
        this.view = view;
    }

    @Override
    public void getSubAgendaByCategory(String idCategory) {
        AndroidNetworking.post(BaseApp.BASE_URL + "getSubAgendaByCategory")
                .setPriority(Priority.HIGH)
                .addBodyParameter("idCategoryAgenda", idCategory)
                .build()
                .getAsObject(DataSubCategory.class, new ParsedRequestListener<DataSubCategory>() {

                    @Override
                    public void onResponse(DataSubCategory response) {
                        if(response.getData() == null){
                            view.dataIsNull();

                        }
                        view.showSubAgendaByCategory(response.getData());

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

    @Override
    public void insertSubCategory(String idCategoryAgenda, final String idAgenda) {
        AndroidNetworking.post(BaseApp.BASE_URL + "insertSubAgendaByCategory")
                .addBodyParameter("idAgenda", idAgenda)
                .addBodyParameter("idCategoryAgenda",idCategoryAgenda)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.getBoolean("status")){
                                view.insertSubCategorySucces(idAgenda);
                            }else {
                                view.insertSubCategoryFailed(idAgenda);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            view.insertSubCategoryFailed(idAgenda);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

    @Override
    public void tampilkanToastError() {
        view.tampilkanToastError();

    }

    @Override
    public void goToAbsensi(String idAbsensi) {
        view.goToAbsensi(idAbsensi);

    }
}
