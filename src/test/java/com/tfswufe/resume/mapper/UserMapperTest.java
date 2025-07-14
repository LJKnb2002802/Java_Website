package com.tfswufe.resume.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.tfswufe.resume.domain.entity.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void insert() {
        //String salt = RandomUtil.genString(22);
        //final String password = Md5Util.encode("123456", salt);
        //final User user = new User(null, "小王", "https://picsum.photos/200/300", true, LocalDate.of(1999, 1, 1),
        //        "123@qq.com", "12345678901","xiaowang", password, salt, 0, 0, 0, "无", 1L, false, 0, LocalDateTime.now(),
        //        LocalDateTime.now());
        //final int res = userMapper.insert(user);
        //System.out.println(res);
    }

    @Test
    void updateById() {
        final User user = new User();
        user.setId(87L);
        user.setNickname("王小二");
        final int res = userMapper.updateById(user);
        System.out.println(res);
    }

    @Test
    void selectById() {
        final User user = userMapper.selectById(33L);
        System.out.println(user);
    }

    @Test
    void selectList() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", 33L);
        wrapper.ne("nickname", "haha");
        wrapper.or().like("info", "xixi");
        wrapper.between("create_time", LocalDateTime.now(), LocalDateTime.now());
        wrapper.orderByDesc("id");
        final List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    void selectList2() {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery()
                .eq(User::getId, 33L)
                .between(User::getBirth, LocalDate.now(), LocalDate.now());
        userMapper.selectList(wrapper);
    }

    @Test
    void deleteById() {
        final int res = userMapper.deleteById(87L);
        System.out.println(res);
    }
}

