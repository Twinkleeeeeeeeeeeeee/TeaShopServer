package com.hmjy.service.impl;

import com.hmjy.mapper.OrderDetailMapper;
import com.hmjy.service.GetOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetOrderDetailServiceImpl implements GetOrderDetailService {
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<Map> getOrderDetail(String orderId) {
        List<Map> orderDetail = orderDetailMapper.getOrderDetail(orderId);
        return orderDetail;
    }
}
