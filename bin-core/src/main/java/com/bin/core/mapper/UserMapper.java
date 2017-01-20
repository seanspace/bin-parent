package com.bin.core.mapper;


import com.bin.core.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {
	void save(User user);
	void update(User user);
	void delete(int id);
	User findById(int id);
	List<User> findAll();
}
