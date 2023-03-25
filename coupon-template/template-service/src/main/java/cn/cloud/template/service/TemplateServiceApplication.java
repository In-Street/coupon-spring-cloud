package cn.cloud.template.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 15:01
 **/
@SpringBootApplication(scanBasePackages = "cn.cloud.template")
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "cn.cloud.template.dao")
@EntityScan(basePackages = "cn.cloud.template.dao.entity")
public class TemplateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateServiceApplication.class, args);
    }
}
