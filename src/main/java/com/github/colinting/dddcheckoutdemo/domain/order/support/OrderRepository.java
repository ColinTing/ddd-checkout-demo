package com.github.colinting.dddcheckoutdemo.domain.order.support;

import com.github.colinting.dddcheckoutdemo.domain.order.entity.OrderDO;

/**
 * 订单仓储
 *
 * @author 丁浩
 * @version 2026年06月10日 17:10
 */

public interface OrderRepository {

    void createOrder(OrderDO order);
}
