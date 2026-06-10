package com.github.colinting.dddcheckoutdemo.domain.order.entity;

import com.github.colinting.dddcheckoutdemo.domain.order.valueobject.ItemId;
import com.github.colinting.dddcheckoutdemo.domain.order.valueobject.LineItemId;
import com.github.colinting.dddcheckoutdemo.domain.order.valueobject.OrderId;
import com.github.colinting.dddcheckoutdemo.domain.order.valueobject.Quantity;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

/**
 *
 * 子订单实体
 * @author 丁浩
 * @date 2022年09月03日 20:04
 */
@Data
@Builder
public class LineItem {

    private LineItemId id;
    // 主订单ID
    private OrderId orderId;
    // 商品ID
    private ItemId itemId;
    // 价格
    private BigDecimal price;

    private Quantity quantity;

}
