package com.tfswufe.resume.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.query.CompanyQuery;
import com.tfswufe.resume.domain.vo.CompanyVO;

public interface CompanyService extends IService<Company>{

    PageBean<CompanyVO> getPageBean(CompanyQuery query);
}