package com.tfswufe.resume.controller.portal;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.converter.RecruitmentConverter;
import com.tfswufe.resume.domain.entity.Recruitment;
import com.tfswufe.resume.domain.query.RecruitmentQuery;
import com.tfswufe.resume.domain.vo.portal.PortalRecruitmentVO;
import com.tfswufe.resume.service.RecruitmentService;
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
@RequestMapping("/portal/recruitment")
public class PortalRecruitmentController {
    @Resource
    private RecruitmentService recruitmentService;
    @Resource
    private RecruitmentConverter recruitmentConverter;

    @GetMapping("/getPage")
    public ResultBean<PageBean<PortalRecruitmentVO>> getPage(RecruitmentQuery query) {
        query.setColumns(QueryUtil.getColumns(PortalRecruitmentVO.class));
        final String keywords = query.getKeywords();
        if (keywords != null) {
            query.setJobTitle(keywords);
            query.setJobDesc(keywords);
            query.setCompanyName(keywords);
        }

        final PageBean<Recruitment> recruitmentPageBean = recruitmentService.getPageBean(query);
        final PageBean<PortalRecruitmentVO> pageBean = recruitmentConverter.recruitmentPageBean2portalRecruitmentVOPageBean(recruitmentPageBean);
        return ResultBeanUtil.success(pageBean);
    }

}