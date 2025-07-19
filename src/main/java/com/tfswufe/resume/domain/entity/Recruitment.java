package com.tfswufe.resume.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tfswufe.resume.bean.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 招聘信息
 */
@Schema(description = "招聘信息")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_recruitment")
public class Recruitment extends BaseEntity {
    /**
     * 职位名称
     */
    @TableField(value = "job_title")
    @Schema(description = "职位名称")
    private String jobTitle;

    /**
     * 职位描述
     */
    @TableField(value = "job_desc")
    @Schema(description = "职位描述")
    private String jobDesc;

    /**
     * 职位要求
     */
    @TableField(value = "job_requirements")
    @Schema(description = "职位要求")
    private String jobRequirements;

    /**
     * 所属部门
     */
    @TableField(value = "dname")
    @Schema(description = "所属部门")
    private String dname;

    /**
     * 工作地点
     */
    @TableField(value = "loc")
    @Schema(description = "工作地点")
    private String loc;

    /**
     * 薪资范围
     */
    @TableField(value = "salary_range")
    @Schema(description = "薪资范围")
    private String salaryRange;

    /**
     * 经验要求
     */
    @TableField(value = "experience_required")
    @Schema(description = "经验要求")
    private String experienceRequired;

    /**
     * 学历要求
     */
    @TableField(value = "edu_required")
    @Schema(description = "学历要求")
    private String eduRequired;

    /**
     * 职位需求
     */
    @TableField(value = "job_requires")
    @Schema(description = "职位需求")
    private String jobRequires;

    /**
     * 招聘人数
     */
    @TableField(value = "recruitment_number")
    @Schema(description = "招聘人数")
    private Integer recruitmentNumber;

    /**
     * 工作类型(1:全职, 2:兼职, 3:实习)
     */
    @TableField(value = "job_type")
    @Schema(description = "工作类型(1:全职, 2:兼职, 3:实习)")
    private Integer jobType;

    /**
     * 发布时间
     */
    @TableField(value = "publish_time")
    @Schema(description = "发布时间")
    private LocalDateTime publishTime;

    /**
     * 结束时间
     */
    @TableField(value = "valid_time")
    @Schema(description = "结束时间")
    private LocalDateTime validTime;

    /**
     * 联系人
     */
    @TableField(value = "contact_name")
    @Schema(description = "联系人")
    private String contactName;

    /**
     * 联系人头像
     */
    @TableField(value = "contact_avatar")
    @Schema(description = "联系人头像")
    private String contactAvatar;

    /**
     * 联系电话
     */
    @TableField(value = "contact_phone")
    @Schema(description = "联系电话")
    private String contactPhone;

    /**
     * 联系邮箱
     */
    @TableField(value = "contact_email")
    @Schema(description = "联系邮箱")
    private String contactEmail;

    /**
     * 联系人职务
     */
    @TableField(value = "contact_duty")
    @Schema(description = "联系人职务")
    private String contactDuty;

    /**
     * 公司ID
     */
    @TableField(value = "company_id")
    @Schema(description = "公司ID")
    private Long companyId;

    /**
     * 公司名称
     */
    @TableField(value = "company_name")
    @Schema(description = "公司名称")
    private String companyName;

    /**
     * 状态(1:招聘中, 2:已暂停, 3:已结束)
     */
    @TableField(value = "`state`")
    @Schema(description = "状态(1:招聘中, 2:已暂停, 3:已结束)")
    private Integer state;

    /**
     * 备注
     */
    @TableField(value = "info")
    @Schema(description = "备注")
    private String info;

    /**
     * 显示优先级
     */
    @TableField(value = "priority")
    @Schema(description = "显示优先级")
    private Integer priority;

    /**
     * 删除标识
     */
    @TableField(value = "deleted")
    @Schema(description = "删除标识")
    private Boolean deleted;
}