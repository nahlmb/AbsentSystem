package com.idn.absentsystem.Absensi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idn.absentsystem.Model.DataAbsensi;
import com.idn.absentsystem.R;

import java.util.List;

public class RvAdapterAbsensi extends RecyclerView.Adapter<RvAdapterAbsensi.ViewHolder> {
    List<DataAbsensi.DataItem> listDataAbsensi;
    AbsensiPresenter presenter;

    public RvAdapterAbsensi(List<DataAbsensi.DataItem> listDataAbsensi, AbsensiPresenter presenter) {
        this.listDataAbsensi = listDataAbsensi;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_absensi, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posision) {
        viewHolder.txtJamHadir.setText(listDataAbsensi.get(posision).getWaktuAbsen());
        viewHolder.txtNamaSiswa.setText(listDataAbsensi.get(posision).getNamaSiswa());
    }

    @Override
    public int getItemCount() {
        return listDataAbsensi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNamaSiswa, txtJamHadir;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNamaSiswa = itemView.findViewById(R.id.txt_nama_siswa);
            txtJamHadir = itemView.findViewById(R.id.txt_jam_hadir);


        }
    }
}
