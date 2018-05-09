package com.cun.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cun.bean.DiaryType;

public interface DiaryTypeDao extends JpaRepository<DiaryType, Integer> {

	@Query(value = "SELECT diary_type_id,type_name,COUNT(diary_id) AS diary_count FROM t_diary RIGHT JOIN t_diarytype ON t_diary.type_id=t_diarytype.diary_type_id GROUP BY type_name;", nativeQuery = true)
	public List<DiaryType> getAllDiaryTypeAndCount();

}
