package com.hmjy.mapper;

import java.util.List;
import java.util.Map;

public interface OrderDetailMapper {
    List<Map> getOrderDetail(String orderId);
}
