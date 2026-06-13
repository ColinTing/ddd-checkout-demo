package com.github.colinting.dddcheckoutdemo.domain.order.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderDOTest {

    @Test
    void newOrderShouldNotGenerateIdBeforePersistence() {
        OrderDO order = new OrderDO();

        assertThat(order.getId()).isNull();
    }
}
