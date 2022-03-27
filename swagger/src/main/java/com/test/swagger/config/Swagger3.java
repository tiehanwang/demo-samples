package com.test.swagger.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName: Swagger3
 * @Description: docket类
 * @Author: TIEHAN WANG
 * @Date: 2022/3/26 14:48
 * @Version: v1.0
 */
@Configuration
public class Swagger3 {

    @Bean
    public Docket docket(Environment environment){
        //获取profiles
        Profiles profile = Profiles.of("dev");
        //确认当前环境是否是dev 方便下面enable选择是否启动 也可用下方注释代码找activeProfile
        boolean b = environment.acceptsProfiles(profile);

//        String[] activeProfiles = environment.getActiveProfiles();
//        for (String activeProfile : activeProfiles) {
//            System.out.println(activeProfile);
//        }
        System.out.println(b);
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("helloGroup")
                .enable(b)
                .select()
                //扫描只包含ApiOperation的注解，这种方式灵活 也可选用ClassAnnotation
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //过滤
                .paths(PathSelectors.any())
                .build();
                //扫描指定的包
//              .apis(RequestHandlerSelectors.basePackage("com.test.swagger.controller"))

    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().contact(new Contact("Kim","","xyz@qq.com"))
                .title("SwaggerTest").description("hello").build();
    }
}
