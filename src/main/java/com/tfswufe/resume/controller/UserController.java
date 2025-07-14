package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.query.UserQuery;
import com.tfswufe.resume.domain.vo.UserVO;
import com.tfswufe.resume.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/getPage")
    public ResultBean<PageBean<UserVO>> getPage(UserQuery query) {
        final PageBean<UserVO> pageBean = userService.getPageBean(query);
        return ResultBean.ResultBeanUtil.success(pageBean);
    }

    @GetMapping("/getDetails/{id}")
    public ResultBean<User> getDetails(@PathVariable("id")Long id){
        final User user = userService.getById(id);
        return ResultBean.ResultBeanUtil.success(user);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<Void> delete(@PathVariable("id")Long id){
        userService.removeById(id);
        return ResultBean.ResultBeanUtil.success("根据ID删除单个用户成功",null);
    }

    @GetMapping("/deletes/{ids}")
    public ResultBean<Void> deletes(@PathVariable("ids") String ids){
        final List<String> idList = Arrays.stream(ids.split(",")).toList();
        userService.removeByIds(idList);
        return ResultBean.ResultBeanUtil.success("根据ID批量删除用户成功",null);
    }

    @PostMapping("/saveOrUpdate")
    public ResultBean<Void> saveOrUpdate(@RequestBody User user){
        userService.saveOrUpdate(user);
        return ResultBean.ResultBeanUtil.success("添加或修改用户成功！",null);
    }
}
