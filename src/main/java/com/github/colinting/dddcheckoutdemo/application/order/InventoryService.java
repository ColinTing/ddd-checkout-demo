package com.github.colinting.dddcheckoutdemo.application.order;

import org.springframework.stereotype.Service;

/**
 * 库存服务
 *
 * @author 丁浩
 * @version 2026年06月10日 16:03
 */
@Service
public class InventoryService {

    public boolean withhold(Long itemId, Integer quantity) {
        return false;
    }

}
