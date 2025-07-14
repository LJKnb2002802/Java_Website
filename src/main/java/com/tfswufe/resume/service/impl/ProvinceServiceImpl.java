package com.tfswufe.resume.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.converter.ProvinceConverter;
import com.tfswufe.resume.domain.entity.Province;
import com.tfswufe.resume.domain.query.ProvinceQuery;
import com.tfswufe.resume.domain.vo.ProvinceVO;
import com.tfswufe.resume.mapper.ProvinceMapper;
import com.tfswufe.resume.service.ProvinceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {
    @Resource
    private ProvinceConverter provinceConverter;

    @Override
    public PageBean<ProvinceVO> getPageBean(ProvinceQuery query) {
        final Integer pageNum = query.getPageNum();
        final Integer pageSize = query.getPageSize();
        IPage<Province> page = new Page<>(pageNum, pageSize);

        QueryWrapper<Province> wrapper = new QueryWrapper<>();
        //动态SQL
        final String name = query.getName();

        if(name != null){
            wrapper.like("name",name);
        }
        final String code = query.getCode();
        if (code != null) {
            wrapper.like("code",code);
        }
        final Integer priority = query.getPriority();
        if (priority != null) {
            wrapper.like("priority",priority);
        }
        final Boolean deleted = query.getDeleted();
        if (deleted != null) {
            wrapper.like("deleted",deleted);
        }
        final Integer state = query.getState();
        if (state != null) {
            wrapper.eq("state",state);
        }
        final String info = query.getInfo();
        if(info != null){
            wrapper.like("info",info);
        }

        this.page(page, wrapper);
        final PageBean<Province> provincePageBean = PageBean.page2pageBean(page);

        return provinceConverter.provincePageBean2provinceVOPageBean(provincePageBean);
    }
}
