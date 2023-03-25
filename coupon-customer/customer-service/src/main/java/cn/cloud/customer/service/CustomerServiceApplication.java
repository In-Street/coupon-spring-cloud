package cn.cloud.customer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 22:57
 **/
@SpringBootApplication(scanBasePackages = "cn.cloud.customer")
// @CreateDate 自动生成需要此注解
@EnableJpaAuditing
//扫描Dao
@EnableJpaRepositories(basePackages = "cn.cloud.customer.dao")
//扫描JPA实体类
@EntityScan(basePackages = "cn.cloud.customer.dao.entity")
@EnableFeignClients(basePackages ="cn.cloud.customer.service.feign")
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}
