package com.tfswufe.resume.domain.query;

import com.tfswufe.resume.bean.base.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 公司
 */
@Schema(description="公司")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyQuery extends BaseQuery {
    /**
     * 企业名称
     */
    @Schema(description="企业名称")
    private String name;

    /**
     * 官网
     */
    @Schema(description="官网")
    private String website;

    /**
     * 详细地址
     */
    @Schema(description="详细地址")
    private String addr;

    /**
     * 电话
     */
    @Schema(description="电话")
    private String phone;

    /**
     * 备注
     */
    @Schema(description="备注")
    private String info;

    /**
     * 状态
     */
    @Schema(description="状态")
    private Integer state;

    /**
     * 创建时间
     */
    @Schema(description="创建时间")
    private LocalDateTime[] createTime;

}