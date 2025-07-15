package com.tfswufe.resume.ex;

import com.tfswufe.resume.bean.ResultBean;
import com.tfswufe.resume.bean.ResultBean.ResultBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author hc
 * @date 2025-07-15 10:15
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultBean<String> handleException(Exception e) {
        e.printStackTrace();
        log.error("服务器异常：{}",e.getMessage());
        return ResultBeanUtil.error("服务器异常",null);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResultBean<String> handleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        log.error("服务器异常：{}",e.getMessage());
        return ResultBeanUtil.error("服务器异常",null);
    }

    @ExceptionHandler(ResumeException.class)
    public ResultBean<String> handleRuntimeException(ResumeException e) {
        e.printStackTrace();
        log.error("服务器异常：{}",e.getMessage());
        return ResultBeanUtil.error("服务器异常",null);
    }


}
