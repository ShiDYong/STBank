//package com.mason.chapter_02;
//
//
//import org.junit.platform.commons.util.StringUtils;
//
///**
// * @author yongshi
// * @date 2022/10/30 21:13
// * @Description 系统类型的枚举类
// */
//public enum SystemType {
//    ERP(0, "ERP"),
//    ORDER_PLATFORM(1, "订货平台"),
//    PERSONAL(2, "个人中心系统"),
//    SHOP_MALL(3, "商城"),
//    PARTNER(4, "伙伴系统");
//
//    private int value;
//    private String desc;
//
//    SystemType(int value, String desc) {
//        this.value = value;
//        this.desc = desc;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    /**
//     * 通过value取枚举
//     * @param value
//     * @return
//     */
//
//    public static SystemType getTypeByValue(String value) {
//        if (StringUtils.isBlank(value)) {
//            return null;
//        }
//        int valueKey = Integer.parseInt(value);
//        for (SystemType enums : SystemType.values()) {
//            if (enums.getValue() == valueKey) {
//                return enums;
//            }
//        }
//        return null;
//
//    }
//
//
//    /**
//     * 通过value取描述符
//     * @param value
//     * @return
//     */
//    public static String getDescByValue(int value) {
//        for (SystemType enums : SystemType.values()
//        ) {
//            if (enums.getValue() == value) {
//                return enums.getDesc();
//            }
//
//        }
//        return "";
//    }
//
//
//}
