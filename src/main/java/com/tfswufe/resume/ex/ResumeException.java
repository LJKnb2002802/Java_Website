package com.tfswufe.resume.ex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author hc
 * @date 2025-07-15 10:27
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResumeException extends RuntimeException{
    private Integer code;
    private String msg;
    public ResumeException( String msg) {
        super(msg);
        this.msg = msg;
    }
}
