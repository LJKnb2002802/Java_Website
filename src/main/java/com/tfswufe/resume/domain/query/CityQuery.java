package com.tfswufe.resume.domain.query;


import com.tfswufe.resume.bean.base.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description="城市")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityQuery extends BaseQuery {
    /**
     * 市名
     */
    @Schema(description="市名")
    private String name;

    /**
     * 编码：对应身份证前4位
     */
    @Schema(description="编码：对应身份证前4位")
    private String code;

    /**
     * 省编号
     */
    @Schema(description="省编号")
    private Long provinceId;

    /**
     * 显示优先级
     */
    @Schema(description="显示优先级")
    private Integer priority;

    /**
     * 删除标识
     */
    @Schema(description="删除标识")
    private Boolean deleted;

    /**
     * 状态： 0不可用  1可用
     */
    @Schema(description="状态： 0不可用  1可用")
    private Integer state;

    /**
     * 备注
     */
    @Schema(description="备注")
    private String info;
}
