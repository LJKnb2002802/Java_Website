package com.tfswufe.resume.converter;

import com.tfswufe.resume.bean.base.BaseConverter;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.vo.CompanyVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyConverter extends BaseConverter<Company, CompanyVO> {

}
