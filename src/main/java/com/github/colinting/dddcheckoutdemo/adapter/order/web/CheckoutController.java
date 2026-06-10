package com.github.colinting.dddcheckoutdemo.adapter.order.web;

import com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response.OrderDTO;
import com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response.Result;
import com.github.colinting.dddcheckoutdemo.application.order.CheckoutService;
import com.github.colinting.dddcheckoutdemo.application.order.InventoryService;
import com.github.colinting.dddcheckoutdemo.application.order.ItemService;
import com.github.colinting.dddcheckoutdemo.application.order.dto.request.CheckoutCommand;
import com.github.colinting.dddcheckoutdemo.domain.order.entity.OrderDO;
import com.github.colinting.dddcheckoutdemo.domain.order.support.OrderRepository;
import com.github.colinting.dddcheckoutdemo.infrastructure.client.dto.response.ItemDO;
import com.github.colinting.dddcheckoutdemo.infrastructure.common.utils.SessionUtils;
import jakarta.annotation.Resource;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping("checkout")
    public Result<OrderDTO> checkout(Long itemId, Integer quantity) {
        try {
            CheckoutCommand cmd = new CheckoutCommand();
            OrderDTO orderDTO = checkoutService.checkout(cmd);
            return Result.success(orderDTO);
        } catch (ConstraintViolationException cve) {
            // 捕捉一些特殊异常，比如Validation异常
            return Result.fail(cve.getMessage());
        } catch (Exception e) {
            // 兜底异常捕获
            return Result.fail(e.getMessage());
        }
    }

}
