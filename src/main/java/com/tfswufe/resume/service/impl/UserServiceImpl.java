package com.tfswufe.resume.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.converter.UserConverter;
import com.tfswufe.resume.domain.entity.User;
import com.tfswufe.resume.domain.query.UserQuery;
import com.tfswufe.resume.domain.vo.UserVO;
import com.tfswufe.resume.mapper.UserMapper;
import com.tfswufe.resume.service.UserService;
import com.tfswufe.resume.utils.QueryUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author hc
 * @date 2025-07-13 8:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserConverter userConverter;

    @Override
    public PageBean<UserVO> getPageBean(UserQuery query) {
        final Integer pageNum = query.getPageNum();
        final Integer pageSize = query.getPageSize();
        IPage<User> page = new Page<>(pageNum, pageSize);

        QueryWrapper<User> wrapper = QueryUtil.query2queryWrapper( query);

        this.page(page, wrapper);
        final PageBean<User> userPageBean = PageBean.page2pageBean(page);

        return userConverter.userPageBean2userVOPageBean(userPageBean);
    }
}