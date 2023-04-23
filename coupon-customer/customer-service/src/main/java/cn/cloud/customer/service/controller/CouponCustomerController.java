package cn.cloud.customer.service.controller;

import cn.cloud.customer.service.service.CouponCustomerService;
import cn.cloud.template.api.beans.CouponTemplateInfo;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-24 12:05
 **/
@RestController
@RequestMapping("/couponCustomer")
@Slf4j
@RefreshScope
public class CouponCustomerController {

    @Autowired
    private CouponCustomerService couponCustomerService;
    @Value("${disableCouponRequest}")
    private Boolean disableCouponRequest;

    @GetMapping("/getTemplate")
    @SentinelResource(value = "customer-service:getTemplate")
    public CouponTemplateInfo getTemplate(@RequestParam("id") Long id, HttpServletRequest request) {
        log.info("读取配置：{}", disableCouponRequest);
        log.info("读取header：{}", request.getHeader("gw"));
        return couponCustomerService.getTemplate(id);
    }
}
