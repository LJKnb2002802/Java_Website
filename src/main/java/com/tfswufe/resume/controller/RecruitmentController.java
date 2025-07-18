package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.bean.base.BaseController;
import com.tfswufe.resume.bean.base.service.BaseService;
import com.tfswufe.resume.converter.RecruitmentConverter;
import com.tfswufe.resume.domain.entity.Recruitment;
import com.tfswufe.resume.domain.query.RecruitmentQuery;
import com.tfswufe.resume.domain.vo.RecruitmentVO;
import com.tfswufe.resume.service.RecruitmentService;
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
@RequestMapping("/recruitment")
public class RecruitmentController extends BaseController<Recruitment> {
    @Resource
    private RecruitmentService recruitmentService;
    @Resource
    private RecruitmentConverter recruitmentConverter;

    public RecruitmentController(BaseService<Recruitment> baseService) {
        super(baseService);
    }

    @GetMapping("/getPage")
    public ResultBean<PageBean<RecruitmentVO>> getPage(RecruitmentQuery query) {
        query.setColumns(QueryUtil.getColumns(RecruitmentVO.class));
        final PageBean<Recruitment> recruitmentPageBean = recruitmentService.getPageBean(query);
        final PageBean<RecruitmentVO> pageBean = recruitmentConverter.entityPageBean2voPageBean(recruitmentPageBean);
        return ResultBeanUtil.success(pageBean);
    }

}
