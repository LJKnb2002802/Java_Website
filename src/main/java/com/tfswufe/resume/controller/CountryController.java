package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.converter.CountryConverter;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.entity.Country;
import com.tfswufe.resume.domain.query.CompanyQuery;
import com.tfswufe.resume.domain.query.CountryQuery;
import com.tfswufe.resume.domain.vo.CompanyVO;
import com.tfswufe.resume.domain.vo.CountryVO;
import com.tfswufe.resume.domain.vo.UserVO;
import com.tfswufe.resume.service.CompanyService;
import com.tfswufe.resume.service.CountryService;
import com.tfswufe.resume.utils.QueryUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Resource
    private CountryService countryService;
    @Resource
    private CountryConverter countryConverter;

    @GetMapping("/getPage")
    public ResultBean<PageBean<CountryVO>> getPage(CountryQuery query) {
        query.setColumns(QueryUtil.getColumns(CountryVO.class));
        final PageBean<Country> countryPageBean = countryService.getPageBean(query);
        final PageBean<CountryVO> pageBean = countryConverter.entityPageBean2voPageBean(countryPageBean);
        return ResultBean.ResultBeanUtil.success(pageBean);
    }

    @GetMapping("/getDetails/{id}")
    public ResultBean<Country> getDetails(@PathVariable("id")Long id){
        final Country country = countryService.getById(id);
        return ResultBean.ResultBeanUtil.success(country);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<Void> delete(@PathVariable("id")Long id){
        countryService.removeById(id);
        return ResultBean.ResultBeanUtil.success("根据ID删除单个用户成功",null);
    }

    @GetMapping("/deletes/{ids}")
    public ResultBean<Void> deletes(@PathVariable("ids") String ids){
        final List<String> idList = Arrays.stream(ids.split(",")).toList();
        countryService.removeByIds(idList);
        return ResultBean.ResultBeanUtil.success("根据ID批量删除用户成功",null);
    }

    @PostMapping("/saveOrUpdate")
    public ResultBean<Void> saveOrUpdate(@RequestBody Country country){
        countryService.saveOrUpdate(country);
        return ResultBean.ResultBeanUtil.success("添加或修改用户成功！",null);
    }
}
