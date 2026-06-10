package com.github.colinting.dddcheckoutdemo.application.order;


import com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response.OrderDTO;
import com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response.Result;
import com.github.colinting.dddcheckoutdemo.application.order.assemble.OrderDtoAssembler;
import com.github.colinting.dddcheckoutdemo.application.order.dto.request.CheckoutCommand;
import com.github.colinting.dddcheckoutdemo.domain.order.entity.OrderDO;
import com.github.colinting.dddcheckoutdemo.domain.order.support.OrderRepository;
import com.github.colinting.dddcheckoutdemo.infrastructure.client.dto.response.ItemDO;
import com.github.colinting.dddcheckoutdemo.infrastructure.common.utils.SessionUtils;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 下单服务
 *
 * @author 丁浩
 * @version 2026年06月10 20:02
 */
@Service
@RequiredArgsConstructor
public class CheckoutService {


    private final ItemService itemService;

    private final InventoryService inventoryService;

    private final OrderRepository orderRepository;

    private final OrderDtoAssembler orderDtoAssembler;

    public OrderDTO checkout(@Valid CheckoutCommand cmd) {
        // 1) Session管理
        Long userId = SessionUtils.getLoggedInUserId();
        if (userId <= 0) {
            throw new IllegalArgumentException("Not Logged In");
        }

        Long itemId = cmd.getItemId();
        Integer quantity = cmd.getQuantity();

        // 2）参数校验
        if (itemId <= 0 || quantity <= 0 || quantity >= 1000) {
            throw new IllegalArgumentException("Invalid Args");
        }

        // 3）外部数据补全
        ItemDO item = itemService.getItem(itemId);
        if (item == null) {
            throw new IllegalArgumentException("Item Not Found");
        }

        // 4）调用外部服务
        boolean withholdSuccess = inventoryService.withhold(itemId, quantity);
        if (!withholdSuccess) {
            throw new IllegalArgumentException("Inventory not enough");
        }

        // 5）领域计算
        Long cost = item.getPriceInCents() * quantity;

        // 6）领域对象操作
        OrderDO order = new OrderDO();
        order.setItemId(itemId);
        order.setBuyerId(userId);
        order.setSellerId(item.getSellerId());
        order.setCount(quantity);
        order.setTotalCost(cost);

        // 7）数据持久化
        orderRepository.createOrder(order);

        // 8）返回
       return orderDtoAssembler.orderToDTO(order);
    }

}
