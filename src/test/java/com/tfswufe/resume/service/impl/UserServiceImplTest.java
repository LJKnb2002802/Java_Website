package com.tfswufe.resume.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.service.UserService;
import com.tfswufe.resume.utils.JsonUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    void getById(){
        final User user = userService.getById(44L);
        System.out.println(user);
    }

    @Test
    void getOne() {
        Wrapper<User> wrapper = Wrappers.<User>lambdaQuery()
                .eq(User::getId, 23L);
        final User user = userService.getOne(wrapper);
        System.out.println(user);
    }

    @Test
    void getOne2() {
        final User user = userService.getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getId, 23L)
                .between(User::getCreateTime, "2023-01-01", "2023-01-02")
                .between(User::getUpdateTime, "2023-01-01", "2023-01-02")
        );
        System.out.println(user);
    }

    @Test
    void page() {
        IPage<User> page = new Page<>(2, 10);
        userService.page(page);
        System.out.println(page);

        final PageBean<User> pageBean = PageBean.page2pageBean(page);
        System.out.println(pageBean);
        System.out.println(pageBean.toString());

        final String json = JsonUtil.obj2string(pageBean);
        System.out.println(json);
    }
}