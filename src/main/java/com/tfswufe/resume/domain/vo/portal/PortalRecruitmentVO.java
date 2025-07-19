package com.tfswufe.resume.domain.vo.portal;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class PortalRecruitmentVO {
    /**
     * 编号
     */
    @Schema(description = "编号")
    private Long id;

    /**
     * 职位名称
     */
    @Schema(description = "职位名称")
    private String jobTitle;
    /**
     * 职位需求
     */
    @Schema(description = "职位需求")
    private String jobRequires;

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
     * 发布时间
     */
    @Schema(description = "发布时间")
    private LocalDateTime publishTime;

    /**
     * 联系人
     */
    @Schema(description = "联系人")
    private String contactName;

    /**
     * 联系人头像
     */
    @Schema(description = "联系人头像")
    private String contactAvatar;

    /**
     * 公司ID
     */
    @Schema(description = "公司ID")
    private Long companyId;

    /**
     * 公司名称
     */
    @Schema(description = "公司名称")
    private String companyName;

    /**
     * 联系人职务
     */
    @Schema(description = "联系人职务")
    private String contactDuty;

    /**
     * 联系电话
     */
    @Schema(description = "联系电话")
    private String contactPhone;
}