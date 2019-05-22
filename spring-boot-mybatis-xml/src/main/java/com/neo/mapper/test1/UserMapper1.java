package com.neo.mapper.test1;

import java.util.List;

import com.neo.entity.UserEntity;

public interface UserMapper1 {
	
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}