package com.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;

/**
 * @ClassName: WebSecurityConfig
 * @Description: 安全配置类
 * @Author: TIEHAN WANG
 * @Date: 2022/4/2 23:59
 * @Version: v1.0
 */

//prePostEnabled属性决定Spring Security在接口前注解是否可用@PreAuthorize,@PostAuthorize等注解,设置为true,会拦截加了这些注解的接口
@Configuration
@EnableWebSecurity  //开启Spring Security的功能
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Resource
//    private AuthenticationSuccessHandler loginSuccessHandler; //认证成功结果处理器
//    @Resource
//    private AuthenticationFailureHandler loginFailureHandler; //认证失败结果处理器

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PersistentTokenRepository tokenRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("admin")//用户名
//                .password(passwordEncoder().encode("123456"))//密码
//                .roles("ADMIN");//角色
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder().encode("123456"))
//                .roles("USER");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    @Override
    public void configure (WebSecurity web) {
        web.ignoring().antMatchers("/static/**");
    }

    //http请求拦截配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();//开启运行iframe嵌套页面

        http//1、配置权限认证
                .authorizeRequests()
                //配置不拦截路由
                .antMatchers("/500").permitAll()
                .antMatchers("/403").permitAll()
                .antMatchers("/404").permitAll()
                .antMatchers("/login").permitAll()
                //根据权限访问 只有具有admin权限才可访问该路径 权限可以在DetailService验证登录返回对象时候从数据库获取并添加
                .antMatchers("/user/hello").hasAuthority("admin")
                //区分于上一行 主要是这里可以提供一个字符串 ,分隔 代表多个权限中有一个满足即可访问
                .antMatchers("/user/helloworld").hasAnyAuthority("student","world","admin")
                //角色 角色权限多对多和上述类似
                .antMatchers("/user/world").hasRole("A")
                //同理
                .antMatchers("/user/anyWorld").hasAnyRole("start","A")
                .anyRequest() //任何其它请求
                .authenticated() //都需要身份认证
                .and()
                //2、登录配置表单认证方式
                .formLogin()
                    .loginPage("/login")//自定义登录页面的url
                    .usernameParameter("username")//设置登录账号参数，与表单参数一致
                    .passwordParameter("password")//设置登录密码参数，与表单参数一致
                // 告诉Spring Security在发送指定路径时处理提交的凭证，默认情况下，将用户重定向回用户来自的页面。登录表单form中action的地址，也就是处理认证请求的路径，
                // 只要保持表单中action和HttpSecurity里配置的loginProcessingUrl一致就可以了，也不用自己去处理，它不会将请求传递给Spring MVC和您的控制器，所以我们就不需要自己再去写一个/user/login的控制器接口了
                    .loginProcessingUrl("/user/login")//配置默认登录入口
                    .defaultSuccessUrl("/index")//登录成功后默认的跳转页面路径
                    .failureUrl("/login?error=true")
//                    .successHandler(loginSuccessHandler)//使用自定义的成功结果处理器
//                    .failureHandler(loginFailureHandler)//使用自定义失败的结果处理器
                .and()
                //3、注销
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/logoutSuccess")
//                .logoutSuccessHandler(new CustomLogoutSuccessHandler())
                    .permitAll()
                .and()
                //4、session管理
                    .sessionManagement()
                    .invalidSessionUrl("/login") //失效后跳转到登陆页面
                //单用户登录，如果有一个登录了，同一个用户在其他地方登录将前一个剔除下线
                //.maximumSessions(1).expiredSessionStrategy(expiredSessionStrategy())
                //单用户登录，如果有一个登录了，同一个用户在其他地方不能登录
                //.maximumSessions(1).maxSessionsPreventsLogin(true) ;
                .and()
                //5、禁用跨站csrf攻击防御
                    .csrf().disable();
//自定义403错误界面
//              http.exceptionHandling().accessDeniedPage("/hello");
        http.rememberMe()
                .tokenValiditySeconds(15000) //时间
                .tokenRepository(tokenRepository)
                .userDetailsService(userDetailsService);
    }
}
