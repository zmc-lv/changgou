package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * package name: com.changgou
 *
 * @author zmc
 * Date: 2021/8/18
 */
@SpringBootApplication
@EnableEurekaClient //启动eureka-client
//组件扫描 mapper 注意 要使用tk的包下的注解扫描
@MapperScan(basePackages = "com.changgou.goods.dao")
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
