package com.tfswufe.resume.converter;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.base.BaseConverter;
import com.tfswufe.resume.domain.entity.City;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.vo.CityVo;
import com.tfswufe.resume.domain.vo.CompanyVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityConverter extends BaseConverter<City, CityVo> {
}
