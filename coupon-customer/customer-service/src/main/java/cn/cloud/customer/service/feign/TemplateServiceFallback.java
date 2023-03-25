package cn.cloud.customer.service.feign;

import cn.cloud.template.api.beans.CouponTemplateInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-24 16:34
 **/
@Component
@Slf4j
public class TemplateServiceFallback implements TemplateService{
    @Override
    public CouponTemplateInfo getTemplate(Long id) {
        log.info(" TemplateService # getTemplate 方法降级");
        return new CouponTemplateInfo();
    }
}
