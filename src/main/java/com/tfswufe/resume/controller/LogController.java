package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.bean.base.BaseController;
import com.tfswufe.resume.bean.base.service.BaseService;
import com.tfswufe.resume.converter.LogConverter;
import com.tfswufe.resume.domain.entity.Log;
import com.tfswufe.resume.domain.query.LogQuery;
import com.tfswufe.resume.domain.vo.LogVO;
import com.tfswufe.resume.service.LogService;
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
@RequestMapping("/log")
public class LogController extends BaseController<Log> {
    @Resource
    private LogService logService;
    @Resource
    private LogConverter logConverter;

    public LogController(BaseService<Log> baseService) {
        super(baseService);
    }

    @GetMapping("/getPage")
    public ResultBean<PageBean<LogVO>> getPage(LogQuery query) {
        query.setColumns(QueryUtil.getColumns(LogVO.class));
        final PageBean<Log> logPageBean = logService.getPageBean(query);
        final PageBean<LogVO> pageBean = logConverter.entityPageBean2voPageBean(logPageBean);
        return ResultBeanUtil.success(pageBean);
    }

}
