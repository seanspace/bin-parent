package com.bin.controller;

import com.bin.api.enums.SexEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 首页
 * Created by xiaobin on 2016/9/24.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class) ;

    @RequestMapping("index")
    public String index(Map<String,Object> map) {
        logger.info("Receive Request ");
        map.put("sex", SexEnum.FEMALE);
        map.put("bool", true);
        return "demo" ;
    }
}
