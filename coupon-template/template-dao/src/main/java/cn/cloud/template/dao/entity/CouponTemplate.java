package cn.cloud.template.dao.entity;

import cn.cloud.template.api.beans.rules.TemplateRule;
import cn.cloud.template.api.enums.CouponType;
import cn.cloud.template.dao.converter.CouponTypeConverter;
import cn.cloud.template.dao.converter.RuleConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 11:15
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon_template")
public class CouponTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 状态是否可用
    @Column(name = "available", nullable = false)
    private Boolean available;

    @Column(name = "name", nullable = false)
    private String name;

    // 适用门店-如果为空，则为全店满减券
    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "description", nullable = false)
    private String description;

    // 优惠券类型
    @Column(name = "type", nullable = false)
    @Convert(converter = CouponTypeConverter.class)
    private CouponType category;

    // 创建时间，通过@CreateDate注解自动填值（需要配合@JpaAuditing注解在启动类上生效）
    @CreatedDate
    @Column(name = "created_time", nullable = false)
    private Date createdTime;

    // 优惠券核算规则，平铺成JSON字段
    @Column(name = "rule", nullable = false)
    @Convert(converter = RuleConverter.class)
    private TemplateRule rule;
}


/**
 *  entity: 申请数据库实体对象
 *  GeneratedValue： 主键生成策略
 *          TABLE：使用一个特定的数据库表格来保存主键。
 *          SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
 *          IDENTITY：主键由数据库自动生成（主要是自动增长型）
 *          AUTO：主键由程序控制。
 *   Column：数据库字段，支持非空检测、对update和insert语句进行限制等功能
 *   CreateDate: 自动填充当前创建时间
 *   Convert:  指定一个继承自 AttributeConverter 类，将DB里存放的内容转化为一个java对象
 */