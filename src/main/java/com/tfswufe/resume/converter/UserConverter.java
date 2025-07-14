package com.tfswufe.resume.converter;


import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.vo.UserVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserConverter {
    PageBean<UserVO> userPageBean2userVOPageBean(PageBean<User> userPageBean);
}
