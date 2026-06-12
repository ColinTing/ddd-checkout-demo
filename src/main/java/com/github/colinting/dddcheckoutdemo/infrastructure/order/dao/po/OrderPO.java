package com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月01日 10:47
 */
@Data
@TableName("orders")
public class OrderPO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long parentId;

    private Long itemId;

    private String addressDetail;

}
