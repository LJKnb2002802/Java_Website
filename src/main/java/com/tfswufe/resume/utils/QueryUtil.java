package com.tfswufe.resume.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tfswufe.resume.bean.base.BaseQuery;
import com.tfswufe.resume.domain.vo.UserVO;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hc
 * @date 2025-07-14 11:41
 */
public class QueryUtil {
    /**
     * 将查询参数转换成QueryWrapper
     * @param query 查询参数
     * @return QueryWrapper
     */
    public static <T> QueryWrapper<T> query2queryWrapper(BaseQuery query) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        // 查询指定的字段
        final List<String> columns = query.getColumns();
        if (columns != null && columns.size() > 0) {
            queryWrapper.select(columns);
        }
        final BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(query.getClass(), Object.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
            throw new RuntimeException("获取BeanInfo时发生异常");
        }
        final PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            // 字段的名称
            String name = pd.getName();
            if ("pageNum".equals(name) || "pageSize".equals(name) || "keywords".equals(name) || "columns".equals(name)) {
                continue;
            }
            // 字段的类型
            final String type = pd.getPropertyType().getSimpleName();
            //读取字段值的方法
            final Method readMethod = pd.getReadMethod();
            //字段的值
            Object value = null;
            try {
                value = readMethod.invoke(query, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            if (value != null) {
                name = StringUtil.camel2underline(name);
                if ("String".equals(type)) {
                    queryWrapper.like(name, value);
                } else if (type.contains("[]") && value.getClass().isArray()) {
                    Object[] values = (Object[]) value;
                    queryWrapper.between(name, values[0], values[1]);
                } else {
                    queryWrapper.eq(name, value);
                }
            }
        }
        return queryWrapper;
    }

    /**
     * 获取指定类的所有字段
     * @param clazz 实体类
     * @return 字段列表
     */
    public static List<String> getColumns(Class<?> clazz) {
        List<String> columns = new ArrayList<>();
        String clazzName;
        do {
            for (final Field field : clazz.getDeclaredFields()) {
                final String fieldName = field.getName();
                columns.add(StringUtil.camel2underline(fieldName));
            }
            clazz = clazz.getSuperclass();
            clazzName = clazz.getSimpleName();
        } while (!clazzName.equals("Object"));
        return columns;
    }


    public static void main(String[] args) {
        final List<String> columns = getColumns(UserVO.class);
        columns.forEach(System.out::println);


        //final UserQuery userQuery = new UserQuery();
        //userQuery.setNickname("aaaaa");
        //userQuery.setState(1);
        //userQuery.setCreateTime(new LocalDateTime[]{LocalDateTime.now(), LocalDateTime.now()});
        //final QueryWrapper<User> wrapper = query2queryWrapper(userQuery);
    }
}

