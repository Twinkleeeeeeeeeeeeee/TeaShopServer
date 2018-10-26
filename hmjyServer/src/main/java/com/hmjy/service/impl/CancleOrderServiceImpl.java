package com.hmjy.service.impl;

import com.hmjy.mapper.CancleOrderMapper;
import com.hmjy.service.CancleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancleOrderServiceImpl implements CancleOrderService {
    @Autowired
    private CancleOrderMapper cancleOrderMapper;
    @Override
    public void cancleOrder(String orderId) {
        cancleOrderMapper.deleteOrder(orderId);
        cancleOrderMapper.deleteOrderInfo(orderId);
    }
}
