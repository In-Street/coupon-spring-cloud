package cn.cloud.customer.service.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * openfeign请求添加header参数，用于sentinel根据调用源进行流控
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
