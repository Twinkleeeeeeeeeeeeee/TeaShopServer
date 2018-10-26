package com.hmjy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.mapper.GetOrderListMapper;
import com.hmjy.pojo.UserOrder;
import com.hmjy.service.CheckTokenService;
import com.hmjy.service.GetOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetOrderListServiceImpl implements GetOrderListService {
    @Autowired
    private GetOrderListMapper orderListMapper;
    @Autowired
    private CheckTokenService checkTokenService;
    @Override
    public Object getOrderList(String token) {
        Map<String,Object> map = new HashMap<>();
        try {
            checkTokenService.checkToken(token);
            List<UserOrder> orderList = orderListMapper.getOrderList();
            map.put("code",0);
            map.put("orderList",orderList);
            Object js = JSONObject.toJSON(map);
            return js;
        } catch (UnsupportedEncodingException e) {
            map.put("code",500);
        }
        return "1";
    }
}
