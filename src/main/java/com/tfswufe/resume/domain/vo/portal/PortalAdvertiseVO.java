package com.tfswufe.resume.domain.vo.portal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 广告：轮播图
 */
@Schema(description="广告：轮播图")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PortalAdvertiseVO{
    /**
     * 编号
     */
    @Schema(description = "编号")
    private Long id;

    /**
     * 名称
     */
    @Schema(description="名称")
    private String name;

    /**
     * 图片
     */
    @Schema(description="图片")
    private String pic;

    /**
     * 超连接
     */
    @Schema(description="超连接")
    private String url;
}
