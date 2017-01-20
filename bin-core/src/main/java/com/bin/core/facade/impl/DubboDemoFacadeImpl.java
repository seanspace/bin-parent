package com.bin.core.facade.impl;

import com.bin.api.facade.DubboDemoFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiaobin on 2017/1/20.
 */
public class DubboDemoFacadeImpl implements DubboDemoFacade {
    private static final Logger logger = LoggerFactory.getLogger(DubboDemoFacadeImpl.class);
    @Override
    public String sayHello(String msg) {
        logger.info("hello dubbo:" + msg);
        return msg;
    }
}
