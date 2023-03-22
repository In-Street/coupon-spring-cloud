package cn.cloud.template.api.beans.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  定义规则： 领券规则、券模版计算规则
 * @author Cheng Yufei
 * @create 2023-03-22 23:30
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRule {

    /**
     * 可以享受的折扣
     */
    private Discount discount;

    /**
     * 每个人最多可以领券数量
     */
    private Integer limitation;

    /**
     * 过期时间
     */
    private Long deadline;
}
