package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.bean.base.BaseController;
import com.tfswufe.resume.bean.base.service.BaseService;
import com.tfswufe.resume.converter.CountryConverter;
import com.tfswufe.resume.domain.entity.Country;
import com.tfswufe.resume.domain.query.CountryQuery;
import com.tfswufe.resume.domain.vo.CountryVO;
import com.tfswufe.resume.service.CountryService;
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
@RequestMapping("/country")
public class CountryController extends BaseController<Country> {
    @Resource
    private CountryService countryService;
    @Resource
    private CountryConverter countryConverter;

    public CountryController(BaseService<Country> baseService) {
        super(baseService);
    }

    @GetMapping("/getPage")
    public ResultBean<PageBean<CountryVO>> getPage(CountryQuery query) {
        query.setColumns(QueryUtil.getColumns(CountryVO.class));
        final PageBean<Country> countryPageBean = countryService.getPageBean(query);
        final PageBean<CountryVO> pageBean = countryConverter.entityPageBean2voPageBean(countryPageBean);
        return ResultBeanUtil.success(pageBean);
    }

}
