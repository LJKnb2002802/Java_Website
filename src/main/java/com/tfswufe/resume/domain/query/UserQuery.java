package com.tfswufe.resume.domain.query;

import com.tfswufe.resume.bean.base.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author hc
 * @date 2025-07-13 14:07
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserQuery extends BaseQuery {
    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 性别
     */
    @Schema(description = "性别")
    private Boolean gender;

    /**
     * 生日
     */
    @Schema(description = "生日")
    private LocalDate[] birth;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 电话
     */
    @Schema(description = "电话")
    private String phone;

    /**
     * 账户
     */
    @Schema(description = "账户")
    private String account;

    /**
     * 简介
     */
    @Schema(description = "简介")
    private String info;

    /**
     * 状态
     */
    @Schema(description = "状态")
    private Integer state;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime[] createTime;
}