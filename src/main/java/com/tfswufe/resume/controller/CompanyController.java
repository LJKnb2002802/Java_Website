package com.tfswufe.resume.controller;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.bean.base.BaseController;
import com.tfswufe.resume.bean.base.service.BaseService;
import com.tfswufe.resume.converter.CompanyConverter;
import com.tfswufe.resume.domain.entity.City;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.query.CompanyQuery;
import com.tfswufe.resume.domain.vo.CompanyVO;
import com.tfswufe.resume.service.CompanyService;
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
@RequestMapping("/company")
public class CompanyController extends BaseController<Company> {
    @Resource
    private CompanyService companyService;
    @Resource
    private CompanyConverter companyConverter;

    public CompanyController(BaseService<Company> baseService) {
        super(baseService);
    }

    @GetMapping("/getPage")
    public ResultBean<PageBean<CompanyVO>> getPage(CompanyQuery query) {
        query.setColumns(QueryUtil.getColumns(CompanyVO.class));
        final PageBean<Company> companyPageBean = companyService.getPageBean(query);
        final PageBean<CompanyVO> pageBean = companyConverter.entityPageBean2voPageBean(companyPageBean);
        return ResultBeanUtil.success(pageBean);
    }

}