package cn.cloud.customer.dao;

import cn.cloud.customer.dao.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 22:45
 **/
public interface CouponDao extends JpaRepository<Coupon, Long> {
    long countByUserIdAndTemplateId(Long userId, Long templateId);
}
