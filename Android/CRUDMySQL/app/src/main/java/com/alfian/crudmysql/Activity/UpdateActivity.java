package com.alfian.crudmysql.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alfian.crudmysql.API.APIRequestData;
import com.alfian.crudmysql.API.RetroServer;
import com.alfian.crudmysql.Adapter.AdapterData;
import com.alfian.crudmysql.Model.ResponseModel;
import com.alfian.crudmysql.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {

    private int idMhs;
    private String nimMhs, namaMhs, prodiMhs;

    private EditText etId, etNim, etNama, etProdi;

    private int updateId;
    private String updateNim, updateNama, updateProdi;

    private Button btnUpdate;

    private int id;
    private String nim, nama, prodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        idMhs =  getIntent().getIntExtra("id", 0);
        nimMhs = getIntent().getStringExtra("nim");
        namaMhs = getIntent().getStringExtra("nama");
        prodiMhs = getIntent().getStringExtra("prodi");

        etId = findViewById(R.id.update_id);
        etNim = findViewById(R.id.update_nim);
        etNama = findViewById(R.id.update_nama);
        etProdi = findViewById(R.id.update_prodi);
        btnUpdate = findViewById(R.id.btn_update);

        etId.setText(String.valueOf(idMhs));
        etNim.setText(nimMhs);
        etNama.setText(namaMhs);
        etProdi.setText(prodiMhs);

        updateId = Integer.parseInt(etId.getText().toString());
        updateNim = etNim.getText().toString();
        updateNama = etNama.getText().toString();
        updateProdi = etProdi.getText().toString();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = Integer.parseInt(etId.getText().toString());
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
                    updateData();
                }
            }
        });
    }

    public void updateData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ResponseModel> updateData = ardData.ardUpdateData(id, nim, nama, prodi);

        updateData.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Toast.makeText(UpdateActivity.this, "Berhasil Memperbarui Data", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(UpdateActivity.this, "Gagal Menghubungi Server | "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}