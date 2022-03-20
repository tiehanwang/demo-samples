package com.ali.nacos.consumer;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.UrlCleaner;
import com.alibaba.csp.sentinel.annotation.SentinelResource;

/**
 * @ClassName: UrlCleaner
 * @Description: 域名过滤
 * @Author: TIEHAN WANG
 * @Date: 2022/3/20 16:34
 * @Version: v1.0
 */
public class RestUrlCleaner{

    public static String urlClean(String url) {
        System.out.println("enter urlCleaner");
        if (url.matches(".*/echo/.*")) {
            System.out.println("change url");
            url = url.replaceAll("/echo/.*", "/echo/{str}");
        }
        return url;
    }
}
