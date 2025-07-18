package com.tfswufe.resume.domain.query;

import com.tfswufe.resume.bean.base.BaseQuery;
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
public class RecruitmentQuery extends BaseQuery {
    /**
     * 职位名称
     */
    @Schema(description = "职位名称")
    private String jobTitle;

    /**
     * 职位描述
     */
    @Schema(description = "职位描述")
    private String jobDesc;

    /**
     * 职位需求
     */
    @Schema(description = "职位需求")
    private String jobRequires;

    /**
     * 职位要求
     */
    @Schema(description = "职位要求")
    private String jobRequirements;

    /**
     * 所属部门
     */
    @Schema(description = "所属部门")
    private String dname;

    /**
     * 工作地点
     */
    @Schema(description = "工作地点")
    private String loc;

    /**
     * 薪资范围
     */
    @Schema(description = "薪资范围")
    private String salaryRange;

    /**
     * 经验要求
     */
    @Schema(description = "经验要求")
    private String experienceRequired;

    /**
     * 学历要求
     */
    @Schema(description = "学历要求")
    private String eduRequired;

    /**
     * 工作类型(1:全职, 2:兼职, 3:实习)
     */
    @Schema(description = "工作类型(1:全职, 2:兼职, 3:实习)")
    private Integer jobType;

    /**
     * 发布时间
     */
    @Schema(description = "发布时间")
    private LocalDateTime publishTime;

    /**
     * 公司名称
     */
    @Schema(description = "公司名称")
    private String companyName;

    /**
     * 状态(1:招聘中, 2:已暂停, 3:已结束)
     */

    @Schema(description = "状态(1:招聘中, 2:已暂停, 3:已结束)")
    private Integer state;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String info;
}
