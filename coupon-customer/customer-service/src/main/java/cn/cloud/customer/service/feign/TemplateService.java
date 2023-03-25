package cn.cloud.customer.service.feign;

import cn.cloud.template.api.beans.CouponTemplateInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-24 16:14
 **/
@FeignClient(value = "coupon-template-service", path = "/couponTemplate", fallback = TemplateServiceFallback.class)
public interface TemplateService {

    @GetMapping("/getTemplate")
    CouponTemplateInfo getTemplate(@RequestParam("id") Long id);
}
