package cn.cloud.template.api.enums;


import lombok.Getter;

import java.util.stream.Stream;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-22 23:17
 **/

@Getter
public enum CouponType {

    UNKNOWN("unknown", "0"),
    MONEY_OFF("满减券", "1"),
    DISCOUNT("打折", "2"),
    RANDOM_DISCOUNT("随机减", "3"),
    LONELY_NIGHT_MONEY_OFF("寂寞午夜double券", "4"),
    ANTI_PUA("PUA加倍奉还券", "5");

    private String description;

    // 存在数据库里的最终code
    private String code;

    CouponType(String description, String code) {
        this.description = description;
        this.code = code;
    }

    public static CouponType convert(String code) {
        return Stream.of(CouponType.values())
                .filter(couponType -> couponType.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKNOWN);
    }

}
