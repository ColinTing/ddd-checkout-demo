package com.github.colinting.dddcheckoutdemo.infrastructure.order.supportimpl;

import com.github.colinting.dddcheckoutdemo.domain.order.support.InventorySupport;
import com.github.colinting.dddcheckoutdemo.infrastructure.client.ExternalInventoryClient;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class InventorySupportImpl implements InventorySupport {

    @Resource
    private ExternalInventoryClient externalInventoryClient;

    @Override
    public boolean withhold(Long itemId, Integer quantity) {
        return externalInventoryClient.withhold(itemId, quantity);
    }
}