package com.hmjy.service.impl;

import com.hmjy.mapper.CreateOrderMapper;
import com.hmjy.pojo.UserOrder;
import com.hmjy.service.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderServiceImpl implements CreateOrderService {
    @Autowired
    private CreateOrderMapper orderMapper;
    @Override
    public void createOrder(UserOrder userOrder) {
        orderMapper.insertOrderInfo(userOrder);
    }
}
