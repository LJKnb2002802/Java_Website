package com.tfswufe.resume.domain.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tfswufe.resume.bean.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("tb_user")
public class User extends BaseEntity {

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    @Schema(description = "头像")
    private String avatar;

    /**
     * 性别
     */
    @TableField(value = "gender")
    @Schema(description = "性别")
    private Boolean gender;

    /**
     * 生日
     */
    @TableField(value = "birth")
    @Schema(description = "生日")
    private LocalDate birth;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @Schema(description = "邮箱")
    private String email;

    /**
     * 电话
     */
    @TableField(value = "phone")
    @Schema(description = "电话")
    private String phone;

    /**
     * 账户
     */
    @TableField(value = "account")
    @Schema(description = "账户")
    private String account;

    /**
     * 加密后的密码
     */
    @TableField(value = "password")
    @Schema(description = "加密后的密码")
    private String password;

    /**
     * 密码盐值
     */
    @TableField(value = "salt")
    @Schema(description = "密码盐值")
    private String salt;

    /**
     * 积分
     */
    @TableField(value = "credit")
    @Schema(description = "积分")
    private Integer credit;

    /**
     * 用户等级：从低到高1-5
     */
    @TableField(value = "level")
    @Schema(description = "用户等级")
    private Integer level;

    /**
     * 显示优先级
     */
    @TableField(value = "priority")
    @Schema(description = "显示优先级")
    private Integer priority;

    /**
     * 公司编号
     */
    @TableField(value = "company_id")
    @Schema(description = "公司编号")
    private Long companyId;

    /**
     * 简介
     */
    @TableField(value = "info")
    @Schema(description = "简介")
    private String info;

    /**
     * 角色编号 1管理员  2普通用户
     */
    @TableField(value = "role_id")
    @Schema(description = "角色编号")
    private Long roleId;

    /**
     * 删除标识
     */
    @TableField(value = "deleted")
    @Schema(description = "删除标识")
    private Boolean deleted;

    /**
     * 状态
     */
    @TableField(value = "state")
    @Schema(description = "状态")
    private Integer state;
}