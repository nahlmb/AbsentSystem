package com.idn.absentsystem.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataSubCategory{

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

		@SerializedName("id_category_agenda")
		private String idCategoryAgenda;

		@SerializedName("id_agenda")
		private String idAgenda;

		public void setIdCategoryAgenda(String idCategoryAgenda){
			this.idCategoryAgenda = idCategoryAgenda;
		}

		public String getIdCategoryAgenda(){
			return idCategoryAgenda;
		}

		public void setIdAgenda(String idAgenda){
			this.idAgenda = idAgenda;
		}

		public String getIdAgenda(){
			return idAgenda;
		}
	}
}