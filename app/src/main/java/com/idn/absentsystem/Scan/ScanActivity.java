package com.idn.absentsystem.Scan;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.google.gson.JsonObject;
import com.idn.absentsystem.ApaActivity;
import com.idn.absentsystem.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class ScanActivity extends AppCompatActivity implements ScanContract.View, QRCodeReaderView.OnQRCodeReadListener {
    QRCodeReaderView qrView;
    ScanPresenter presenter = new ScanPresenter(this);
    private static final int RC_CAMERA = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        qrView = findViewById(R.id.qr_view);
        qrView = (QRCodeReaderView) findViewById(R.id.qr_view);

        qrView.setAutofocusInterval(2000L);
        qrView.setOnQRCodeReadListener(this);
        qrView.setBackCamera();

    }

    @Override
    protected void onResume() {
        super.onResume();
        qrView.startCamera();
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        Toast.makeText(this, "Terdeteksi", Toast.LENGTH_SHORT).show();

        try {
            JSONObject jsonObject = new JSONObject(text);
            final String namaSiswa = jsonObject.getString("nama_siswa");
            final String idAgenda = getIntent().getStringExtra("idAgenda");
            showAlertBuilder(namaSiswa, idAgenda);
            qrView.stopCamera();




        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "sedand scan " + e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("scan", e.toString());

        }



    }

    @Override
    public void insertSucces(String idAgenda, String namaSiswa) {
        Toast.makeText(this, "berhasil", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void insertGagal() {
        Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showAlertBuilder(final String namaSiswa, final String idAgenda) {
        final AlertDialog.Builder alertB = new AlertDialog.Builder(ScanActivity.this);
        alertB.setTitle("Scan berhasil")
                .setMessage(namaSiswa + "di-absen di : " + idAgenda)
                .setPositiveButton("Tambah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.insertAbsen(idAgenda, namaSiswa);
                        finish();


                    }
                }).setNegativeButton("batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                qrView.startCamera();


            }
        }).setNeutralButton("tambah dan scan lagi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.insertAbsen(idAgenda, namaSiswa);
                qrView.startCamera();
                dialog.dismiss();



            }
        }).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        qrView.stopCamera();
    }
}
