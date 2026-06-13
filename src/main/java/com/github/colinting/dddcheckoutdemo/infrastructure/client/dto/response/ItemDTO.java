package com.github.colinting.dddcheckoutdemo.infrastructure.client.dto.response;

import lombok.Data;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:02
 */

@Data
public class ItemDTO {

    private Long itemId;
    private Long sellerId;
    private String title;
    private Long priceInCents;

}
