package com.tfswufe.resume.bean.base;

import com.tfswufe.resume.bean.PageBean;

/**
 *
 * @author hc
 * @date 2025-07-14 16:37
 * @param <E> 实体类
 * @param <V> VO视图类
 */
public interface BaseConverter<E extends BaseEntity, V extends BaseVO> {
    PageBean<V> entityPageBean2voPageBean(PageBean<E> entityPageBean);
}
