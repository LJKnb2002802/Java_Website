package com.tfswufe.resume.converter;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.base.BaseConverter;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.entity.Country;
import com.tfswufe.resume.domain.vo.CompanyVO;
import com.tfswufe.resume.domain.vo.CountryVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryConverter extends BaseConverter<Country, CountryVO>{
}
