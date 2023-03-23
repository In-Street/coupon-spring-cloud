package cn.cloud.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 15:56
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedCouponTemplateInfo {

    public List<CouponTemplateInfo> templates;

    public int page;

    public long total;
}
