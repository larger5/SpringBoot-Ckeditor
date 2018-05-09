package com.cun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cun.bean.User;

public interface UserDao extends JpaRepository<User, Integer> {

	// 注意想使用自定义的sql语句，得设置 nativeQuery = true
	@Query(value = "select * from t_user where user_name=?1 and password=?2", nativeQuery = true)
	public User login(String userName, String password);
}
