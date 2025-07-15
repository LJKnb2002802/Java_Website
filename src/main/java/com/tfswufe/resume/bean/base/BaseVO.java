package com.tfswufe.resume.bean.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 *
 * @author hc
 * @date 2025-07-15 8:17
 */
@Schema(description="视图基类")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseVO {
    /**
     * 编号
     */
    @Schema(description="编号")
    private Long id;

    /**
     * 创建时间
     */
    @Schema(description="创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}