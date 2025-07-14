package com.tfswufe.resume.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tfswufe.resume.bean.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 公司
 */
@Schema(description="公司")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_company")
public class Company extends BaseEntity {
    /**
     * 企业名称
     */
    @TableField(value = "`name`")
    @Schema(description="企业名称")
    private String name;

    /**
     * 官网
     */
    @TableField(value = "website")
    @Schema(description="官网")
    private String website;

    /**
     * 图片集
     */
    @TableField(value = "pics")
    @Schema(description="图片集")
    private String pics;

    /**
     * 县区编号
     */
    @TableField(value = "country_id")
    @Schema(description="县区编号")
    private Long countryId;

    /**
     * 详细地址
     */
    @TableField(value = "addr")
    @Schema(description="详细地址")
    private String addr;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @Schema(description="邮箱")
    private String email;

    /**
     * 电话
     */
    @TableField(value = "phone")
    @Schema(description="电话")
    private String phone;

    /**
     * 显示优先级
     */
    @TableField(value = "priority")
    @Schema(description="显示优先级")
    private Integer priority;

    /**
     * 备注
     */
    @TableField(value = "info")
    @Schema(description="备注")
    private String info;

    /**
     * 删除标识
     */
    @TableField(value = "deleted")
    @Schema(description="删除标识")
    private Boolean deleted;

    /**
     * 状态
     */
    @TableField(value = "`state`")
    @Schema(description="状态")
    private Integer state;
}