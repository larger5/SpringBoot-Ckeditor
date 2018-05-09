package com.cun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cun.bean.DiaryType;
import com.cun.dao.DiaryTypeDao;

@Controller
@RequestMapping("/diarytype")
public class DiaryTypeController {

	@Autowired
	private DiaryTypeDao diaryTypeDao;

	/**
	 * 主页右边博文类别、数量显示
	 * @return
	 */
	@ResponseBody
	@RequestMapping("typeandcount")
	public List<DiaryType> getAllDiaryTypeAndCount() {
		return diaryTypeDao.getAllDiaryTypeAndCount();
	}

}
