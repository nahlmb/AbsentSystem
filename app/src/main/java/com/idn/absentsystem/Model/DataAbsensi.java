package com.idn.absentsystem.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataAbsensi{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private boolean status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public class DataItem{

		@SerializedName("nama_siswa")
		private String namaSiswa;

		@SerializedName("id_absensi")
		private String idAbsensi;

		@SerializedName("id_agenda")
		private String idAgenda;

		@SerializedName("waktu_absen")
		private String waktuAbsen;

		public void setNamaSiswa(String namaSiswa){
			this.namaSiswa = namaSiswa;
		}

		public String getNamaSiswa(){
			return namaSiswa;
		}

		public void setIdAbsensi(String idAbsensi){
			this.idAbsensi = idAbsensi;
		}

		public String getIdAbsensi(){
			return idAbsensi;
		}

		public void setIdAgenda(String idAgenda){
			this.idAgenda = idAgenda;
		}

		public String getIdAgenda(){
			return idAgenda;
		}

		public void setWaktuAbsen(String waktuAbsen){
			this.waktuAbsen = waktuAbsen;
		}

		public String getWaktuAbsen(){
			return waktuAbsen;
		}
	}


}