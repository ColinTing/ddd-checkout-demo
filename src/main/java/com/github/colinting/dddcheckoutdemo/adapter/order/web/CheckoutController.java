package com.github.colinting.dddcheckoutdemo.adapter.order.web;

import com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response.Result;
import com.github.colinting.dddcheckoutdemo.application.order.InventoryService;
import com.github.colinting.dddcheckoutdemo.application.order.ItemService;
import com.github.colinting.dddcheckoutdemo.domain.order.entity.OrderDO;
import com.github.colinting.dddcheckoutdemo.domain.order.support.OrderRepository;
import com.github.colinting.dddcheckoutdemo.infrastructure.client.dto.response.ItemDO;
import com.github.colinting.dddcheckoutdemo.infrastructure.common.utils.SessionUtils;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * checkout controller 层
 *
 * @author 丁浩
 * @version 2026年06月10日 15:10
 */
@RestController
@RequestMapping("/")
public class CheckoutController {

    @Resource
    private ItemService itemService;

    @Resource
    private InventoryService inventoryService;

    @Resource
    private OrderRepository orderRepository;

    @PostMapping("checkout")
    public Result<OrderDO> checkout(Long itemId, Integer quantity) {
        // 1) Session管理
        Long userId = SessionUtils.getLoggedInUserId();
        if (userId <= 0) {
            return Result.fail("Not Logged In");
        }

        // 2）参数校验
        if (itemId <= 0 || quantity <= 0 || quantity >= 1000) {
            return Result.fail("Invalid Args");
        }

        // 3）外部数据补全
        ItemDO item = itemService.getItem(itemId);
        if (item == null) {
            return Result.fail("Item Not Found");
        }

        // 4）调用外部服务
        boolean withholdSuccess = inventoryService.withhold(itemId, quantity);
        if (!withholdSuccess) {
            return Result.fail("Inventory not enough");
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
        return Result.success(order);
    }

}
