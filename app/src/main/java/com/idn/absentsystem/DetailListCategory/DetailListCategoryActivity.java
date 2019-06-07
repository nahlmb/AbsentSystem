package com.idn.absentsystem.DetailListCategory;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.idn.absentsystem.Absensi.AbsensiActivity;
import com.idn.absentsystem.ListCategoryAgenda.RvAdapterListCategory;
import com.idn.absentsystem.Model.DataCategory;
import com.idn.absentsystem.Model.DataSubCategory;
import com.idn.absentsystem.R;
import com.idn.absentsystem.Scan.ScanActivity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class DetailListCategoryActivity extends AppCompatActivity implements DetailListCategoryContract.View, EasyPermissions.PermissionCallbacks {
    DetailListCategoryPresenter presenter = new DetailListCategoryPresenter(this);
    Button btnTambahSubAgenda;

    RvAdapterDetailListCategory rvAdapterDetailListCategory;
    RecyclerView recyclerView;
    private static final int RC_CAMERA = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        final String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        super.onCreate(savedInstanceState);
        final String idCategory = getIntent().getStringExtra("idCategory");
        final String namaCategory = getIntent().getStringExtra("namaCategory");

        setContentView(R.layout.activity_detail_list_category);
        final String idAgenda = namaCategory + " " + currentDate;
        presenter.getSubAgendaByCategory(idCategory);


        recyclerView = findViewById(R.id.rv_sub_category);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);






        btnTambahSubAgenda = findViewById(R.id.btn_tambah_absen);
        btnTambahSubAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCameraPermission();
                insertSubCategory(idCategory, idAgenda);
                goToScan(idAgenda);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        final String idCategory = getIntent().getStringExtra("idCategory");
        final String namaCategory = getIntent().getStringExtra("namaCategory");


        presenter.getSubAgendaByCategory(idCategory);
    }

    private void izin() {

    }

    @AfterPermissionGranted(RC_CAMERA)
    private void checkCameraPermission() {
        // cek permission
        String perm = Manifest.permission.CAMERA;

        if (EasyPermissions.hasPermissions(this, perm)) {
            // sudah pnya permission
            Toast.makeText(this, "diIzinkan", Toast.LENGTH_SHORT).show();
        } else {
            EasyPermissions.requestPermissions(this, "Butuh permission camera", RC_CAMERA, perm);
        }
    }


    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                                     @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        for (String permission : perms) {
            if (permission.equals(Manifest.permission.CAMERA)) {
                // check jika permission granted
                Toast.makeText(this, "dizinkan", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void showSubAgendaByCategory(List<DataSubCategory.DataItem> listSubCategory) {
        if(listSubCategory != null && listSubCategory.size()>0){
            rvAdapterDetailListCategory = new RvAdapterDetailListCategory(listSubCategory,presenter);
            recyclerView.setAdapter(rvAdapterDetailListCategory);
        }else {
            Toast.makeText(this, "Data Kosong", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void insertSubCategorySucces(String idAgenda) {
        //todo intent

    }

    @Override
    public void insertSubCategoryFailed(String idAgenda) {
        //todo intent

    }

    @Override
    public void insertSubCategory(String idCategoryAgenda, String idAgenda) {
        Toast.makeText(this, idAgenda, Toast.LENGTH_SHORT).show();
        presenter.insertSubCategory(idCategoryAgenda, idAgenda);

    }

    @Override
    public void dataIsNull() {
        Toast.makeText(this, "tidak ada data", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void goToScan(String idAgenda) {
        Intent goToScan = new Intent(DetailListCategoryActivity.this, ScanActivity.class);
        goToScan.putExtra("idAgenda", idAgenda);
        startActivity(goToScan);

    }

    @Override
    public void tampilkanToastError() {
        Toast.makeText(this, "Maaf.. hackaton nya terlalu cepat berlalu...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void goToAbsensi(String idAbsensi) {
        Intent goToAbsensi = new Intent(DetailListCategoryActivity.this, AbsensiActivity.class);
        goToAbsensi.putExtra("idAbsensi", idAbsensi);
        startActivity(goToAbsensi);

    }
}
