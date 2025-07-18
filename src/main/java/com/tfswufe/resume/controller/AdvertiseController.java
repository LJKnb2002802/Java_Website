package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.bean.base.BaseController;
import com.tfswufe.resume.converter.AdvertiseConverter;
import com.tfswufe.resume.domain.entity.Advertise;
import com.tfswufe.resume.domain.query.AdvertiseQuery;
import com.tfswufe.resume.domain.vo.AdvertiseVO;
import com.tfswufe.resume.service.AdvertiseService;
import com.tfswufe.resume.utils.QueryUtil;
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
@RequestMapping("/advertise")
public class AdvertiseController extends BaseController<Advertise> {
    @Resource
    private AdvertiseService advertiseService;
    @Resource
    private AdvertiseConverter advertiseConverter;

    public AdvertiseController(AdvertiseService advertiseService) {
        super(advertiseService);
    }


    @GetMapping("/getPage")
    public ResultBean<PageBean<AdvertiseVO>> getPage(AdvertiseQuery query) {
        query.setColumns(QueryUtil.getColumns(AdvertiseVO.class));
        final PageBean<Advertise> advertisePageBean = advertiseService.getPageBean(query);
        final PageBean<AdvertiseVO> pageBean = advertiseConverter.entityPageBean2voPageBean(advertisePageBean);
        return ResultBeanUtil.success(pageBean);
    }

}
