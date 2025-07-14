package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.query.CompanyQuery;
import com.tfswufe.resume.domain.vo.CompanyVO;
import com.tfswufe.resume.service.CompanyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Resource
    private CompanyService companyService;

    @GetMapping("/getPage")
    public ResultBean<PageBean<CompanyVO>> getPage(CompanyQuery query) {
        final PageBean<CompanyVO> pageBean = companyService.getPageBean(query);
        return ResultBean.ResultBeanUtil.success(pageBean);
    }

    @GetMapping("/getDetails/{id}")
    public ResultBean<Company> getDetails(@PathVariable("id")Long id){
        final Company company = companyService.getById(id);
        return ResultBean.ResultBeanUtil.success(company);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<Void> delete(@PathVariable("id")Long id){
        companyService.removeById(id);
        return ResultBean.ResultBeanUtil.success("根据ID删除单个用户成功",null);
    }

    @GetMapping("/deletes/{ids}")
    public ResultBean<Void> deletes(@PathVariable("ids") String ids){
        final List<String> idList = Arrays.stream(ids.split(",")).toList();
        companyService.removeByIds(idList);
        return ResultBean.ResultBeanUtil.success("根据ID批量删除用户成功",null);
    }

    @PostMapping("/saveOrUpdate")
    public ResultBean<Void> saveOrUpdate(@RequestBody Company company){
        companyService.saveOrUpdate(company);
        return ResultBean.ResultBeanUtil.success("添加或修改用户成功！",null);
    }
}
