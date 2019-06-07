package com.idn.absentsystem.ListCategoryAgenda;

import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.idn.absentsystem.BaseApp;
import com.idn.absentsystem.Model.DataCategory;

import org.json.JSONArray;

public class ListCategoryPresenter implements ListCategoryContract.Presenter {
    ListCategoryContract.View view;
    DataCategory.DataItem dataItem;

    public ListCategoryPresenter(ListCategoryContract.View view) {
        this.view = view;
    }

    @Override
    public void getListCategory() {

        AndroidNetworking.post(BaseApp.BASE_URL + "getCategoryAgendaByIdGuru")
                .setPriority(Priority.HIGH)
                .addBodyParameter("idGuru", "1")
                .build()
                .getAsObject(DataCategory.class, new ParsedRequestListener<DataCategory>() {

                    @Override
                    public void onResponse(DataCategory response) {
                       if(response.getData() == null){
                           view.dataIsNull();

                       }

                       view.showListCategory(response.getData());

                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

        //yop

    }

    @Override
    public void goToDetailListCategory(String idCategory, String namaCategory) {
        view.goToDetailListCategory(idCategory, namaCategory);

    }



}
