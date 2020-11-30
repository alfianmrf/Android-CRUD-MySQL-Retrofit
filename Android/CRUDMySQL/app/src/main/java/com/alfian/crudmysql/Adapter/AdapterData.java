package com.alfian.crudmysql.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.alfian.crudmysql.API.APIRequestData;
import com.alfian.crudmysql.API.RetroServer;
import com.alfian.crudmysql.Activity.MainActivity;
import com.alfian.crudmysql.Activity.TambahActivity;
import com.alfian.crudmysql.Activity.UpdateActivity;
import com.alfian.crudmysql.Model.DataModel;
import com.alfian.crudmysql.Model.ResponseModel;
import com.alfian.crudmysql.R;
import com.google.android.material.transition.Hold;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private List<DataModel> listData;
    private int idMahasiswa;
    private String nimMahasiswa, namaMahasiswa, prodiMahasiswa;

    public AdapterData(Context ctx, List<DataModel> listData) {
        this.ctx = ctx;
        this.listData = listData;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listData.get(position);

        holder.tvId.setText(String.valueOf(dm.getId()));
        holder.tvNim.setText(dm.getNim());
        holder.tvNama.setText(dm.getNama());
        holder.tvProdi.setText(dm.getProdi());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView tvId, tvNim, tvNama, tvProdi;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvNim = itemView.findViewById(R.id.tv_nim);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvProdi = itemView.findViewById(R.id.tv_prodi);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    AlertDialog.Builder dialogPesan = new AlertDialog.Builder(ctx);
                    dialogPesan.setMessage("Pilih Operasi yang Akan Dilakukan");
                    dialogPesan.setCancelable(true);

                    idMahasiswa = Integer.parseInt(tvId.getText().toString());
                    nimMahasiswa = tvNim.getText().toString();
                    namaMahasiswa = tvNama.getText().toString();
                    prodiMahasiswa = tvProdi.getText().toString();

                    dialogPesan.setPositiveButton("Hapus", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteData();
                            dialogInterface.dismiss();
                            ((MainActivity) ctx).retrieveData();
                        }
                    });

                    dialogPesan.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(ctx, UpdateActivity.class);
                            intent.putExtra("id", idMahasiswa);
                            intent.putExtra("nim", nimMahasiswa);
                            intent.putExtra("nama", namaMahasiswa);
                            intent.putExtra("prodi", prodiMahasiswa);
                            ctx.startActivity(intent);
                        }
                    });

                    dialogPesan.show();

                    return false;
                }
            });
        }

        private void deleteData(){
            APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
            Call<ResponseModel> hapusData = ardData.ardDeleteData(idMahasiswa);

            hapusData.enqueue(new Callback<ResponseModel>() {
                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                    Toast.makeText(ctx, "Berhasil dihapus", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {
                    Toast.makeText(ctx, "Gagal Menghubungi Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
