package com.tfswufe.resume.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tfswufe.resume.domain.entity.Country;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CountryMapper extends BaseMapper<Country> {
}