package cn.cloud.customer.service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-24 12:00
 **/
@Configuration
public class Config {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuild() {
        return WebClient.builder();
    }
}
