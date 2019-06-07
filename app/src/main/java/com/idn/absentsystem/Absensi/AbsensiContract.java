package com.idn.absentsystem.Absensi;

import com.idn.absentsystem.Model.DataAbsensi;

import java.util.List;

public interface AbsensiContract {
    interface View{
        void showAbsensi(List<DataAbsensi.DataItem> listDataAbsensi);
        void showAbsensiSucces();
        void showAbsensiFailed();

    }

    interface Presenter{
        void getAbsensi(String idAgenda);



    }
}
