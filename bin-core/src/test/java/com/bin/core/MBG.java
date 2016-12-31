package com.bin.core;

import mybatis.generator.MyBatisGeneratorTool;

/**
 * Title: mybatis自动生成工具
 * Description:
 * Copyright: Copyright (c)2015
 * Company: YeePay
 *
 * @author chen.liu on 16/8/11.
 */
public class MBG {

    private static final String PATH = "bin-core/src/test/resources/mbg/";

    /**
     * 生成表数据
     * mybatis generator main
     * @param args
     */
    public static void main(String args[]) {
        generate("binGeneratorConfig.xml");
    }

    private static void generate(String name) {
        MyBatisGeneratorTool.generate(PATH + name);
    }

}
