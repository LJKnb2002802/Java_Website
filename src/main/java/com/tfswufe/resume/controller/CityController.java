package com.tfswufe.resume.controller;
import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.converter.CityConverter;
import com.tfswufe.resume.domain.entity.City;
import com.tfswufe.resume.domain.query.CityQuery;
import com.tfswufe.resume.domain.vo.CityVO;
import com.tfswufe.resume.service.CityService;
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
@RequestMapping("/city")
public class CityController {
    @Resource
    private CityService cityService;
    @Resource
    private CityConverter cityConverter;

    @GetMapping("/getPage")
    public ResultBean<PageBean<CityVO>> getPage(CityQuery query) {
        query.setColumns(QueryUtil.getColumns(CityVO.class));
        final PageBean<City> cityPageBean = cityService.getPageBean(query);
        final PageBean<CityVO> pageBean = cityConverter.entityPageBean2voPageBean(cityPageBean);
        return ResultBeanUtil.success(pageBean);
    }

    @GetMapping("/getDetails/{id}")
    public ResultBean<City> getDetails(@PathVariable("id")Long id){
        final City city = cityService.getById(id);
        return ResultBeanUtil.success(city);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<Void> delete(@PathVariable("id")Long id){
        cityService.removeById(id);
        return ResultBeanUtil.success("根据ID删除单个城市成功",null);
    }

    @GetMapping("/deletes/{ids}")
    public ResultBean<Void> deletes(@PathVariable("ids") String ids){
        final List<String> idList = Arrays.stream(ids.split(",")).toList();
        cityService.removeByIds(idList);
        return ResultBeanUtil.success("根据ID批量删除城市成功",null);
    }

    @PostMapping("/saveOrUpdate")
    public ResultBean<Void> saveOrUpdate(@RequestBody City city){
        cityService.saveOrUpdate(city);
        return ResultBeanUtil.success("添加或修改城市成功！",null);
    }

}