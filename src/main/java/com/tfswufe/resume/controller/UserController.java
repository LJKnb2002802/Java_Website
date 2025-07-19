package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.bean.base.BaseController;
import com.tfswufe.resume.bean.base.service.BaseService;
import com.tfswufe.resume.converter.UserConverter;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.query.UserQuery;
import com.tfswufe.resume.domain.vo.UserVO;
import com.tfswufe.resume.service.UserService;
import com.tfswufe.resume.utils.mybatisplus.QueryUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hc
 * @date 2025-07-13 10:16
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    @Resource
    private UserService userService;
    @Resource
    private UserConverter userConverter;

    public UserController(BaseService<User> baseService) {
        super(baseService);
    }

    @GetMapping("/getPage")
    public ResultBean<PageBean<UserVO>> getPage(UserQuery query) {
        query.setColumns(QueryUtil.getColumns(UserVO.class));
        final PageBean<User> userPageBean = userService.getPageBean(query);
        final PageBean<UserVO> pageBean = userConverter.entityPageBean2voPageBean(userPageBean);
        return ResultBeanUtil.success(pageBean);
    }

}
