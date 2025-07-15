package com.tfswufe.resume.domain.vo;


import com.tfswufe.resume.bean.base.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description="省")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceVO extends BaseVO {
    /**
     * 省名
     */
    @Schema(description="省名")
    private String name;

    /**
     * 编码：对应身份证前2位
     */
    @Schema(description="编码：对应身份证前2位")
    private String code;

    /**
     * 状态： 0不可用  1可用
     */
    @Schema(description="状态： 0不可用  1可用")
    private Integer state;
}
