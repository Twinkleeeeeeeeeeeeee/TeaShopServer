package com.hmjy.mapper;

public interface CancleOrderMapper {
    void deleteOrder(String orderId);
    void deleteOrderInfo(String orderId);
}
