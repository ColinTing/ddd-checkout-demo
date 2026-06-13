package com.github.colinting.dddcheckoutdemo.application.order;


import com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response.OrderDTO;
import com.github.colinting.dddcheckoutdemo.application.order.assemble.OrderDtoAssembler;
import com.github.colinting.dddcheckoutdemo.application.order.dto.request.CheckoutCommand;
import com.github.colinting.dddcheckoutdemo.application.order.dto.request.OrderQuery;
import com.github.colinting.dddcheckoutdemo.application.order.dto.request.UpdateOrderCommand;
import com.github.colinting.dddcheckoutdemo.domain.order.entity.OrderDO;
import com.github.colinting.dddcheckoutdemo.domain.order.support.InventorySupport;
import com.github.colinting.dddcheckoutdemo.domain.order.support.ItemSupport;
import com.github.colinting.dddcheckoutdemo.domain.order.support.OrderSupport;
import com.github.colinting.dddcheckoutdemo.infrastructure.client.dto.response.ItemDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * 下单服务
 *
 * @author 丁浩
 * @version 2026年06月10 20:02
 */
@Service
@RequiredArgsConstructor
@Validated
public class CheckoutService {


    private final ItemSupport itemSupport;

    private final InventorySupport inventorySupport;

    private final OrderSupport orderSupport;

    private final OrderDtoAssembler orderDtoAssembler;

    // 下单
    public OrderDTO checkout(@Valid CheckoutCommand cmd) {

        ItemDTO item = itemSupport.getItem(cmd.getItemId());
        if (item == null) {
            throw new IllegalArgumentException("Item not found");
        }

        boolean withholdSuccess = inventorySupport.withhold(cmd.getItemId(), cmd.getQuantity());
        if (!withholdSuccess) {
            throw new IllegalArgumentException("Inventory not enough");
        }

        // 领域对象操作
        OrderDO order = new OrderDO();
        order.setBuyerId(cmd.getUserId());
        order.setSellerId(item.getSellerId());
        order.setItemId(item.getItemId());
        order.setItemTitle(item.getTitle());
        order.setItemUnitPrice(item.getPriceInCents());
        order.setCount(cmd.getQuantity());

        OrderDO savedOrder = orderSupport.save(order);

        return orderDtoAssembler.orderToDTO(savedOrder);
    }

    public OrderDTO updateOrder(@Valid UpdateOrderCommand cmd) {
        return null;
    }

    // 支付成功
//    OrderDTO payReceived(@Valid PaymentReceivedEvent event);

    // 支付取消
//    OrderDTO payCanceled(@Valid PaymentCanceledEvent event);

    // 发货
//    OrderDTO packageSent(@Valid PackageSentEvent event);

    // 收货
//    OrderDTO delivered(@Valid DeliveredEvent event);

    // 批量查询
    public List<OrderDTO> query(OrderQuery query) {
        return null;
    }

    // 单个查询
    public OrderDTO getOrder(Long orderId) {
        return null;
    }

}
