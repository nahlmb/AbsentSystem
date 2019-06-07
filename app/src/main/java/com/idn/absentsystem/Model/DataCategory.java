package com.idn.absentsystem.Model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataCategory{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private boolean status;

	public String getPesan(){
		return pesan;
	}

	public List<DataItem> getData(){
		return data;
	}

	public boolean isStatus(){
		return status;
	}

	public class DataItem implements Serializable {

		@SerializedName("id_category_agenda")
		private String idCategoryAgenda;

		@SerializedName("id_guru")
		private String idGuru;

		@SerializedName("nama_category")
		private String namaCategory;

		public String getIdCategoryAgenda(){
			return idCategoryAgenda;
		}

		public String getIdGuru(){
			return idGuru;
		}

		public String getNamaCategory(){
			return namaCategory;
		}
	}
}