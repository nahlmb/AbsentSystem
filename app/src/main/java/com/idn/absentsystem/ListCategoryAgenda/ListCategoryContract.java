package com.idn.absentsystem.ListCategoryAgenda;

import com.idn.absentsystem.Model.DataCategory;

import java.util.List;

public interface ListCategoryContract {
    interface Presenter{
        //get List
        void getListCategory();

        //pergi ke detail
        void goToDetailListCategory(String idCategory, String namaCategory);

    }

    interface View {
        //menampilkan list
        void showListCategory(List<DataCategory.DataItem> listCategory);

        //pergi ke detail
        void goToDetailListCategory(String idCategory, String namaCategory);

        void dataIsNull();


    }
}
