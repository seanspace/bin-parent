package com.bin.core.facade.impl;

import com.bin.api.dto.UserDto;
import com.bin.api.facade.UserFacade;
import com.bin.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * http://localhost:8081/bin-hessian/remote/api/userFacade
 * Created by xiaobin on 2017/1/8.
 */
@Component("userFacade")
public class UserFacadeImpl implements UserFacade {
    private static final Logger logger = LoggerFactory.getLogger(UserFacadeImpl.class);
    @Autowired
    private UserService userService;


    @Override
    public UserDto login(String userName, String password) {
        UserDto userDto = new UserDto();
        userDto.setName("zhangsan");
        userDto.setAge(19);
        userService.findById(1);

        return userDto;
    }
}
