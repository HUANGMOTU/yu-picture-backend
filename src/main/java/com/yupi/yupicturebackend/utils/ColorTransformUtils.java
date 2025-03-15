package com.yupi.yupicturebackend.utils;

public class ColorTransformUtils {

// 私有构造函数，防止实例化
    private ColorTransformUtils() {

    }

    /**
     * 获取标准颜色
     */
    public static String getStandardColor(String color) {
        // 如果是六位不用转换 如果是五位 第三位要加上0
        if (color.length() == 7) {
            color = color.substring(0,4) + "0" + color.substring(4,7);
        }
        return color;
    }
}
