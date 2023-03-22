package cn.cloud.template.api.beans;

import cn.cloud.template.api.beans.rules.TemplateRule;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  创建优惠券模版
 * @author Cheng Yufei
 * @create 2023-03-22 23:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponTemplateInfo {

    private Long id;

    @NotNull
    private String name;

    // 优惠券描述
    @NotNull
    private String desc;

    // 优惠券类型
    @NotNull
    private String type;

    // 适用门店 - 若无则为全店通用券
    private Long shopId;

    /** 优惠券规则 */
    @NotNull
    private TemplateRule rule;

    private Boolean available;

}
