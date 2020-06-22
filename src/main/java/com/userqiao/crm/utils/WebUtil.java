package com.userqiao.crm.utils;


import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * web 相关的工具类
 *
 * @author userqiao
 */
public class WebUtil {

    /**
     * 获取请求地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((StrUtil.isEmpty(ip)) || ("unknown".equals(ip))) {
            ip = request.getRemoteAddr();
            if ((ip.equals("127.0.0.1"))
                    || (ip.equals("0:0:0:0:0:0:0:1"))) {
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }

        if ((ip != null) && (ip.length() > 15)
                && (ip.indexOf(",") > 0)) {
            ip = ip.substring(0, ip.indexOf(","));
        }

        return ip;
    }

}
