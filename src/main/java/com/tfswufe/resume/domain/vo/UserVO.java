package com.tfswufe.resume.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO {
    /**
     * 编号
     */
    @Schema(description = "编号")
    private Long id;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 头像
     */
    @Schema(description = "头像")
    private String avatar;

    /**
     * 性别
     */
    @Schema(description = "性别")
    private Boolean gender;

    /**
     * 生日
     */
    @Schema(description = "生日")
    private LocalDate birth;

    /**
     * 电话
     */
    @Schema(description = "电话")
    private String phone;

    /**
     * 用户等级：从低到高1-5
     */
    @Schema(description = "用户等级")
    private Integer level;

    /**
     * 状态
     */
    @Schema(description = "状态")
    private Integer state;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
}