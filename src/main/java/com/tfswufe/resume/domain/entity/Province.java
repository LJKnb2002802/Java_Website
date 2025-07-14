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
 * 省
 */
@Schema(description="省")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_province")
public class Province extends BaseEntity {
    /**
     * 省名
     */
    @TableField(value = "`name`")
    @Schema(description="省名")
    private String name;

    /**
     * 编码：对应身份证前2位
     */
    @TableField(value = "code")
    @Schema(description="编码：对应身份证前2位")
    private String code;

    /**
     * 显示优先级
     */
    @TableField(value = "priority")
    @Schema(description="显示优先级")
    private Integer priority;

    /**
     * 删除标识
     */
    @TableField(value = "deleted")
    @Schema(description="删除标识")
    private Boolean deleted;

    /**
     * 状态： 0不可用  1可用
     */
    @TableField(value = "`state`")
    @Schema(description="状态： 0不可用  1可用")
    private Integer state;

    /**
     * 备注
     */
    @TableField(value = "info")
    @Schema(description="备注")
    private String info;
}