package com.idn.absentsystem.Main;

public interface MainContract {
    interface View {
        void goToListCategory(String idGuru);
        void getInformasiGuru(String idGuru, String namaDepanGuru, String namaBelakangGuru, String statusGuru);
        void getInformasiGuruSucces();
        void getInformasiGuruFailed();


    }

    interface Presenter {
        void getInformasiGuru(String idGuru);
        void goToListCategory(String idGuru);

    }
}
