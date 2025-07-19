package com.tfswufe.resume.converter;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.base.BaseConverter;
import com.tfswufe.resume.domain.entity.Recruitment;
import com.tfswufe.resume.domain.vo.RecruitmentVO;
import com.tfswufe.resume.domain.vo.portal.PortalRecruitmentVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecruitmentConverter extends BaseConverter<Recruitment, RecruitmentVO> {

    PageBean<PortalRecruitmentVO> recruitmentPageBean2portalRecruitmentVOPageBean(PageBean<Recruitment> recruitmentPageBean);
}
