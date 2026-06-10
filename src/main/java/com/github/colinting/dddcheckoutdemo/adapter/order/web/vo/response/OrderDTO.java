package com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 订单数据传输层对象
 *
 * @author 丁浩
 * @version 2026年06月10 19:48
 */
@Data
public class OrderDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String itemTitle;

    private String detailAddress;
}
