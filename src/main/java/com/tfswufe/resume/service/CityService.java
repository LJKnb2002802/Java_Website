package com.tfswufe.resume.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.City;
import com.tfswufe.resume.domain.query.CityQuery;
import com.tfswufe.resume.domain.vo.CityVo;

public interface CityService extends IService<City>{
    PageBean<CityVo> getPageBean(CityQuery query);

}
