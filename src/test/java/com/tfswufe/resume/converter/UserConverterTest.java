package com.tfswufe.resume.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.vo.UserVO;
import com.tfswufe.resume.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserConverterTest {
    @Resource
    private UserConverter userConverter;
    @Resource
    private UserService userService;

    @Test
    void user2userVO() {
        //String salt = RandomUtil.genString(22);
        //final String password = Md5Util.encode("123456", salt);
        //final User user = new User(null, "小王", "https://picsum.photos/200/300", true, LocalDate.of(1999, 1, 1),
        //        "123@qq.com", "12345678901","xiaowang", password, salt, 0, 0, 0, "无", 1L, false, 0, LocalDateTime.now(),
        //        LocalDateTime.now());
        //System.out.println(user);
        //final UserVO userVO = userConverter.user2userVO(user);
        //System.out.println(userVO);
    }

    @Test
    void userPageBean2userVOPageBean() {
        IPage<User> page = new Page<>(3, 16);
        userService.page(page);
        final PageBean<User> userPageBean = PageBean.page2pageBean(page);
        System.out.println(userPageBean);

        final PageBean<UserVO> userVOPageBean = userConverter.entityPageBean2voPageBean(userPageBean);
        System.out.println(userVOPageBean);
    }
}