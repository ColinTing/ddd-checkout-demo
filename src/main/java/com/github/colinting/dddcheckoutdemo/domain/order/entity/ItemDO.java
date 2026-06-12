package com.github.colinting.dddcheckoutdemo.domain.order.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

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
