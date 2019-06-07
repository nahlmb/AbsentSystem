package com.idn.absentsystem.ListCategoryAgenda;

import android.Manifest;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.idn.absentsystem.DetailListCategory.DetailListCategoryActivity;
import com.idn.absentsystem.Main.MainActivity;
import com.idn.absentsystem.Model.DataCategory;
import com.idn.absentsystem.R;

import java.io.Serializable;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class ListCategoryAgendaActivity extends AppCompatActivity implements ListCategoryContract.View {
    ListCategoryPresenter presenter;
    RvAdapterListCategory rvAdapterListCategory;
    RecyclerView recyclerView;
    Button btnTambahSubAgenda;
    private static final int RC_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category_agenda);
        presenter = new ListCategoryPresenter(this);
        presenter.getListCategory();

        recyclerView = findViewById(R.id.rv_category_agenda);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);


    }


    @Override
    public void showListCategory(List<DataCategory.DataItem> listCategory) {
        if(listCategory != null && listCategory.size()>0){
            rvAdapterListCategory = new RvAdapterListCategory(listCategory, presenter);
            recyclerView.setAdapter(rvAdapterListCategory);
        }else {
            Toast.makeText(this, "data kosong", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void goToDetailListCategory(String idCategory, String namaCategory) {
        Intent goToSubCategory = new Intent(ListCategoryAgendaActivity.this, DetailListCategoryActivity.class);
        goToSubCategory.putExtra("idCategory", idCategory);
        goToSubCategory.putExtra("namaCategory", namaCategory);
        startActivity(goToSubCategory);
    }

    @Override
    public void dataIsNull() {

    }
}
