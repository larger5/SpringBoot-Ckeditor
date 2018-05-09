package com.cun.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_diary")
@Entity
public class Diary {
	public Diary(String dateToString, Integer diaryCount) {
		super();
		this.dateToString = dateToString;
		this.diaryCount = diaryCount;
	}

	public Integer getDiaryCount() {
		return diaryCount;
	}

	public void setDiaryCount(Integer diaryCount) {
		this.diaryCount = diaryCount;
	}

	public String getDateToString() {
		return dateToString;
	}

	public void setDateToString(String dateToString) {
		this.dateToString = dateToString;
	}

	public Diary() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private Integer diaryId;
	@Column(length=60)
	private String title;
	@Column(length=500)
	private String content;
	private Date releaseDate;
	@Column(length=20)
	private String dateToString;//用来存储String类型的格式化日期，注意补上getter、setter！
	private Integer typeId = -1;
	
	private Integer diaryCount; //用来显示按日期分类的专栏

	public Diary(String title, String content, int typeId) {
		super();
		this.title = title;
		this.content = content;
		this.typeId = typeId;
	}

	public Integer getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(Integer diaryId) {
		this.diaryId = diaryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}
