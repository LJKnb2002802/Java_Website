package com.tfswufe.resume.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.Country;
import com.tfswufe.resume.domain.query.CountryQuery;
import com.tfswufe.resume.domain.vo.CountryVO;

public interface CountryService extends IService<Country>{
    PageBean<CountryVO> getPageBean(CountryQuery query);

}
