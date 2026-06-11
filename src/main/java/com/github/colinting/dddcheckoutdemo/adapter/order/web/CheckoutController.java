package com.github.colinting.dddcheckoutdemo.adapter.order.web;

import com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response.OrderDTO;
import com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response.Result;
import com.github.colinting.dddcheckoutdemo.application.order.CheckoutService;
import com.github.colinting.dddcheckoutdemo.application.order.dto.request.CheckoutCommand;
import com.github.colinting.dddcheckoutdemo.infrastructure.common.annotation.ResultHandler;
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
    @ResultHandler
    public Result<OrderDTO> checkout(Long itemId, Integer quantity) {
        CheckoutCommand cmd = new CheckoutCommand();
        OrderDTO orderDTO = checkoutService.checkout(cmd);
        return Result.success(orderDTO);
    }

}
