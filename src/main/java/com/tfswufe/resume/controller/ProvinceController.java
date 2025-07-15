package com.tfswufe.resume.controller;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.converter.ProvinceConverter;
import com.tfswufe.resume.domain.entity.Province;
import com.tfswufe.resume.domain.query.ProvinceQuery;
import com.tfswufe.resume.domain.vo.ProvinceVO;
import com.tfswufe.resume.service.ProvinceService;
import com.tfswufe.resume.utils.QueryUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hc
 * @date 2025-07-13 10:16
 */
@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Resource
    private ProvinceService provinceService;
    @Resource
    private ProvinceConverter provinceConverter;

    @GetMapping("/getPage")
    public ResultBean<PageBean<ProvinceVO>> getPage(ProvinceQuery query) {
        query.setColumns(QueryUtil.getColumns(ProvinceVO.class));
        final PageBean<Province> provincePageBean = provinceService.getPageBean(query);
        final PageBean<ProvinceVO> pageBean = provinceConverter.entityPageBean2voPageBean(provincePageBean);
        return ResultBeanUtil.success(pageBean);
    }

    @GetMapping("/getDetails/{id}")
    public ResultBean<Province> getDetails(@PathVariable("id")Long id){
        final Province province = provinceService.getById(id);
        return ResultBeanUtil.success(province);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<Void> delete(@PathVariable("id")Long id){
        provinceService.removeById(id);
        return ResultBeanUtil.success("根据ID删除单个省份成功",null);
    }

    @GetMapping("/deletes/{ids}")
    public ResultBean<Void> deletes(@PathVariable("ids") String ids){
        final List<String> idList = Arrays.stream(ids.split(",")).toList();
        provinceService.removeByIds(idList);
        return ResultBeanUtil.success("根据ID批量删除省份成功",null);
    }

    @PostMapping("/saveOrUpdate")
    public ResultBean<Void> saveOrUpdate(@RequestBody Province province){
        provinceService.saveOrUpdate(province);
        return ResultBeanUtil.success("添加或修改省份成功！",null);
    }

}