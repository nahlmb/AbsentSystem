package com.idn.absentsystem.DetailListCategory;

import com.idn.absentsystem.Model.DataCategory;
import com.idn.absentsystem.Model.DataSubCategory;

import java.util.List;

public interface DetailListCategoryContract {
    interface Presenter{
        void getSubAgendaByCategory(String idCategory);
        void insertSubCategory(String idCategoryAgenda, String idAgenda);
        void tampilkanToastError();
        void goToAbsensi(String idAbsensi);

    }

    interface View{
        void showSubAgendaByCategory(List<DataSubCategory.DataItem> listSubCategory);
        void insertSubCategorySucces(String idAgenda);
        void insertSubCategoryFailed(String idAgenda);
        void insertSubCategory(String idCategoryAgenda, String idAgenda);
        void dataIsNull();
        void goToScan(String idAgenda);
        void tampilkanToastError();
        void goToAbsensi(String idAbsensi);


    }
}
