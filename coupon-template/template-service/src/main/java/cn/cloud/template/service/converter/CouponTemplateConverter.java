package cn.cloud.template.service.converter;

import cn.cloud.template.api.beans.CouponTemplateInfo;
import cn.cloud.template.dao.entity.CouponTemplate;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 15:20
 **/
public class CouponTemplateConverter {

    public static CouponTemplateInfo convertToTemplateInfo(CouponTemplate template) {

        return CouponTemplateInfo.builder()
                .id(template.getId())
                .name(template.getName())
                .desc(template.getDescription())
                .type(template.getCategory().getCode())
                .shopId(template.getShopId())
                .available(template.getAvailable())
                .rule(template.getRule())
                .build();
    }
}
