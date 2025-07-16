package com.tfswufe.resume.utils;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 从http请求中获取ip地址
 *
 * @author hc
 */
public class IPUtil {

    /**
     * 获取IP地址
     *
     * @param request HttpServletRequest对象，用于获取请求头信息
     * @return 返回客户端的IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        // 尝试从请求头中获取X-Real-IP，这是Nginx等反向代理服务器设置的头信息
        String ip = request.getHeader("X-Real-IP");
        if (ip != null && ip.trim().length() > 0 && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }

        // 如果X-Real-IP不可用，则尝试从X-Forwarded-For获取IP，这通常是由客户端或代理服务器设置的
        ip = request.getHeader("X-Forwarded-For");
        if (ip != null && ip.trim().length() > 0 && !"unknown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(',');
            if (index != -1) {
                // 如果X-Forwarded-For中有多个IP地址，取第一个为客户端IP
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }

        // 如果上述方法均未能获取到IP地址，则尝试从其他请求头中获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        // 如果所有请求头中均未找到IP地址，则使用request.getRemoteAddr()获取IP
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 返回最终获取到的IP地址
        return ip;
    }

}

