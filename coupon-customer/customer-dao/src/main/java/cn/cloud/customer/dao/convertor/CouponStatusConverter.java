package cn.cloud.customer.dao.convertor;

import cn.cloud.customer.api.enums.CouponStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 22:50
 **/
@Converter
public class CouponStatusConverter implements AttributeConverter<CouponStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(CouponStatus couponStatus) {
        return couponStatus.getCode();
    }

    @Override
    public CouponStatus convertToEntityAttribute(Integer code) {
        return CouponStatus.convert(code);
    }
}
