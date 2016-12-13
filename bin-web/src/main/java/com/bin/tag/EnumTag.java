package com.bin.tag;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c)2015
 * Company: YeePay
 *
 * @author chen.liu on 16/8/11.
 */
public class EnumTag extends TagSupport {

    private static final Logger log = LoggerFactory.getLogger(EnumTag.class);
    /**
     * 默认的显示字段的字段名称
     */
    private static final String DISPALY_fIELD_NAME = "displayName";

    private String type; // 简单类名
    private String enumValue; // 枚举名
    private String display; // 显示的属性名 如果要自定义的话

    private static final Map<String, Class<?>> enumMap = new HashMap<String, Class<?>>();

    static {
    }

    @SuppressWarnings("unchecked")
    public int doEndTag(){
        try {

            JspWriter out = pageContext.getOut();
            if (StringUtils.isBlank(enumValue)) {
                out.write("");
                return EVAL_PAGE;//处理标签后，继续处理JSP后面的内容
            }
            if (StringUtils.isBlank(type)) {
                out.write("");
                return EVAL_PAGE;
            }
            // 写对应的枚举值
            Class<Enum> enumClazz = (Class<Enum>) enumMap.get(type);
            if (null == enumClazz) {
                enumClazz = (Class<Enum>) Class.forName(type);
            }
            if (null != enumClazz) {
                Enum e = Enum.valueOf(enumClazz, enumValue);
                Field field;
                if (StringUtils.isBlank(display)) {
                    field = enumClazz.getDeclaredField(DISPALY_fIELD_NAME);
                } else {
                    field = enumClazz.getDeclaredField(display);
                }
                if (null != field) {
                    field.setAccessible(true);
                    String value = (String) field.get(e);
                    out.write(value);
                }
            } else {
                out.write("NULL");
            }
        } catch (Exception e) {
            log.error("EnumTag异常:" + e.getMessage()); // simple message
        }
        return EVAL_PAGE;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }
}
