package com.bin.core.service.impl;

import com.bin.core.entity.User;
import com.bin.core.mapper.UserMapper;
import com.bin.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaobin on 2017/1/20.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void createOrUpdate(User user) {
        if (user.getId() != 0) {
            userMapper.update(user);
        } else {
            userMapper.save(user);
        }
    }
}
