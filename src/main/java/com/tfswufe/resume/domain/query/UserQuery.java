package com.tfswufe.resume.domain.query;

import com.tfswufe.resume.bean.base.BaseQuery;
import com.tfswufe.resume.utils.mybatisplus.Logic;
import com.tfswufe.resume.utils.mybatisplus.annos.Between;
import com.tfswufe.resume.utils.mybatisplus.annos.EQ;
import com.tfswufe.resume.utils.mybatisplus.annos.Like;
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
    @Like
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 性别
     */
    @EQ(logic = Logic.OR)
    @Schema(description = "性别")
    private Boolean gender;

    /**
     * 生日
     */
    @Between
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