package com.idn.absentsystem.Absensi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.idn.absentsystem.Model.DataAbsensi;
import com.idn.absentsystem.R;

import java.util.List;

public class AbsensiActivity extends AppCompatActivity implements AbsensiContract.View{
    AbsensiPresenter presenter = new AbsensiPresenter(this);
    RecyclerView recyclerView;
    RvAdapterAbsensi rvAdapterAbsensi;
    List<DataAbsensi.DataItem> listDataAbsensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);

        String getIdAgenda = getIntent().getStringExtra("idAbsensi");

        recyclerView = findViewById(R.id.rv_absen);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);

        presenter.getAbsensi(getIntent().getStringExtra("idAbsensi"));
        Log.d("cek", getIdAgenda);
    }

    @Override
    public void showAbsensi(List<DataAbsensi.DataItem> listDataAbsensi) {
        if(listDataAbsensi != null && listDataAbsensi.size() > 0){

            rvAdapterAbsensi = new RvAdapterAbsensi(listDataAbsensi, presenter);
            recyclerView.setAdapter(rvAdapterAbsensi);

        }else {
            Toast.makeText(this, "data kosong", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void showAbsensiSucces() {

        Toast.makeText(this, "oke", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showAbsensiFailed() {
        Toast.makeText(this, "gak Oke", Toast.LENGTH_SHORT).show();

    }
}
