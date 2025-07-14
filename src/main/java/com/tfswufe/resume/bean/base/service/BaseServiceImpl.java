package com.tfswufe.resume.bean.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.base.BaseQuery;
import com.tfswufe.resume.domain.vo.UserVO;
import com.tfswufe.resume.utils.QueryUtil;

/**
 *
 * @author hc
 * @date 2025-07-14 16:09
 */
public class BaseServiceImpl<E> extends ServiceImpl<BaseMapper<E>, E> implements BaseService<E> {
    @Override
    public PageBean<E> getPageBean(BaseQuery query) {
        final Integer pageNum = query.getPageNum();
        final Integer pageSize = query.getPageSize();
        IPage<E> page = new Page<>(pageNum, pageSize);

        QueryWrapper<E> wrapper = QueryUtil.query2queryWrapper( query);

        this.page(page, wrapper);
        return PageBean.page2pageBean(page);
    }
}
