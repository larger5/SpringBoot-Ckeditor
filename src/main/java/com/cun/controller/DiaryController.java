package com.cun.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cun.bean.Diary;
import com.cun.dao.DiaryDao;

@Controller
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	private DiaryDao diaryDao;

	/**
	 * ckeditor写入测试成功
	 * @param content
	 * @param title
	 */
	@ResponseBody
	@RequestMapping("/sub")
	public void sub(String content, String title) {
		Diary diary = new Diary();
		diary.setTitle(title);
		diary.setContent(content);
		Date date = new Date();
		diary.setReleaseDate(date);
		diary.setDiaryCount(1);// SpringBoot 数据库输入输出每一个属性都不能落下，这是最坑的。
		diaryDao.save(diary);
	}

	/**
	 * ckeditor读取测试成功
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/get/{id}")
	public String getText(@PathVariable("id") Integer id) {
		return diaryDao.findOne(id).getContent();
	}

	/**
	 * 主页显示所有博文
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getall")
	public List<Diary> getAll() {
		return diaryDao.getFormateDiary();
	}

	/**
	 * 主页右边博文按日期分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getdate")
	public List<Diary> getDate() {
		return diaryDao.getDateType();
	}

	/**
	 * 根据id删除博文
	 * @param id
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public void deleteDiary(Integer id) {
		diaryDao.delete(id);
	}

}
