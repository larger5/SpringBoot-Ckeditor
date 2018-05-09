package com.cun.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_diarytype")
public class DiaryType {

	@Id
	@GeneratedValue
	private int diaryTypeId;
	@Column(length=30)
	private String typeName;
	private int diaryCount;
	
	
	
	public DiaryType(String typeName) {
		super();
		this.typeName = typeName;
	}
	public DiaryType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDiaryTypeId() {
		return diaryTypeId;
	}
	public void setDiaryTypeId(int diaryTypeId) {
		this.diaryTypeId = diaryTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getDiaryCount() {
		return diaryCount;
	}
	public void setDiaryCount(int diaryCount) {
		this.diaryCount = diaryCount;
	}
	
	
}
