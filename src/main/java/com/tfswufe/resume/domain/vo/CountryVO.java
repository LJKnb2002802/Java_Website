package com.tfswufe.resume.domain.vo;


import com.tfswufe.resume.bean.base.BaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description="县")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryVO extends BaseVO {
    /**
     * 县名
     */
    @Schema(description="县名")
    private String name;

    /**
     * 编码：对应身份证前6位
     */
    @Schema(description="编码：对应身份证前6位")
    private Integer code;

    /**
     * 状态： 0不可用  1可用
     */
    @Schema(description="状态： 0不可用  1可用")
    private Integer state;
}
