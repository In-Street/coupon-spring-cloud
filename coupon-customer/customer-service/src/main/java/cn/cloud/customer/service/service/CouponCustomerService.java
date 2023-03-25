package cn.cloud.customer.service.service;

import cn.cloud.customer.api.beans.RequestCoupon;
import cn.cloud.customer.api.beans.SearchCoupon;
import cn.cloud.customer.dao.entity.Coupon;
import cn.cloud.template.api.beans.CouponTemplateInfo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 22:59
 **/
public interface CouponCustomerService {

    /**
     * 领券接口
     * @param request
     * @return
     */
    Coupon requestCoupon(RequestCoupon request);

    /**
     *  核销优惠券
     * @param info
     * @return
     */
    //ShoppingCart placeOrder(ShoppingCart info);

    /**
     * 优惠券金额试算
     * @param order
     * @return
     */
    //SimulationResponse simulateOrderPrice(SimulationOrder order);

    void deleteCoupon(Long userId, Long couponId);

    /**
     * 查询用户优惠券
     * @param request
     * @return
     */
    //List<CouponInfo> findCoupon(SearchCoupon request);

    public CouponTemplateInfo getTemplate(Long id);
}
