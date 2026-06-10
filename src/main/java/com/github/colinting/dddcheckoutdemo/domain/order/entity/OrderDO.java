package com.github.colinting.dddcheckoutdemo.domain.order.entity;

import lombok.Data;

/**
 * 订单DO
 *
 * @author 丁浩
 * @version 2026年06月10日 16:27
 */
@Data
public class OrderDO {

    private Long itemId;

    private Long buyerId;

    private Long sellerId;

    private Integer count;

    private Long totalCost;


}
