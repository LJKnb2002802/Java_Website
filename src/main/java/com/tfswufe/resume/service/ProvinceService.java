package com.tfswufe.resume.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.Province;
import com.tfswufe.resume.domain.query.ProvinceQuery;
import com.tfswufe.resume.domain.vo.ProvinceVO;

public interface ProvinceService extends IService<Province>{
    PageBean<ProvinceVO> getPageBean(ProvinceQuery query);

}
