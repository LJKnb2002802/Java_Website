package com.tfswufe.resume.aop;

import com.tfswufe.resume.domain.entity.Log;
import com.tfswufe.resume.service.LogService;
import com.tfswufe.resume.utils.IPUtil;
import com.tfswufe.resume.utils.JsonUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author hc
 * @date 2025-07-16 8:07
 */
@Slf4j
@Aspect
@Component
public class LogAspect {
    @Resource
    private HttpServletRequest request;
    @Resource
    private LogService logService;

    @Around("execution(* com.tfswufe.resume.controller.*.*(..))")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.nanoTime();
        final String ip = IPUtil.getIpAddr(request);
        final String uri = request.getRequestURI();
        final String method = request.getMethod();
        final Map<String, String[]> parameterMap = request.getParameterMap();
        final String paramterJson = JsonUtil.obj2string(parameterMap);
        Object result = joinPoint.proceed();
        final long duration = System.nanoTime() - start;
        log.info("请求来源：{}，请求地址：{}，请求方式：{}，参数：{}，返回结果：{}，耗时：{}ms",ip, uri, method, paramterJson, JsonUtil.obj2string(result), duration / 1000000);
        return result;
    }

    @Around("execution(* com.tfswufe.resume.controller.*.*(..))")
    public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.nanoTime();
        final String ip = IPUtil.getIpAddr(request);
        final String uri = request.getRequestURI();
        final String methodType = request.getMethod();
        final Map<String, String[]> parameterMap = request.getParameterMap();
        final String paramterJson = JsonUtil.obj2string(parameterMap);
        Object result = joinPoint.proceed();
        final long duration = System.nanoTime() - start;

        // 获取被拦截的方法对象
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        // 获取方法上的指定注解
        if (method.isAnnotationPresent(LogAnnotation.class)) {
            //将日志信息保存到数据库
            final Log logBean = new Log();
            logBean.setIp(ip);
            logBean.setUrl(uri);
            logBean.setMethod(methodType);
            logBean.setParams(paramterJson);
            logBean.setDuration(duration);
            logBean.setResult(JsonUtil.obj2string(result));
            logBean.setDeleted(false);
            logBean.setState(1);
            logBean.setCreateTime(LocalDateTime.now());
            logService.save(logBean);
        }

        return result;
    }

}
