package com.tfswufe.resume.bean.base;
import com.tfswufe.resume.config.GlobalConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 *
 * @author hc
 * @date 2025-07-13 14:06
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseQuery {
    /**
     * 页码
     */
    @Schema(description="页码")
    private Integer pageNum;
    /**
     * 页面大小
     */
    @Schema(description="页面大小")
    private Integer pageSize;

    /**
     * 关键字
     */
    @Schema(description="关键字")
    private String keywords;

    /**
     * 待查询字段
     * @return
     */
    private List<String> columns;

    public Integer getPageNum() {
        return pageNum ==null?1: pageNum;
    }

    public Integer getPageSize() {
        return pageSize ==null? GlobalConstant.PAGE_SIZE:pageSize;
    }
}