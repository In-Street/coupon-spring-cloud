package cn.cloud.customer.service.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-25 17:06
 **/
@Component
public class RequestParam implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("sentinelSource", "customer-service");
    }
}
