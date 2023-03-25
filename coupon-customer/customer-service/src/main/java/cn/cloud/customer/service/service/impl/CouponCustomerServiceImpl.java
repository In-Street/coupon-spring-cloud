package cn.cloud.customer.service.service.impl;

import cn.cloud.customer.api.beans.RequestCoupon;
import cn.cloud.customer.dao.entity.Coupon;
import cn.cloud.customer.service.feign.TemplateService;
import cn.cloud.customer.service.service.CouponCustomerService;
import cn.cloud.template.api.beans.CouponTemplateInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-24 11:56
 **/
@Service
@Slf4j
public class CouponCustomerServiceImpl implements CouponCustomerService {

    @Autowired
    private WebClient.Builder builder;
    @Autowired
    private TemplateService templateService;

    @Override
    public Coupon requestCoupon(RequestCoupon request) {
        return null;
    }

    @Override
    public void deleteCoupon(Long userId, Long couponId) {

    }

    @Override
    public CouponTemplateInfo getTemplate(Long id) {
        //1. 通过WebClient 发起调用
        CouponTemplateInfo response = builder.build()
                .get()
                .uri("http://coupon-template-service/couponTemplate/getTemplate?id=" + id)

                //retrieve + bodyToMono 指定Response返回格式
                .retrieve()
                .bodyToMono(CouponTemplateInfo.class)
                //阻塞调用，远程服务没有响应之前，当前线程处于阻塞
                .block();

        //2. 通过feign发起调用
        CouponTemplateInfo template = templateService.getTemplate(id);
        return template;
    }
}
