package com.cun.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cun.bean.Diary;

public interface DiaryDao extends JpaRepository<Diary, Integer> {

	/**
	 * ①注意 Diary 实体中的属性一个也不能少 ，使用 SpringBoot 的麻烦之处
	 * ② nativeQuery=true加上才是 sql，否则默认为 hql
	 * ③在sql中格式化日期，不用在Controller中格式化了！
	 * 
	 * @return
	 */
	@Query(value = "SELECT diary_id,title,content,release_date,type_id,diary_count,DATE_FORMAT(release_date,'%y年%m月%d日')AS date_to_string FROM t_diary", nativeQuery = true)
	public List<Diary> getFormateDiary();

	@Query(value = "SELECT diary_id,type_id,content,title,release_date,DATE_FORMAT(release_date,'%Y年%m月') AS date_to_string ,COUNT(*) AS diary_count  FROM t_diary GROUP BY DATE_FORMAT(release_date,'%Y年%m月') ORDER BY DATE_FORMAT(release_date,'%Y年%m月') DESC;", nativeQuery = true)
	public List<Diary> getDateType();
}
