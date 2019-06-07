package com.idn.absentsystem.ListCategoryAgenda;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.idn.absentsystem.Model.DataCategory;
import com.idn.absentsystem.R;

import java.util.List;

public class RvAdapterListCategory extends RecyclerView.Adapter<RvAdapterListCategory.ViewHolder> {
    List<DataCategory.DataItem> listData;
    ListCategoryPresenter presenter;

    public RvAdapterListCategory(List<DataCategory.DataItem> listData, ListCategoryPresenter presenter) {
        this.listData = listData;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_list_category, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int posision) {
        viewHolder.categoryAgendaName.setText(listData.get(posision).getNamaCategory());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToDetailListCategory(listData.get(posision).getIdCategoryAgenda(), listData.get(posision).getNamaCategory());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBackCategory;
        TextView categoryAgendaName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.categoryAgendaName = itemView.findViewById(R.id.txt_category_agenda_name);
            this.imgBackCategory = itemView.findViewById(R.id.img_back_item_view);
        }
    }
}
