package com.github.colinting.dddcheckoutdemo.application.order.assemble;

import com.github.colinting.dddcheckoutdemo.adapter.order.web.vo.response.OrderDTO;
import com.github.colinting.dddcheckoutdemo.domain.order.entity.OrderDO;
import com.github.colinting.dddcheckoutdemo.infrastructure.client.dto.response.ItemDO;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author 丁浩
 * @date 2022年09月01日 11:21
 */
@Mapper(componentModel = "spring")
public interface OrderDtoAssembler {

    // 通过各种实体，生成DTO
    @Mappings({
        @Mapping(target = "id", source = "order.id.id"),
        @Mapping(target = "itemTitle", source = "item.title"),
        @Mapping(target = "detailAddress", source = "order.address.detail"),
    })
    OrderDTO toDTO(OrderDO order, ItemDO item);


    @Mappings({
        @Mapping(target = "id", source = "id.id"),
        @Mapping(target = "itemTitle", source = "itemTitle"),
        @Mapping(target = "detailAddress", source = "address.detail"),
    })
    OrderDTO orderToDTO(OrderDO savedOrder);

    // 通过DTO，生成实体

}
