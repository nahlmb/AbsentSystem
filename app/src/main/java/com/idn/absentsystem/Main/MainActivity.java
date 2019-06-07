package com.idn.absentsystem.Main;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.idn.absentsystem.ListCategoryAgenda.ListCategoryAgendaActivity;
import com.idn.absentsystem.ListCategoryAgenda.ListCategoryPresenter;
import com.idn.absentsystem.Model.DataGuru;
import com.idn.absentsystem.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    MainPresenter presenter = new MainPresenter(this);

    ImageView listAbsen, imgTengah, imgKiri;
    TextView txtNamaProfil, txtJam, txtTanggal, txtStatusGuru;
    ConstraintLayout consDashBoard;
    List<DataGuru.Data> dataGuru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAbsen = findViewById(R.id.img_btn_list_absen);
        imgTengah = findViewById(R.id.img_tengah);
        imgKiri = findViewById(R.id.img_kiri);
        consDashBoard = findViewById(R.id.cons_dashboard);
        txtJam = findViewById(R.id.txt_jam);
        txtTanggal = findViewById(R.id.txt_tanggal);

        presenter.getInformasiGuru(getIntent().getStringExtra("idGuru"));

        Calendar calendar = Calendar.getInstance();
        String tanggal = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        Calendar c = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        String formattedDate = df.format(c.getTime());
// Now formattedDate have current date/time
        String jam = formattedDate;
        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();

        txtJam.setText(jam);
        txtTanggal.setText(tanggal);

        txtNamaProfil = findViewById(R.id.txt_nama_guru_dash);
        txtStatusGuru = findViewById(R.id.txt_status_guru);


        listAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToListCategory(getIntent().getStringExtra("idGuru"));
            }
        });

        imgTengah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Belum bisa diakses, Klik Button paling kiri", Toast.LENGTH_SHORT).show();
            }
        });

        imgKiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Belum bisa diakses, Klik Button paling kiri", Toast.LENGTH_SHORT).show();
            }
        });

        consDashBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ini dashboard nantinya..", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void goToListCategory(String idGuru) {
        Intent goToCategoryAgenda = new Intent(MainActivity.this, ListCategoryAgendaActivity.class);
        startActivity(goToCategoryAgenda);

    }

    @Override
    public void getInformasiGuru(String idGuru, String namaDepanGuru, String namaBelakangGuru, String statusGuru) {
        txtNamaProfil.setText(namaDepanGuru + " : )");
        if(statusGuru != null){
            txtStatusGuru.setText("\"" + statusGuru + "\"");
        }


    }

    @Override
    public void getInformasiGuruSucces() {
        Toast.makeText(this, "Selamat datang", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void getInformasiGuruFailed() {
        Toast.makeText(this, "gagal mendapat data guru", Toast.LENGTH_SHORT).show();

    }

}
