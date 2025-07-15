package com.tfswufe.resume.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.tfswufe.resume.bean.base.BaseVO;
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
public class CompanyVO extends BaseVO {
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
     * 邮箱
     */
    @Schema(description="邮箱")
    private String email;

    /**
     * 电话
     */
    @Schema(description="电话")
    private String phone;

    /**
     * 状态
     */
    @Schema(description="状态")
    private Integer state;
}