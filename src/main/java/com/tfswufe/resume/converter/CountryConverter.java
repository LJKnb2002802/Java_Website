package com.tfswufe.resume.converter;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.Country;
import com.tfswufe.resume.domain.vo.CountryVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryConverter {
    PageBean<CountryVO> countryPageBean2countryVOPageBean(PageBean<Country> companyPageBean);
}
