package com.github.colinting.dddcheckoutdemo.domain.order.entity;

import com.github.colinting.dddcheckoutdemo.domain.order.valueobject.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * 订单DO
 *
 * @author 丁浩
 * @version 2026年06月10日 16:27
 */
@Data
public class OrderDO {

    private OrderId id;

    private UserId userId;

    private Long itemId;

    private Address address;

    private List<LineItem> lineItems;

    private OrderState status;

    private Long buyerId;

    private Long sellerId;

    private String itemTitle;

    private Long itemUnitPrice;

    private Integer count;

    private Long totalCost;


    public OrderId getId() {
        return  new OrderId(Long.parseLong(UUID.randomUUID().toString()));
    }

    // 把原来一个在ApplicationService的计算迁移到Entity里
    public Long getTotalCost() {
        return itemUnitPrice * count;
    }


}
