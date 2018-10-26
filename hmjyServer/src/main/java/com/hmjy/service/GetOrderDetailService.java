package com.hmjy.service;

import java.util.List;
import java.util.Map;

public interface GetOrderDetailService {
    List<Map> getOrderDetail(String orderId);
}
