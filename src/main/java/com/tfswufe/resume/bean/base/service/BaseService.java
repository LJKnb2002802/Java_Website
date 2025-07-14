package com.tfswufe.resume.bean.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.base.BaseQuery;

public interface BaseService<E> extends IService<E> {
    /**
     * 分页查询
     * @param query
     * @return
     */
    PageBean<E> getPageBean(BaseQuery query);
}
