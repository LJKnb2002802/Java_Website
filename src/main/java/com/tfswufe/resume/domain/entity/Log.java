package com.tfswufe.resume.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tfswufe.resume.bean.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 操作日志
 */
@Schema(description="操作日志")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_log")
public class Log extends BaseEntity {
    /**
     * 操作人员编号
     */
    @TableField(value = "user_id")
    @Schema(description="操作人员编号")
    private Long userId;

    /**
     * 用户账户
     */
    @TableField(value = "account")
    @Schema(description="用户账户")
    private String account;

    /**
     * 执行操作时所使用的IP
     */
    @TableField(value = "ip")
    @Schema(description="执行操作时所使用的IP")
    private String ip;

    /**
     * 请求URL
     */
    @TableField(value = "url")
    @Schema(description="请求URL")
    private String url;

    /**
     * 调用的方法
     */
    @TableField(value = "`method`")
    @Schema(description="调用的方法")
    private String method;

    /**
     * 请求参数
     */
    @TableField(value = "params")
    @Schema(description="请求参数")
    private String params;

    /**
     * 耗时
     */
    @TableField(value = "duration")
    @Schema(description="耗时")
    private Long duration;

    /**
     * 返回结果
     */
    @TableField(value = "`result`")
    @Schema(description="返回结果")
    private String result;

    /**
     * 备注
     */
    @TableField(value = "info")
    @Schema(description="备注")
    private String info;

    /**
     * 删除标识
     */
    @TableField(value = "deleted")
    @Schema(description="删除标识")
    private Boolean deleted;

    /**
     * 操作状态
     */
    @TableField(value = "`state`")
    @Schema(description="操作状态")
    private Integer state;
}