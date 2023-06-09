package cn.cloud.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-22 23:29
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponInfo {

    private Long id;

    private Long templateId;

    /**
     * 领券用户id
     */
    private Long userId;

    /**
     * 使用门店ID
     */
    private Long shopId;

    private Integer status;

    private CouponTemplateInfo template;
}
