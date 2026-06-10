package com.github.colinting.dddcheckoutdemo.infrastructure.order.supportimpl;

import com.github.colinting.dddcheckoutdemo.domain.order.entity.OrderDO;
import com.github.colinting.dddcheckoutdemo.domain.order.support.OrderRepository;
import org.springframework.stereotype.Repository;

/**
 * 订单仓储实现类
 *
 * @author 丁浩
 * @version 2026年06月10日 17:12
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void createOrder(OrderDO order) {

    }
}
