package com.github.colinting.dddcheckoutdemo.domain.order.support;

import com.github.colinting.dddcheckoutdemo.infrastructure.client.dto.response.ItemDTO;

/**
 * 商品Facade接口
 */
public interface ItemSupport {
    ItemDTO getItem(Long itemId);
}