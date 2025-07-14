package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.converter.ProvinceConverter;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.entity.Country;
import com.tfswufe.resume.domain.entity.Province;
import com.tfswufe.resume.domain.query.CompanyQuery;
import com.tfswufe.resume.domain.query.ProvinceQuery;
import com.tfswufe.resume.domain.vo.CompanyVO;
import com.tfswufe.resume.domain.vo.CountryVO;
import com.tfswufe.resume.domain.vo.ProvinceVO;
import com.tfswufe.resume.service.CompanyService;
import com.tfswufe.resume.service.ProvinceService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Resource
    private ProvinceService provinceService;
    @Resource
    private ProvinceConverter provinceConverter;

    @GetMapping("/getPage")
    public ResultBean<PageBean<ProvinceVO>> getPage(ProvinceQuery query) {
        final PageBean<Province> provincePageBean = provinceService.getPageBean(query);
        final PageBean<ProvinceVO> pageBean = provinceConverter.entityPageBean2voPageBean(provincePageBean);
        return ResultBean.ResultBeanUtil.success(pageBean);
    }

    @GetMapping("/getDetails/{id}")
    public ResultBean<Province> getDetails(@PathVariable("id")Long id){
        final Province province = provinceService.getById(id);
        return ResultBean.ResultBeanUtil.success(province);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<Void> delete(@PathVariable("id")Long id){
        provinceService.removeById(id);
        return ResultBean.ResultBeanUtil.success("根据ID删除单个用户成功",null);
    }

    @GetMapping("/deletes/{ids}")
    public ResultBean<Void> deletes(@PathVariable("ids") String ids){
        final List<String> idList = Arrays.stream(ids.split(",")).toList();
        provinceService.removeByIds(idList);
        return ResultBean.ResultBeanUtil.success("根据ID批量删除用户成功",null);
    }

    @PostMapping("/saveOrUpdate")
    public ResultBean<Void> saveOrUpdate(@RequestBody Province province){
        provinceService.saveOrUpdate(province);
        return ResultBean.ResultBeanUtil.success("添加或修改用户成功！",null);
    }
}
