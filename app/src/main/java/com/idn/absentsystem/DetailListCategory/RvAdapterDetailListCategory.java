package com.idn.absentsystem.DetailListCategory;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.idn.absentsystem.Model.DataSubCategory;
import com.idn.absentsystem.R;

import java.util.List;

public class RvAdapterDetailListCategory extends RecyclerView.Adapter<RvAdapterDetailListCategory.ViewHolder> {
    List<DataSubCategory.DataItem> listDataSub;
    DetailListCategoryPresenter presenter;

    public RvAdapterDetailListCategory(List<DataSubCategory.DataItem> listDataSub, DetailListCategoryPresenter presenter) {
        this.listDataSub = listDataSub;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_sub_category, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int posision) {
        viewHolder.txtDateSubCategory.setText(listDataSub.get(posision).getIdAgenda());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToAbsensi(listDataSub.get(posision).getIdAgenda());



            }
        });

    }

    @Override
    public int getItemCount() {

        return listDataSub.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDateSubCategory;
        Button btnTambahSubCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDateSubCategory = itemView.findViewById(R.id.txt_date);
            btnTambahSubCategory = itemView.findViewById(R.id.btn_tambah_absen);

        }
    }
}
