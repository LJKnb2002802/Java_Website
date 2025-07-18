package com.tfswufe.resume.domain.vo;

import com.tfswufe.resume.bean.base.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class RecruitmentVO  extends BaseVO {
    /**
     * 职位名称
     */
    @Schema(description="职位名称")
    private String jobTitle;

    /**
     * 职位描述
     */
    @Schema(description="职位描述")
    private String jobDesc;

    /**
     * 职位要求
     */
    @Schema(description="职位要求")
    private String jobRequirements;

    /**
     * 所属部门
     */
    @Schema(description="所属部门")
    private String dname;

    /**
     * 工作地点
     */
    @Schema(description="工作地点")
    private String loc;

    /**
     * 薪资范围
     */
    @Schema(description="薪资范围")
    private String salaryRange;

    /**
     * 经验要求
     */
    @Schema(description="经验要求")
    private String experienceRequired;

    /**
     * 学历要求
     */
    @Schema(description="学历要求")
    private String eduRequired;

    /**
     * 招聘人数
     */
    @Schema(description="招聘人数")
    private Integer recruitmentNumber;

    /**
     * 工作类型(1:全职, 2:兼职, 3:实习)
     */
    @Schema(description="工作类型(1:全职, 2:兼职, 3:实习)")
    private Integer jobType;

    /**
     * 发布时间
     */
    @Schema(description="发布时间")
    private LocalDateTime publishTime;

    /**
     * 结束时间
     */
    @Schema(description="结束时间")
    private LocalDateTime validTime;

    /**
     * 联系人
     */
    @Schema(description="联系人")
    private String contactPerson;

    /**
     * 联系电话
     */
    @Schema(description="联系电话")
    private String contactPhone;

    /**
     * 联系邮箱
     */
    @Schema(description="联系邮箱")
    private String contactEmail;

    /**
     * 公司ID
     */
    @Schema(description="公司ID")
    private Long companyId;

    /**
     * 状态(1:招聘中, 2:已暂停, 3:已结束)
     */
    @Schema(description="状态(1:招聘中, 2:已暂停, 3:已结束)")
    private Integer state;

    /**
     * 备注
     */
    @Schema(description="备注")
    private String info;

    /**
     * 显示优先级
     */
    @Schema(description="显示优先级")
    private Integer priority;

    /**
     * 删除标识
     */
    @Schema(description="删除标识")
    private Boolean deleted;
}
