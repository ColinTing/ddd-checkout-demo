package com.github.colinting.dddcheckoutdemo.infrastructure.client;


import com.github.colinting.dddcheckoutdemo.domain.order.entity.ItemDO;
import org.springframework.stereotype.Component;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:19
 */

@Component
public class ExternalItemFallback implements ExternalItemClient {

    @Override
    public ItemDO getItem(Long itemId) {
        return null;
    }
}
