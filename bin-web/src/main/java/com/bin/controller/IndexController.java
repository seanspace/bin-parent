package com.bin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页
 * Created by xiaobin on 2016/9/24.
 */
@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class) ;

    @RequestMapping("index")
    public String index() {
        logger.info("Receive Request ");
        return "index" ;
    }
}
