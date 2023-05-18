package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: RefererProperties
 * @Description: Refer头配置
 * @Author: TIEHAN WANG
 * @Date: 2022/6/21 20:18
 * @Version: v1.0
 */
@Component
@ConfigurationProperties(prefix = "referer")
@Data
public class RefererProperties {
	private Boolean enable = false;
	private List<String> referDomain;

}
