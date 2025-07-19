package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.bean.base.BaseController;
import com.tfswufe.resume.converter.CityConverter;
import com.tfswufe.resume.domain.entity.City;
import com.tfswufe.resume.domain.query.CityQuery;
import com.tfswufe.resume.domain.vo.CityVO;
import com.tfswufe.resume.service.CityService;
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
@RequestMapping("/city")
public class CityController extends BaseController<City> {
    @Resource
    private CityService cityService;
    @Resource
    private CityConverter cityConverter;

    public CityController(CityService cityService) {
        super(cityService);
    }


    @GetMapping("/getPage")
    public ResultBean<PageBean<CityVO>> getPage(CityQuery query) {
        query.setColumns(QueryUtil.getColumns(CityVO.class));
        final PageBean<City> cityPageBean = cityService.getPageBean(query);
        final PageBean<CityVO> pageBean = cityConverter.entityPageBean2voPageBean(cityPageBean);
        return ResultBeanUtil.success(pageBean);
    }

}