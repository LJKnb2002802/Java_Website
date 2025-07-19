package com.tfswufe.resume.domain.vo;

import com.tfswufe.resume.bean.base.BaseVO;
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
public class RecruitmentVO extends BaseVO {
    /**
     * 职位名称
     */
    @Schema(description = "职位名称")
    private String jobTitle;

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
     * 公司名称
     */
    @Schema(description = "公司名称")
    private String companyName;

    /**
     * 发布时间
     */
    @Schema(description = "发布时间")
    private LocalDateTime publishTime;

    /**
     * 联系人
     */
    @Schema(description = "联系人")
    private String contactPerson;

    /**
     * 联系电话
     */
    @Schema(description = "联系电话")
    private String contactPhone;
}
