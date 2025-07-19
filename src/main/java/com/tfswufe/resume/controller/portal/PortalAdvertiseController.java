package com.tfswufe.resume.controller.portal;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.converter.AdvertiseConverter;
import com.tfswufe.resume.domain.entity.Advertise;
import com.tfswufe.resume.domain.query.AdvertiseQuery;
import com.tfswufe.resume.domain.vo.portal.PortalAdvertiseVO;
import com.tfswufe.resume.service.AdvertiseService;
import com.tfswufe.resume.utils.mybatisplus.QueryUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author hc
 * @date 2025-07-13 10:16
 */
@RestController
@RequestMapping("/portal/advertise")
public class PortalAdvertiseController {
    @Resource
    private AdvertiseService advertiseService;
    @Resource
    private AdvertiseConverter advertiseConverter;

    @GetMapping("/getRecommend")
    public ResultBean<List<PortalAdvertiseVO>> getRecommend(AdvertiseQuery query) {
        query.setColumns(QueryUtil.getColumns(PortalAdvertiseVO.class));
        query.setPageNum(1);
        query.setPageSize(6);
        final PageBean<Advertise> advertisePageBean = advertiseService.getPageBean(query);

        final List<Advertise> advertiseList = advertisePageBean.getRecords();
        final List<PortalAdvertiseVO> portalAdvertiseVOList = advertiseConverter.advertiseList2portalAdvertiseVOList(advertiseList);
        return ResultBeanUtil.success(portalAdvertiseVOList);
    }

}
