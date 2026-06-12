package com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 丁浩
 * @date 2022年09月03日 20:19
 */
@Data
@TableName("line_items")
public class LineItemPO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long orderId;

    private Long itemId;

    private int quantity;

    private BigDecimal price;

}
