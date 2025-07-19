package com.tfswufe.resume.utils.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tfswufe.resume.bean.base.BaseQuery;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.query.UserQuery;
import com.tfswufe.resume.ex.ResumeException;
import com.tfswufe.resume.utils.StringUtil;
import com.tfswufe.resume.utils.mybatisplus.annos.Between;
import com.tfswufe.resume.utils.mybatisplus.annos.EQ;
import com.tfswufe.resume.utils.mybatisplus.annos.Like;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
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
    private static List<String> annotationList = List.of("EQ","Like","Between");
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
            throw new ResumeException("获取BeanInfo时发生异常");
        }
        final PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            // 字段的名称
            String name = pd.getName();
            if ("pageNum".equals(name) || "pageSize".equals(name) || "keywords".equals(name) || "columns".equals(name)) {
                continue;
            }

            //读取字段值的方法
            final Method readMethod = pd.getReadMethod();
            //字段的值
            Object value = null;
            try {
                value = readMethod.invoke(query);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                throw new ResumeException("获取字段值时发生异常");
            }
            if (value != null) {
                Field field = null;
                try {
                    field = query.getClass().getDeclaredField(name);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                name = StringUtil.camel2underline(name);
                //获取字段上所有的注解
                final Annotation[] annotations = field.getAnnotations();
                if(annotations != null && annotations.length > 0){
                    for (Annotation annotation : annotations) {
                        final String annoName = annotation.annotationType().getSimpleName();
                        if(annotationList.contains(annoName)){
                            if("EQ".equals(annoName)){
                                final EQ eq = (EQ) annotation;
                                final Logic logic = eq.logic();
                                if (logic.equals(Logic.OR)) {
                                    queryWrapper.or().eq(name, value);
                                }else {
                                    queryWrapper.eq(name, value);
                                }
                            }else if("Like".equals(annoName)){
                                final Like like = (Like) annotation;
                                final Logic logic = like.logic();
                                if (logic.equals(Logic.OR)) {
                                    queryWrapper.or().like(name, value);
                                }else {
                                    queryWrapper.like(name, value);
                                }
                            }else if("Between".equals(annoName)&& value.getClass().isArray()){
                                Object[] values = (Object[]) value;
                                if(values.length==2){
                                    final Between between = (Between) annotation;
                                    final Logic logic = between.logic();
                                    if (logic.equals(Logic.OR)) {
                                        queryWrapper.or().between(name, values[0],values[1]);
                                    }else {
                                        queryWrapper.between(name, values[0],values[1]);
                                    }
                                }

                            }
                            break;
                        }
                    }
                }
            }
            // 如果有字段priority，则按照优先级排序
            if ("priority".equals(name)) {
                queryWrapper.orderByDesc("priority");
            }
        }
        // 默认按照创建时间倒序排序
        queryWrapper.orderByDesc("create_time");
        return queryWrapper;
    }

    /**
     * 获取指定类（及其父类，一直到祖先类Object）的所有字段
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
        } while (!"Object".equals(clazzName));
        return columns;
    }


    public static void main(String[] args) {
        //final List<String> columns = getColumns(UserVO.class);
        //columns.forEach(System.out::println);


        //final UserQuery userQuery = new UserQuery();
        //userQuery.setNickname("aaaaa");
        //userQuery.setState(1);
        //userQuery.setCreateTime(new LocalDateTime[]{LocalDateTime.now(), LocalDateTime.now()});
        //final QueryWrapper<User> wrapper = query2queryWrapper(userQuery);

        UserQuery query = new UserQuery();
        query.setGender(true);

        QueryWrapper<User> wrapper = QueryUtil.query2queryWrapper(query);
    }
}

