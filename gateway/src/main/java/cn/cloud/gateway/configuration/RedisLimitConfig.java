package cn.cloud.gateway.configuration;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-26 16:34
 **/
@Configuration
public class RedisLimitConfig {

    /**
     * 限流维度
     * @return
     */
    @Bean(name = "addrKeyResolver")
    public KeyResolver keyResolver() {
        return exchange -> Mono.just(
                exchange.getRequest()
                        .getRemoteAddress()
                        .getAddress().getHostAddress()
        );
    }

    @Bean(name="customerRateLimiter")
    public RateLimiter customerRateLimiter(){
        //每秒发放5个令牌，令牌痛容量10
        return new RedisRateLimiter(1, 3);
    }

    @Bean(name="templateRateLimiter")
    public RateLimiter templateRateLimiter(){
        return new RedisRateLimiter(5, 10);
    }

    @Bean(name="defaultRateLimiter")
    @Primary
    public RateLimiter defaultRateLimiter(){
        return new RedisRateLimiter(50, 100);
    }

}
