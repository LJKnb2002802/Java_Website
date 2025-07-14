package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.converter.UserConverter;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.query.UserQuery;
import com.tfswufe.resume.domain.vo.UserVO;
import com.tfswufe.resume.service.UserService;
import com.tfswufe.resume.utils.QueryUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hc
 * @date 2025-07-13 10:16
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserConverter userConverter;

    @GetMapping("/getPage")
    public ResultBean<PageBean<UserVO>> getPage(UserQuery query) {
        query.setColumns(QueryUtil.getColumns(UserVO.class));
        final PageBean<User> userPageBean = userService.getPageBean(query);
        final PageBean<UserVO> pageBean = userConverter.entityPageBean2voPageBean(userPageBean);
        return ResultBeanUtil.success(pageBean);
    }

    @GetMapping("/getDetails/{id}")
    public ResultBean<User> getDetails(@PathVariable("id")Long id){
        final User user = userService.getById(id);
        return ResultBeanUtil.success(user);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<Void> delete(@PathVariable("id")Long id){
        userService.removeById(id);
        return ResultBeanUtil.success("根据ID删除单个用户成功",null);
    }

    @GetMapping("/deletes/{ids}")
    public ResultBean<Void> deletes(@PathVariable("ids") String ids){
        final List<String> idList = Arrays.stream(ids.split(",")).toList();
        userService.removeByIds(idList);
        return ResultBeanUtil.success("根据ID批量删除用户成功",null);
    }

    @PostMapping("/saveOrUpdate")
    public ResultBean<Void> saveOrUpdate(@RequestBody User user){
        userService.saveOrUpdate(user);
        return ResultBeanUtil.success("添加或修改用户成功！",null);
    }

}
