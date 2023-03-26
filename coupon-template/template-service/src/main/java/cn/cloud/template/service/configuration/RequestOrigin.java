package cn.cloud.template.service.configuration;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *  sentinel: 流控，获取请求来源，限流某一服务对当前服务的请求
 * @author Cheng Yufei
 * @create 2023-03-25 17:04
 **/
@Component
@Slf4j
public class RequestOrigin implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getHeader("sentinelSource");
    }
}
