package com.tfswufe.resume.utils;

public class StringUtil {
    /**
     * 将驼峰命名转换为下划线命名
     * @param camelCaseStr 要转换的驼峰命名字符串
     * @return 转换后的下划线命名字符串
     */
    public static String camel2underline(String camelCaseStr) {
        // 使用正则表达式匹配大写字母并在其前面添加下划线
        return camelCaseStr.replaceAll("([A-Z])", "_$1").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(camel2underline("helloWorldWoShi"));
    }

}
