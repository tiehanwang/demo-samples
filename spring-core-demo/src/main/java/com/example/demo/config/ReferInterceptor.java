package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * @ClassName: ReferInterceptor
 * @Description: Refer头拦截
 * @Author: TIEHAN WANG
 * @Date: 2022/6/21 20:22
 * @Version: v1.0
 */
@Component
@Slf4j
public class ReferInterceptor implements HandlerInterceptor {
	private RefererProperties refererProperties;

	@Autowired
	public ReferInterceptor(RefererProperties refererProperties){
		this.refererProperties = refererProperties;
	}

	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) {

		//是否开启
		if(!refererProperties.getEnable()) return true;
		String referer = request.getHeader("referer");
		String serverName = request.getServerName();
		if(referer == null) return false;
		URL url;
		try {
			//校验url
			url = new URL(referer);
		} catch (MalformedURLException e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		String refererUrl = url.getHost();
		//请求域和refer来源域正常不一样
		if(!serverName.equals(refererUrl)){
			log.info("RefererInterceptorConfig-->\nrefererUrl：{}\nhost：{}\nrefererProperties：{}", refererUrl, serverName, refererProperties);
			//是否符合值
			if(refererProperties.getReferDomain()!= null){
				for (String s : refererProperties.getReferDomain()) {
					if(s.equals(refererUrl)){
						return true;
					}
				}
			}
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return false;
		}
		return true;
	}
}
