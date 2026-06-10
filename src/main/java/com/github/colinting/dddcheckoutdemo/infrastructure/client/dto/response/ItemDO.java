package com.github.colinting.dddcheckoutdemo.infrastructure.client.dto.response;

import lombok.Data;

/**
 * 商品返回DO
 *
 * @author 丁浩
 * @version 2026年06月10日 16:00
 */
@Data
public class ItemDO {

    private Long itemId;

    private String title;

    private Long priceInCents;

    private Long sellerId;

}
