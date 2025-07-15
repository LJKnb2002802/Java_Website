package com.tfswufe.resume.domain.query;


import com.tfswufe.resume.bean.base.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description="日志")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogQuery extends BaseQuery {
    /**
     * 操作人员编号
     */
    @Schema(description="操作人员编号")
    private Long userId;

    /**
     * 用户账户
     */
    @Schema(description="用户账户")
    private String account;

    /**
     * 执行操作时所使用的IP
     */
    @Schema(description="执行操作时所使用的IP")
    private String ip;

    /**
     * 请求URL
     */
    @Schema(description="请求URL")
    private String url;

    /**
     * 调用的方法
     */
    @Schema(description="调用的方法")
    private String method;

    /**
     * 请求参数
     */
    @Schema(description="请求参数")
    private String params;

    /**
     * 耗时
     */
    @Schema(description="耗时")
    private Long duration;

    /**
     * 返回结果
     */
    @Schema(description="返回结果")
    private String result;

    /**
     * 备注
     */
    @Schema(description="备注")
    private String info;

    /**
     * 删除标识
     */
    @Schema(description="删除标识")
    private Boolean deleted;

    /**
     * 操作状态
     */
    @Schema(description="操作状态")
    private Integer state;
}
