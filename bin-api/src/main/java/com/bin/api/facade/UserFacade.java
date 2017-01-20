package com.bin.api.facade;

import com.bin.api.dto.UserDto;

/**
 * Created by xiaobin on 2017/1/8.
 */
public interface UserFacade {

    public UserDto login(String userName,String password);

    void registUser(UserDto userDto);
}
