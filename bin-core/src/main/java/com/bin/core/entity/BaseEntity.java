package com.bin.core.entity;

import com.alibaba.fastjson.JSON;
import com.bin.api.annotations.*;
import com.bin.utils.mask.MaskUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: 实体基类
 * @Author: xiaobin.liu
 * @Date: 16/12/13
 * @Time: 上午11:07
 */
public class BaseEntity implements Serializable,Cloneable {

    private static final long serialVersionUID = 7385843011565227456L;

    @Override
    public String toString() {
        BaseEntity req = null;
        try {
            req = (BaseEntity) this.clone();
            this.hiddenMask(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(req);
    }

    /**
     * 根据是否加密获取数据
     * @param fieldName
     * @param encryption
     */
    private Object invokeGet(String fieldName, boolean encryption) {
        if (encryption) {
            return invokeGetByDecrypt(fieldName);
        }
        return invokeGet(fieldName);
    }

    private void hiddenMask(BaseEntity req) throws Exception {

        if (null == req) {
            return;
        }
        Field[] allFields = req.getClass().getDeclaredFields();
        for (Field field : allFields) {

            if (field.isAnnotationPresent(CardNo.class)) {
                CardNo attribute = field.getAnnotation(CardNo.class);
                String card = (String) req.invokeGet(field.getName(),attribute.encryption());
                if (StringUtils.isNotEmpty(card)) {
                    String str = MaskUtils.maskBankCardNo(card);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            } else if (field.isAnnotationPresent(Phone.class)) {
                Phone attribute = field.getAnnotation(Phone.class);
                String phone = (String) req.invokeGet(field.getName(),attribute.encryption());
                if (StringUtils.isNotEmpty(phone)) {
                    String str = MaskUtils.maskMobile(phone);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            } else if (field.isAnnotationPresent(IdCardNo.class)) {
                IdCardNo attribute = field.getAnnotation(IdCardNo.class);
                String card = (String) req.invokeGet(field.getName(),attribute.encryption());
                if (StringUtils.isNotEmpty(card)) {
                    String str = MaskUtils.maskIdCardNo(card);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            } else if (field.isAnnotationPresent(UserName.class)) {
                UserName attribute = field.getAnnotation(UserName.class);
                String userName = (String) req.invokeGet(field.getName(),attribute.encryption());
                if (StringUtils.isNotEmpty(userName)) {
                    String str = MaskUtils.maskName(userName);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            } else if (field.isAnnotationPresent(Name.class)) {
                Name attribute = field.getAnnotation(Name.class);
                String userName = (String) req.invokeGet(field.getName(),attribute.encryption());
                if (StringUtils.isNotEmpty(userName)) {
                    String str = MaskUtils.maskName(userName);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            } else if (field.isAnnotationPresent(Email.class)) {
                Email attribute = field.getAnnotation(Email.class);
                String userName = (String) req.invokeGet(field.getName(),attribute.encryption());
                if (StringUtils.isNotEmpty(userName)) {
                    String str = MaskUtils.maskEmail(userName);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            } else if (field.isAnnotationPresent(Passport.class)) {
                Passport attribute = field.getAnnotation(Passport.class);
                String userName = (String) req.invokeGet(field.getName(),attribute.encryption());
                if (StringUtils.isNotEmpty(userName)) {
                    String str = MaskUtils.hiddenMiddle(userName);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            } else if (field.isAnnotationPresent(Password.class)) {
                Password attribute = field.getAnnotation(Password.class);
                String userName = (String) req.invokeGet(field.getName(),attribute.encryption());
                if (StringUtils.isNotEmpty(userName)) {
                    String str = MaskUtils.maskBankPwd(userName);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            } else if (field.isAnnotationPresent(Json.class)) {
                Json attribute = field.getAnnotation(Json.class);
                String userName = (String) req.invokeGet(field.getName(),attribute.encryption());
                Json jsonAnno = field.getAnnotation(Json.class);
                String[] keys = jsonAnno.maskKey();
                ;
                if (StringUtils.isNotEmpty(userName)) {
                    String str = MaskUtils.maskJsonString(userName, keys);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            } else if (field.isAnnotationPresent(JsonArray.class)) {
                JsonArray attribute = field.getAnnotation(JsonArray.class);
                String userName = (String) req.invokeGet(field.getName(),attribute.encryption());
                JsonArray jsonAnno = field.getAnnotation(JsonArray.class);
                String[] keys = jsonAnno.maskKey();
                if (StringUtils.isNotEmpty(userName)) {
                    String str = MaskUtils.maskJsonArrayString(userName, keys);
                    req.invokeSet(field.getName(), str);
                } else {
                    req.invokeSet(field.getName(), "null");
                }
            }

            //如果是当前类的子类直接
            if (BaseEntity.class.isAssignableFrom(field.getType())) {
                BaseEntity c = (BaseEntity) req.invokeGet(field.getName());
                if (null != c) {
                    BaseEntity b = (BaseEntity) c.clone();
                    hiddenMask(b);
                    req.invokeSet(field.getName(), b);
                }
            }
        }
    }

    /**
     * 获取解密后的数据
     * @param fieldName
     * @return
     */
    public Object invokeGet(String fieldName) {
        return invokeGetMethod(fieldName,"");
    }

    /**
     * 获取get方法数据
     * @param fieldName
     * @return
     */
    private Object invokeGetMethod(String fieldName,String suffix) {
        Method mget = ReflectionUtils.findMethod(this.getClass(), "get" + StringUtils.capitalize(fieldName)
        + StringUtils.trimToEmpty(suffix));

        return ReflectionUtils.invokeMethod(mget, this);
    }

    /**
     * 获取解密后的数据
     * @param fieldName
     * @return
     */
    public Object invokeGetByDecrypt(String fieldName) {
        return invokeGetMethod(fieldName, "ByDecrypt");
    }

    /**
     * 此方法不允许设置null值
     * @param fieldName
     * @param param
     */
    public void invokeSet(String fieldName, Object param) {
        Class<?> type = null;
        if (null != param) {
            type = param.getClass();
        }
        if (type == null) {
            return;
        }
        Method mset = ReflectionUtils.findMethod(this.getClass(), "set" + StringUtils.capitalize(fieldName), type);
        ReflectionUtils.invokeMethod(mset, this, param);
    }

    public static void main(String[] args) {
        System.out.println("1" + StringUtils.trimToEmpty(null) + "2");
    }
}
