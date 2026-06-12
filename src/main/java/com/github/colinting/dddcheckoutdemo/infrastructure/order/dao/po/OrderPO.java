package com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.po;


import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月01日 10:47
 */
@Data
public class OrderPO {

    private Long id;

    private Long parentId;

    private String itemId;

    private String addressDetail;

}
