package com.tfswufe.resume.domain.vo;


import com.tfswufe.resume.bean.base.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description="轮播图")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiseVO extends BaseVO {
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

    /**
     * 显示优先级
     */
    @Schema(description="显示优先级")
    private Integer priority;
}
