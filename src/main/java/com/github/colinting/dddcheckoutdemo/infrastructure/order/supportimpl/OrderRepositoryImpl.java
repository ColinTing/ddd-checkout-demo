package com.github.colinting.dddcheckoutdemo.infrastructure.order.supportimpl;

import com.github.colinting.dddcheckoutdemo.domain.order.entity.LineItem;
import com.github.colinting.dddcheckoutdemo.domain.order.entity.OrderDO;
import com.github.colinting.dddcheckoutdemo.domain.order.support.OrderRepository;
import com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.converter.LineItemConverter;
import com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.converter.OrderConverter;
import com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.mapper.LineItemMapper;
import com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.mapper.OrderMapper;
import com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.po.LineItemPO;
import com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.po.OrderPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 订单仓储实现类
 *
 * @author 丁浩
 * @version 2026年06月10日 17:12
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private  final OrderMapper orderMapper;

    private final LineItemMapper lineItemMapper;

    private final OrderConverter orderConverter;

    private final LineItemConverter lineAssembler;

    @Override
    public OrderDO save(OrderDO aggregate) {
        if (aggregate.getId() != null && aggregate.getId().getId() > 0) {
            // update
            OrderPO orderPO = orderConverter.fromOrder(aggregate);
            orderMapper.updateById(orderPO);
            for (LineItem lineItem: aggregate.getLineItems()) {
                save(lineItem);
            }
        } else {
            // insert
            OrderPO orderDO = orderConverter.fromOrder(aggregate);
            orderMapper.insert(orderDO);
            aggregate.setId(orderConverter.toOrder(orderDO).getId());
        }
        return aggregate;
    }

    private void save(LineItem lineItem) {
        if (lineItem.getId() != null && lineItem.getId().getId() > 0) {
            LineItemPO lineItemPO = lineAssembler.fromLineItem(lineItem);
            lineItemMapper.updateById(lineItemPO);
        } else {
            LineItemPO lineItemPO = lineAssembler.fromLineItem(lineItem);
            lineItemMapper.insert(lineItemPO);
            lineItem.setId(lineAssembler.toLineItem(lineItemPO).getId());
        }
    }
}
