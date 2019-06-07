package com.idn.absentsystem.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.idn.absentsystem.Main.MainActivity;
import com.idn.absentsystem.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    LoginPresenter presenter = new LoginPresenter(this);
    EditText edtEmailGuru, edtPasswordGuru;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        edtEmailGuru = findViewById(R.id.edt_email_guru);
        edtPasswordGuru = findViewById(R.id.edt_password_guru);
        btnLogin = findViewById(R.id.btn_log_in_guru);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "sedang login", Toast.LENGTH_SHORT).show();
                presenter.requestLogin(edtEmailGuru.getText().toString(), edtPasswordGuru.getText().toString());

            }
        });


    }


    @Override
    public void showToastLoginin(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        presenter.requestLogin(edtEmailGuru.getText().toString(), edtPasswordGuru.getText().toString());

    }

    @Override
    public void showToastFormNotValid() {

    }

    @Override
    public void loginSukses(String idGuru) {
        Toast.makeText(this, "sukses", Toast.LENGTH_SHORT).show();
        Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
        toMain.putExtra("idGuru", idGuru);
        startActivity(toMain);

    }

    @Override
    public void loginGagal() {
        Toast.makeText(this, "Apa! gak bisa neh..", Toast.LENGTH_SHORT).show();

    }
}
