package com.hmjy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hmjy.mapper.InsertOrderInfoMapper;
import com.hmjy.pojo.Order;
import com.hmjy.service.InsertOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Twinkle~
 * @Description:下单界面
 * @Date: Create In 上午9:26 2018/9/21
 */
@Service
public class InsertOrderServiceImpl implements InsertOrderService {
    @Autowired
    private InsertOrderInfoMapper orderInfoMapper;
    @Override
    public void InsertOrder(String goodsJsonStr,String orderId) {
        JSONArray objects = JSONObject.parseArray(goodsJsonStr);


        for (Object object : objects) {
            Order order = new Order();
            JSONObject jsonObject = JSONObject.parseObject(object.toString());
            Integer goodsId = (Integer)jsonObject.get("goodsId");
            Integer number = (Integer)jsonObject.get("number");
            order.setOrderId(String.valueOf(orderId));
            order.setTeaId(goodsId);
            order.setNumberOrders(number);
            orderInfoMapper.insertOrderInfo(order);
        }
    }
}
