package com.idn.absentsystem.Model;

import com.google.gson.annotations.SerializedName;

public class DataGuru{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private boolean status;



	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public class Data{

		@SerializedName("password_guru")
		private String passwordGuru;

		@SerializedName("nama_depan_guru")
		private String namaDepanGuru;

		@SerializedName("status_guru")
		private String statusGuru;

		@SerializedName("email_guru")
		private String emailGuru;

		@SerializedName("id_guru")
		private String idGuru;

		@SerializedName("nama_belakang_guru")
		private String namaBelakangGuru;

		public void setPasswordGuru(String passwordGuru){
			this.passwordGuru = passwordGuru;
		}

		public String getPasswordGuru(){
			return passwordGuru;
		}

		public void setNamaDepanGuru(String namaDepanGuru){
			this.namaDepanGuru = namaDepanGuru;
		}

		public String getNamaDepanGuru(){
			return namaDepanGuru;
		}

		public void setStatusGuru(String statusGuru){
			this.statusGuru = statusGuru;
		}

		public String getStatusGuru(){
			return statusGuru;
		}

		public void setEmailGuru(String emailGuru){
			this.emailGuru = emailGuru;
		}

		public String getEmailGuru(){
			return emailGuru;
		}

		public void setIdGuru(String idGuru){
			this.idGuru = idGuru;
		}

		public String getIdGuru(){
			return idGuru;
		}

		public void setNamaBelakangGuru(String namaBelakangGuru){
			this.namaBelakangGuru = namaBelakangGuru;
		}

		public String getNamaBelakangGuru(){
			return namaBelakangGuru;
		}
	}
}