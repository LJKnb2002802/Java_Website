package com.tfswufe.resume.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.base.service.BaseServiceImpl;
import com.tfswufe.resume.converter.CountryConverter;
import com.tfswufe.resume.domain.entity.Country;
import com.tfswufe.resume.domain.query.CountryQuery;
import com.tfswufe.resume.domain.vo.CountryVO;
import com.tfswufe.resume.mapper.CountryMapper;
import com.tfswufe.resume.service.CountryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
@Service
public class CountryServiceImpl extends BaseServiceImpl<Country> implements CountryService {

}
