package com.tfswufe.resume.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.base.service.BaseServiceImpl;
import com.tfswufe.resume.converter.ProvinceConverter;
import com.tfswufe.resume.domain.entity.Province;
import com.tfswufe.resume.domain.query.ProvinceQuery;
import com.tfswufe.resume.domain.vo.ProvinceVO;
import com.tfswufe.resume.mapper.ProvinceMapper;
import com.tfswufe.resume.service.ProvinceService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
@Service
public class ProvinceServiceImpl extends BaseServiceImpl<Province> implements ProvinceService {
}
