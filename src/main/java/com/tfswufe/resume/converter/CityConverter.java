package com.tfswufe.resume.converter;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.City;
import com.tfswufe.resume.domain.vo.CityVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityConverter {
    PageBean<CityVo> cityPageBean2cityVOPageBean(PageBean<City> companyPageBean);
}
