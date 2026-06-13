package com.github.colinting.dddcheckoutdemo.infrastructure.client;


import com.github.colinting.dddcheckoutdemo.domain.order.entity.ItemDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:18
 */
@FeignClient(name = "external-item", fallback = ExternalItemFallback.class)
public interface ExternalItemClient {

    @RequestMapping(value = "/getItem", method = RequestMethod.POST)
    ItemDO getItem(@RequestParam Long itemId);
}
