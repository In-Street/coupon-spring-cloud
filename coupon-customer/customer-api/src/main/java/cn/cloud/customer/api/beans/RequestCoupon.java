package cn.cloud.customer.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 *  用户领取优惠券的请求参数
 * @author Cheng Yufei
 * @create 2023-03-23 22:36
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCoupon {

    // 用户领券
    @NotNull
    private Long userId;

    // 券模板ID
    @NotNull
    private Long couponTemplateId;

}
