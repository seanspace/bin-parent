package com.bin.enums;

/**
 * Created by xiaobin on 2016/12/30.
 */
public enum SexEnum {

    MALE("男"),
    FEMALE("女");

    private String displayName;

    SexEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static SexEnum valueof(String value) {
        try {
            return valueOf(value);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String args[]) {
        System.out.println(SexEnum.valueof("MALE").getDisplayName());
    }
}
