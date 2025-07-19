package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.bean.base.BaseController;
import com.tfswufe.resume.bean.base.service.BaseService;
import com.tfswufe.resume.converter.ProvinceConverter;
import com.tfswufe.resume.domain.entity.Province;
import com.tfswufe.resume.domain.query.ProvinceQuery;
import com.tfswufe.resume.domain.vo.ProvinceVO;
import com.tfswufe.resume.service.ProvinceService;
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
@RequestMapping("/province")
public class ProvinceController extends BaseController<Province> {
    @Resource
    private ProvinceService provinceService;
    @Resource
    private ProvinceConverter provinceConverter;

    public ProvinceController(BaseService<Province> baseService) {
        super(baseService);
    }

    @GetMapping("/getPage")
    public ResultBean<PageBean<ProvinceVO>> getPage(ProvinceQuery query) {
        query.setColumns(QueryUtil.getColumns(ProvinceVO.class));
        final PageBean<Province> provincePageBean = provinceService.getPageBean(query);
        final PageBean<ProvinceVO> pageBean = provinceConverter.entityPageBean2voPageBean(provincePageBean);
        return ResultBeanUtil.success(pageBean);
    }

}