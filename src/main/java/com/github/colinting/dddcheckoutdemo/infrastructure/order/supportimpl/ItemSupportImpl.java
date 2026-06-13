package com.github.colinting.dddcheckoutdemo.infrastructure.order.supportimpl;

import com.github.colinting.dddcheckoutdemo.domain.order.entity.ItemDO;
import com.github.colinting.dddcheckoutdemo.domain.order.support.ItemSupport;
import com.github.colinting.dddcheckoutdemo.infrastructure.client.ExternalItemClient;
import com.github.colinting.dddcheckoutdemo.infrastructure.client.dto.response.ItemDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

// 商品facade实现
@Service
public class ItemSupportImpl implements ItemSupport {

    @Resource
    private ExternalItemClient externalItemClient;

    @Override
    public ItemDTO getItem(Long itemId) {
        ItemDO itemDO = externalItemClient.getItem(itemId);
        if (itemDO != null) {
            ItemDTO dto = new ItemDTO();
            dto.setItemId(itemDO.getItemId());
            dto.setTitle(itemDO.getTitle());
            dto.setPriceInCents(itemDO.getPriceInCents());
            dto.setSellerId(itemDO.getSellerId());
            return dto;
        }
        return null;
    }
}
