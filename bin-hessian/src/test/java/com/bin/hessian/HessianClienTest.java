package com.bin.hessian;

import com.alibaba.fastjson.JSON;
import com.bin.api.dto.UserDto;
import com.bin.api.facade.UserFacade;
import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

/**
 * Created by xiaobin on 2017/1/8.
 */
public class HessianClienTest {

        public static void main(String[] args) throws MalformedURLException {

            String url = "http://localhost:8081/bin-hessian/api/user";

            HessianProxyFactory factory = new HessianProxyFactory();
            UserFacade api = (UserFacade) factory.create(UserFacade.class, url);
            UserDto userDto = api.login("name1", "123");
            System.out.println("请求成功：" + JSON.toJSONString(userDto));

        }

}
