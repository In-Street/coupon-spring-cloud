package cn.cloud.gateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-26 16:19
 **/
@Configuration
public class RouteConfig {

    @Autowired
    @Qualifier("addrKeyResolver")
    private KeyResolver keyResolver;
    @Autowired
    @Qualifier("customerRateLimiter")
    private RateLimiter rateLimiter;

    @Bean(name = "routeLocator")
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        //请求匹配上多个路由时，利用order决定先后顺序，越小优先级越高
                        .order(1)
                        .path("/gateway/customer/**")
                        //删除path路径中的第一个子路径，变为 /customer/**
                        .filters(f -> f.stripPrefix(1)
                                .rewritePath("/customer/(?<repl>.*)","/couponCustomer/$\\{repl}")
                                .addRequestHeader("gw","gateway")
                                .requestRateLimiter(limiter->limiter.setKeyResolver(keyResolver).setRateLimiter(rateLimiter).setStatusCode(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED))
                        )
                        .uri("lb://coupon-customer-service"))
                .route(r -> r
                        .path("/gateway/couponTemplate/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://coupon-template-service"))
                .build();

    }
}
