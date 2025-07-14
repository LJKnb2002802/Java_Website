package com.tfswufe.resume.bean;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tfswufe.resume.utils.JsonUtil;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageBean<E> {
    /**
     * 页码
     */
    private Long pageNum;
    /**
     * 页面大小
     */
    private Long pageSize;
    /**
     * 一共有多少页
     */
    private Long pages;
    /**
     * 当前页的数据
     */
    private List<E> records;

    public static <E> PageBean<E> page2pageBean(IPage<E> page){
        if(page==null){
            return null;
        }
        final PageBean<E> pageBean = new PageBean<>();
        pageBean.setPageNum(page.getCurrent());
        pageBean.setPageSize(page.getSize());
        pageBean.setPages(page.getPages());
        pageBean.setRecords(page.getRecords());
        return pageBean;
    }

    @Override
    public String toString() {
        return JsonUtil.obj2string(this);
    }
}
