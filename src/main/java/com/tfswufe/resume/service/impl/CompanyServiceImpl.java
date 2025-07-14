package com.tfswufe.resume.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.converter.CompanyConverter;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.query.CompanyQuery;
import com.tfswufe.resume.domain.vo.CompanyVO;
import com.tfswufe.resume.mapper.CompanyMapper;
import com.tfswufe.resume.service.CompanyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService{
    @Resource
    private CompanyConverter companyConverter;

    @Override
    public PageBean<CompanyVO> getPageBean(CompanyQuery query) {
        final Integer pageNum = query.getPageNum();
        final Integer pageSize = query.getPageSize();
        IPage<Company> page = new Page<>(pageNum, pageSize);

        QueryWrapper<Company> wrapper = new QueryWrapper<>();
        //动态SQL
        final String name = query.getName();
        if(name != null){
            wrapper.like("name",name);
        }
        final String website = query.getWebsite();
        if (website != null) {
            wrapper.like("website",website);
        }
        final String phone = query.getPhone();
        if (phone != null) {
            wrapper.like("phone",phone);
        }
        final String addr = query.getAddr();
        if (addr != null) {
            wrapper.like("addr",addr);
        }
        final String info = query.getInfo();
        if (info != null) {
            wrapper.like("info",info);
        }
        final Integer state = query.getState();
        if (state != null) {
            wrapper.eq("state",state);
        }
        final LocalDateTime[] createTime = query.getCreateTime();
        if(createTime != null && createTime.length ==2){
            wrapper.between("create_time",createTime[0],createTime[1]);
        }

        this.page(page, wrapper);
        final PageBean<Company> companyPageBean = PageBean.page2pageBean(page);

        return companyConverter.companyPageBean2companyVOPageBean(companyPageBean);
    }
}