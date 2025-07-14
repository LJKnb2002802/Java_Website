package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.converter.CityConverter;
import com.tfswufe.resume.converter.CompanyConverter;
import com.tfswufe.resume.domain.entity.City;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.query.CityQuery;
import com.tfswufe.resume.domain.query.CompanyQuery;
import com.tfswufe.resume.domain.vo.CityVo;
import com.tfswufe.resume.domain.vo.CompanyVO;
import com.tfswufe.resume.service.CityService;
import com.tfswufe.resume.service.CompanyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Resource
    private CityService cityService;
    @Resource
    private CityConverter cityConverter;

    @GetMapping("/getPage")
    public ResultBean<PageBean<CityVo>> getPage(CityQuery query) {
        final PageBean<City> cityPageBean = cityService.getPageBean(query);
        final PageBean<CityVo> pageBean = cityConverter.entityPageBean2voPageBean(cityPageBean);
        return ResultBean.ResultBeanUtil.success(pageBean);
    }

    @GetMapping("/getDetails/{id}")
    public ResultBean<City> getDetails(@PathVariable("id")Long id){
        final City city = cityService.getById(id);
        return ResultBean.ResultBeanUtil.success(city);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<Void> delete(@PathVariable("id")Long id){
        cityService.removeById(id);
        return ResultBean.ResultBeanUtil.success("根据ID删除单个用户成功",null);
    }

    @GetMapping("/deletes/{ids}")
    public ResultBean<Void> deletes(@PathVariable("ids") String ids){
        final List<String> idList = Arrays.stream(ids.split(",")).toList();
        cityService.removeByIds(idList);
        return ResultBean.ResultBeanUtil.success("根据ID批量删除用户成功",null);
    }

    @PostMapping("/saveOrUpdate")
    public ResultBean<Void> saveOrUpdate(@RequestBody City city){
        cityService.saveOrUpdate(city);
        return ResultBean.ResultBeanUtil.success("添加或修改用户成功！",null);
    }
}
