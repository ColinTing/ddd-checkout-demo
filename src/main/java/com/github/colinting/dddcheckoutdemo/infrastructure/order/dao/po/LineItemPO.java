package com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.po;


import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 丁浩
 * @date 2022年09月03日 20:19
 */
@Data
public class LineItemPO {

    private Long id;

    private Long orderId;

    private Long itemId;

    private int quantity;

    private BigDecimal price;

}
