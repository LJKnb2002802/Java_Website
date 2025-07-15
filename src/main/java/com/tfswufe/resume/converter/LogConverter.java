package com.tfswufe.resume.converter;

import com.tfswufe.resume.bean.base.BaseConverter;
import com.tfswufe.resume.domain.entity.Log;
import com.tfswufe.resume.domain.vo.LogVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogConverter extends BaseConverter<Log, LogVO> {
}
