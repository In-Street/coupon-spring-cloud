package cn.cloud.customer.api.enums;


import lombok.Getter;

import java.util.stream.Stream;

/**
 * 优惠券状态
 * @author Cheng Yufei
 * @create 2023-03-23 22:32
 **/
@Getter
public enum CouponStatus {

    AVAILABLE("未使用", 1),
    USED("已用", 2),
    INACTIVE("已经注销", 3);

    private String desc;
    private Integer code;

    CouponStatus(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    public static CouponStatus convert(Integer code) {
        if (code == null) {
            return null;
        }
        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElse(null);
    }
}
