package com.github.colinting.dddcheckoutdemo.infrastructure.client;

import org.springframework.stereotype.Component;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:32
 */

@Component
public class ExternalInventoryFallback implements ExternalInventoryClient {

    @Override
    public boolean withhold(Long itemId, Integer quantity) {
        return false;
    }
}
