package com.alfian.crudmysql.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alfian.crudmysql.API.APIRequestData;
import com.alfian.crudmysql.API.RetroServer;
import com.alfian.crudmysql.Model.ResponseModel;
import com.alfian.crudmysql.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    private EditText etNim, etNama, etProdi;
    private Button btnSimpan;
    private String nim, nama, prodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNim = findViewById(R.id.et_nim);
        etNama = findViewById(R.id.et_nama);
        etProdi = findViewById(R.id.et_prodi);
        btnSimpan = findViewById(R.id.btn_simpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nim = etNim.getText().toString();
                nama = etNama.getText().toString();
                prodi = etProdi.getText().toString();

                if (nim.trim().equals("")){
                    etNim.setError("NIM Harus Diisi");
                }
                else if(nama.trim().equals("")){
                    etNama.setError("Nama Harus Diisi");
                }
                else if(prodi.trim().equals("")){
                    etProdi.setError("Prodi Harus Diisi");
                }
                else{
                    createData();
                }
            }
        });
    }

    private void createData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> simpanData = ardData.ardCreateData(nim, nama, prodi);

        simpanData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Toast.makeText(TambahActivity.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(TambahActivity.this, "Gagal Menghubungi Server | "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}