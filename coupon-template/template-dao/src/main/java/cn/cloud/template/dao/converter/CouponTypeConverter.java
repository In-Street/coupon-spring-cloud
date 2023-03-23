package cn.cloud.template.dao.converter;

import cn.cloud.template.api.enums.CouponType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 11:59
 **/
@Converter
public class CouponTypeConverter implements AttributeConverter<CouponType,String> {

    @Override
    public String convertToDatabaseColumn(CouponType couponType) {
        return couponType.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String code) {
        return CouponType.convert(code);
    }
}
