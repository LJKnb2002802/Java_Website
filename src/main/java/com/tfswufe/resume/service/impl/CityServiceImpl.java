package com.tfswufe.resume.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.converter.CityConverter;
import com.tfswufe.resume.domain.entity.City;
import com.tfswufe.resume.domain.query.CityQuery;
import com.tfswufe.resume.domain.vo.CityVo;
import com.tfswufe.resume.mapper.CityMapper;
import com.tfswufe.resume.service.CityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService{
    @Resource
    private CityConverter cityConverter;

    @Override
    public PageBean<CityVo> getPageBean(CityQuery query) {
        final Integer pageNum = query.getPageNum();
        final Integer pageSize = query.getPageSize();
        IPage<City> page = new Page<>(pageNum, pageSize);

        QueryWrapper<City> wrapper = new QueryWrapper<>();
        //动态SQL
        final String name = query.getName();
        if(name != null){
            wrapper.like("name",name);
        }
        final String code = query.getCode();
        if (code != null) {
            wrapper.like("code",code);
        }
        final Long provinceId = query.getProvinceId();
        if (provinceId != null) {
            wrapper.eq("provinceId",provinceId);
        }
        final Integer priority = query.getPriority();
        if (priority != null) {
            wrapper.eq("priority",priority);
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
        final PageBean<City> cityPageBean = PageBean.page2pageBean(page);

        return cityConverter.cityPageBean2cityVOPageBean(cityPageBean);
    }
}
