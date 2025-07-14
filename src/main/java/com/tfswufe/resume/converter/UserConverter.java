package com.tfswufe.resume.converter;


import com.tfswufe.resume.bean.base.BaseConverter;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.vo.UserVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter extends BaseConverter<User, UserVO> {
}
