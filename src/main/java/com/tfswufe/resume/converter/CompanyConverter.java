package com.tfswufe.resume.converter;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.vo.CompanyVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyConverter {

    PageBean<CompanyVO> companyPageBean2companyVOPageBean(PageBean<Company> companyPageBean);
}
