package cn.cloud.template.service.service;

import cn.cloud.template.api.beans.CouponTemplateInfo;
import cn.cloud.template.api.beans.PagedCouponTemplateInfo;
import cn.cloud.template.api.beans.TemplateSearchParams;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 15:09
 **/
public interface CouponTemplateService {

    /**
     * 创建优惠券模板
     * @param request
     * @return
     */
    CouponTemplateInfo createTemplate(CouponTemplateInfo request);

    CouponTemplateInfo cloneTemplate(Long templateId);

    /**
     * 模板查询（分页）
     * @param request
     * @return
     */
    PagedCouponTemplateInfo search(TemplateSearchParams request);

    /**
     * 通过模板ID查询优惠券模板
     * @param id
     * @return
     */
    CouponTemplateInfo loadTemplateInfo(Long id);

    /**
     *  让优惠券模板无效
     * @param id
     */
    void deleteTemplate(Long id);

    /**
     *    批量查询
     *   Map是模板ID，key是模板详情
     * @param ids
     * @return
     */
    Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids);
}
