package cn.cloud.template.service.controller;

import cn.cloud.template.api.beans.CouponTemplateInfo;
import cn.cloud.template.api.beans.PagedCouponTemplateInfo;
import cn.cloud.template.api.beans.TemplateSearchParams;
import cn.cloud.template.dao.entity.CouponTemplate;
import cn.cloud.template.service.service.CouponTemplateService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Cheng Yufei
 * @create 2023-03-23 15:03
 **/
@RestController
@RequestMapping("/couponTemplate")
@Slf4j
public class CouponTemplateController {

    @Autowired
    private CouponTemplateService couponTemplateService;

    // 创建优惠券
    @PostMapping("/addTemplate")
    public CouponTemplateInfo addTemplate(@Valid @RequestBody CouponTemplateInfo request) {
        log.info("Create coupon template: data={}", request);
        return couponTemplateService.createTemplate(request);
    }

    @PostMapping("/cloneTemplate")
    public CouponTemplateInfo cloneTemplate(@RequestParam("id") Long templateId) {
        log.info("Clone coupon template: data={}", templateId);
        return couponTemplateService.cloneTemplate(templateId);
    }

    // 读取优惠券
    @GetMapping("/getTemplate")
    @SentinelResource(value = "template-service:getTemplate")
    public CouponTemplateInfo getTemplate(@RequestParam("id") Long id) throws InterruptedException {
        //openfeign 降级测试
        //Thread.sleep(5000L);
        log.info("Load template, id={}", id);
        return couponTemplateService.loadTemplateInfo(id);
    }

    // 批量获取
    @GetMapping("/getBatch")
    @SentinelResource(value = "template-service:getTemplateInBatch",blockHandler = "getTemplateInBatchBlockHandler")
    public Map<Long, CouponTemplateInfo> getTemplateInBatch(@RequestParam("ids") Collection<Long> ids) {
        return couponTemplateService.getTemplateInfoMap(ids);
    }

    public Map<Long, CouponTemplateInfo> getTemplateInBatchBlockHandler(@RequestParam("ids") Collection<Long> ids, BlockException e) {
        log.info("getTemplateInBatch接口被限流");
        return Collections.emptyMap();
    }

    // 搜索模板
    @PostMapping("/search")
    public PagedCouponTemplateInfo search(@Valid @RequestBody TemplateSearchParams request) {
        log.info("search templates, payload={}", request);
        return couponTemplateService.search(request);
    }

    // 优惠券无效化
    @DeleteMapping("/deleteTemplate")
    public void deleteTemplate(@RequestParam("id") Long id){
        log.info("Load template, id={}", id);
        couponTemplateService.deleteTemplate(id);
    }
    
    @GetMapping("/t1")
    public List<CouponTemplate>t1(){
        return couponTemplateService.findAllById(Lists.newArrayList(1L, 2L));
    }

    @GetMapping("/t2")
    public List<CouponTemplate>t2(){
        return couponTemplateService.findAllById(Lists.newArrayList(1L, 2L));
    }
}
