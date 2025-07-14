package com.tfswufe.resume.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tfswufe.resume.bean.base.BaseQuery;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.query.UserQuery;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

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
    public static <T> QueryWrapper<T> query2queryWrapper(BaseQuery query){
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        final BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(query.getClass(), Object.class);
        } catch (IntrospectionException e) {
            e.printStackTrace();
            throw new RuntimeException("获取BeanInfo时发生异常");
        }
        final PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            final String name = pd.getName();
            if("pageNum".equals(name) || "pageSize".equals(name) || "keywords".equals(name)){
                continue;
            }
            final String type = pd.getPropertyType().getSimpleName();

            final Method readMethod = pd.getReadMethod();
            Object value = null;
            try {
                value = readMethod.invoke(query,null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            if(value != null){
                if("String".equals(type)){
                    queryWrapper.like(name,value);
                }else if(type.contains("[]") && value.getClass().isArray()){
                    Object[] values = (Object[]) value;
                    queryWrapper.between(name,values[0],values[1]);
                }else {
                    queryWrapper.eq(name,value);
                }
            }
        }
        return queryWrapper;
    }

    public static void main(String[] args) {
        final UserQuery userQuery = new UserQuery();
        userQuery.setNickname("aaaaa");
        userQuery.setState(1);
        userQuery.setCreateTime(new LocalDateTime[]{LocalDateTime.now(),LocalDateTime.now()});
        final QueryWrapper<User> wrapper = query2queryWrapper(userQuery);
    }
}
