package cn.cloud.template.dao;

import cn.cloud.template.dao.entity.CouponTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 15:15
 **/
public interface CouponTemplateDao extends JpaRepository<CouponTemplate,Long> {

    /**
     * 根据Shop ID查询出所有券模板
     * @param shopId
     * @return
     */
    List<CouponTemplate> findAllByShopId(Long shopId);

    /**
     * IN查询 + 分页支持的语法
     * @param Id
     * @param page
     * @return
     */
    Page<CouponTemplate> findAllByIdIn(List<Long> Id, Pageable page);

    /**
     * 根据shop ID + 可用状态查询店铺有多少券模板
     * @param shopId
     * @param available
     * @return
     */
    Integer countByShopIdAndAvailable(Long shopId, Boolean available);

    /**
     * 将优惠券设置为不可用
     * @param id
     * @return
     */
    @Modifying
    @Query("update CouponTemplate c set c.available = 0 where c.id = :id")
    int makeCouponUnavailable(@Param("id") Long id);
}
