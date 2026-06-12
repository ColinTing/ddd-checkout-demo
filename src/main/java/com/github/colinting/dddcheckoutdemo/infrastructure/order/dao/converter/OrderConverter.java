package com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.converter;

import com.github.colinting.dddcheckoutdemo.domain.order.entity.OrderDO;
import com.github.colinting.dddcheckoutdemo.infrastructure.order.dao.po.OrderPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author 丁浩
 * @date 2022年09月01日 14:25
 */
@Mapper(componentModel = "spring")
public interface OrderConverter {



    @Mappings({
        @Mapping(target = "id.id", source = "id"),
        @Mapping(target = "address.detail", source = "addressDetail")
    })
    OrderDO toOrder(OrderPO orderPO);

    @Mappings({
    @Mapping(target = "addressDetail", source = "address.detail"),
    @Mapping(target = "id", source = "id.id")
    })
    OrderPO fromOrder(OrderDO aggregate);
}
