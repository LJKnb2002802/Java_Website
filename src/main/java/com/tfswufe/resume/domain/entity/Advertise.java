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
 * 广告：轮播图
 */
@Schema(description="广告：轮播图")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_advertise")
public class Advertise extends BaseEntity {
    /**
     * 名称
     */
    @TableField(value = "`name`")
    @Schema(description="名称")
    private String name;

    /**
     * 图片
     */
    @TableField(value = "pic")
    @Schema(description="图片")
    private String pic;

    /**
     * 超连接
     */
    @TableField(value = "url")
    @Schema(description="超连接")
    private String url;

    /**
     * 显示优先级
     */
    @TableField(value = "priority")
    @Schema(description="显示优先级")
    private Integer priority;

    /**
     * 备注信息
     */
    @TableField(value = "info")
    @Schema(description="备注信息")
    private String info;

    /**
     * 删除标识
     */
    @TableField(value = "deleted")
    @Schema(description="删除标识")
    private Boolean deleted;

    /**
     * 状态
     */
    @TableField(value = "`state`")
    @Schema(description="状态")
    private Integer state;
}