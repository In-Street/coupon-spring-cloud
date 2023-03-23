package cn.cloud.template.api.beans;

import cn.cloud.template.api.beans.rules.TemplateRule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 *  优惠券模版，每张优惠券经由此模版制造，制造出来的优惠券使用 CouponInfo对象封装
 * @author Cheng Yufei
 * @create 2023-03-22 23:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponTemplateInfo {

    private Long id;

    @NotNull
    private String name;

    // 优惠券描述
    @NotNull
    private String desc;

    /**
     *  {@link cn.cloud.template.api.enums.CouponType}
     * 优惠券类型
     */
    @NotNull
    private String type;

    // 适用门店 - 若无则为全店通用券
    private Long shopId;

    /** 优惠券规则 */
    @NotNull
    private TemplateRule rule;

    private Boolean available;

}
