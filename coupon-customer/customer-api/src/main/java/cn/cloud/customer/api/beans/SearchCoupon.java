package cn.cloud.customer.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 22:42
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCoupon {

    @NotNull
    private Long userId;
    private Long shopId;
    private Integer couponStatus;

}
