package com.tfswufe.resume.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.query.UserQuery;
import com.tfswufe.resume.domain.vo.UserVO;

public interface  UserService extends IService<User> {
    PageBean<UserVO> getPageBean(UserQuery query);
}
