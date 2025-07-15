package com.tfswufe.resume.bean.base;

import com.tfswufe.resume.bean.PageBean;
import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import com.tfswufe.resume.bean.base.service.BaseService;
import com.tfswufe.resume.converter.CompanyConverter;
import com.tfswufe.resume.domain.entity.Company;
import com.tfswufe.resume.domain.query.CompanyQuery;
import com.tfswufe.resume.domain.vo.CompanyVO;
import com.tfswufe.resume.utils.QueryUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hc
 * @date 2025-07-15 8:57
 */
public class BaseController<E> {
    private final BaseService<E> baseService;


    public BaseController(BaseService<E> baseService){
        this.baseService = baseService;
    }

    @GetMapping("/getDetails/{id}")
    public ResultBean<E> getDetails(@PathVariable("id")Long id){
        final E entity = baseService.getById(id);
        return ResultBeanUtil.success(entity);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<Void> delete(@PathVariable("id")Long id){
        baseService.removeById(id);
        return ResultBeanUtil.success("根据ID删除成功",null);
    }

    @GetMapping("/deletes/{ids}")
    public ResultBean<Void> deletes(@PathVariable("ids") String ids){
        final List<String> idList = Arrays.stream(ids.split(",")).toList();
        baseService.removeByIds(idList);
        return ResultBeanUtil.success("根据ID批量删除成功",null);
    }

    @PostMapping("/saveOrUpdate")
    public ResultBean<Void> saveOrUpdate(@RequestBody E entity){
        baseService.saveOrUpdate(entity);
        return ResultBeanUtil.success("添加或修改城市成功！",null);
    }
}
