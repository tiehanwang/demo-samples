package com.ali.nacos.consumer;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.UrlCleaner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = true)
@EnableFeignClients
public class ConsumerApplication {

    @RestController
    public class NacosController{

        @Autowired
        private LoadBalancerClient loadBalancerClient;
        @Autowired
        private RestTemplate restTemplate;

        @Value("${spring.application.name}")
        private String appName;

        @GetMapping("/echo/app-name")
        public String echoAppName(){
            //Access through the combination of LoadBalanceClient and RestTemplate
            //select serviceId and restTemplate get
            //不使用ribbon可直接访问否则应为服务名访问
//            ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
//            String path = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
            String path = String.format("http://nacos-provider/echo/%s",appName);
            System.out.println("request path:" +path);
            return restTemplate.getForObject(path,String.class);
        }

    }

    //Instantiate RestTemplate Instance
    //这种方法是全局的url过滤 或者 服务降级等 优先级低于局部的 @SentinelResource
    @LoadBalanced
    @Bean
    @SentinelRestTemplate(urlCleanerClass = RestUrlCleaner.class, urlCleaner = "urlClean")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @LoadBalanced
    @Bean
    @SentinelRestTemplate
    public RestTemplate restTemplate1() {
        return new RestTemplate();
    }


    public static void main (String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @FeignClient(name = "nacos-provider", fallback = EchoServiceFallback.class,
            configuration = FeignConfiguration.class)
    public interface EchoService {

        @GetMapping("/echo/{str}")
        String echo(@PathVariable("str") String str);

        @GetMapping("/divide")
        String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

        default String divide(Integer a) {
            return divide(a, 0);
        }

        @GetMapping("/notFound")
        String notFound();
    }

    class FeignConfiguration {

        @Bean
        public EchoServiceFallback echoServiceFallback() {
            return new EchoServiceFallback();
        }

    }

    class EchoServiceFallback implements EchoService {

        @Override
        public String echo(@PathVariable("str") String str) {
            return "echo fallback";
        }

        @Override
        public String divide(@RequestParam Integer a, @RequestParam Integer b) {
            return "divide fallback";
        }

        @Override
        public String notFound() {
            return "notFound fallback";
        }

    }
}
