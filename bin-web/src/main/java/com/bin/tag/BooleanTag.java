package com.bin.tag;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 布尔值标签
 */
public class BooleanTag extends TagSupport {

    private static final Logger log = LoggerFactory.getLogger(BooleanTag.class);
    private static final long serialVersionUID = 5306041918998051642L;

    private String value; // 布尔值

    @SuppressWarnings("unchecked")
    public int doEndTag(){
        try {
            JspWriter out = pageContext.getOut();
            if ("true".equals(value)) {
                out.write("是");
            } else if ("false".equals(value)) {
                out.write("否");
            } else {
                out.write("");
            }
        } catch (Exception e) {
            log.error("EnumTag异常:" + e.getMessage()); // simple message
        }
        return EVAL_PAGE;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
