package com.bin.hessian.facade.impl;

import com.bin.api.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * http://localhost:8081/bin-hessian/remote/api/userFacade
 * Created by xiaobin on 2017/1/8.
 */
public class UserFacadeImpl implements com.bin.api.facade.UserFacade {
    private static final Logger logger = LoggerFactory.getLogger(UserFacadeImpl.class);


    @Override
    public UserDto login(String userName, String password) {
        logger.info("收到请求：{}，{}",userName,password);
        UserDto userDto = new UserDto();
        userDto.setName("zhangsan");
        userDto.setAge(19);
        return userDto;
    }
}
