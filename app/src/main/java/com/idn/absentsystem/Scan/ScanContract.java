package com.idn.absentsystem.Scan;

public interface ScanContract {
    interface View {
        void insertSucces(String idAgenda, String namaSiswa);
        void insertGagal();
        void showAlertBuilder(String namaSiswa, String idAgenda);

    }

    interface Presenter {
        void insertAbsen(String idAgenda, String namaSiswa);
    }
}
