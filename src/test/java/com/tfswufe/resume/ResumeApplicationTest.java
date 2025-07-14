package com.tfswufe.resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ResumeApplicationTest {
    //public static void main(String[] args) throws JsonProcessingException {
    //    final Dept dept = new Dept();
    //    dept.setDeptno(10);
    //    dept.setDname("sales");
    //    dept.setLoc("angles");
    //    System.out.println(dept);
    //
    //    ObjectMapper objectMapper = new ObjectMapper();
    //    final String json = objectMapper.writeValueAsString(dept);
    //    System.out.println(json);
    //
    //    final Dept dd = objectMapper.readValue(json, Dept.class);
    //    System.out.println(dd);
    //}
//    uu
//    public static void main(String[] args) {
//        final Class clazz = Dept.class;
//
//        System.out.println(clazz.getSimpleName());
//        System.out.println(clazz.getPackage());
//
//        final Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println(field.getName());
//            System.out.println(field.getType());
//            System.out.println(field.getModifiers());
//
//        }
//    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InvocationTargetException {
        //获取到类的字节码
        //final Class clazz = Dept.class;
        //
        //final Method[] methods = clazz.getMethods();
        //for (Method method : methods) {
        //    System.out.println(method.getName());
        //}

        final Dept dept = new Dept(10,"sales","newyork");
        // 获取到对象的字节码
        // 获取Dept类的Class对象
        Class clazz2 = dept.getClass();
        // 获取Class对象中所有的公共方法，包括继承自父类的方法
        final Method[] methods2 = clazz2.getMethods();
        // 遍历所有方法
        for (Method method : methods2) {
            // 获取方法名
            final String methodName = method.getName();
            // 打印方法名
            System.out.println(methodName);
            // 检查方法名是否以"get"开头，这是JavaBean中获取属性值的方法的命名规范
            if (methodName.startsWith("get")) {
                // 使用反射调用方法，并打印返回值
                Object res = method.invoke(dept, null);
                System.out.println(res);
            }
        }
    }
}