package com.bin.core.facade.impl;

import com.bin.api.dto.UserDto;
import com.bin.api.facade.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * http://localhost:8081/bin-hessian/remote/api/userFacade
 * Created by xiaobin on 2017/1/8.
 */
@Component
public class UserFacadeImpl implements UserFacade {
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
