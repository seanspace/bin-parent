package com.bin.api.dto;

import java.io.Serializable;

/**
 * Created by xiaobin on 2017/1/8.
 */
public class BaseDto implements Serializable {

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
