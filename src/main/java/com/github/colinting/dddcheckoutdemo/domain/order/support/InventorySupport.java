package com.github.colinting.dddcheckoutdemo.domain.order.support;

// 库存Facade
public interface InventorySupport {
    boolean withhold(Long itemId, Integer quantity);
}