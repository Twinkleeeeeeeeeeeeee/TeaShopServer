package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.service.CheckTokenService;
import com.hmjy.service.GetOrderDetailService;
import com.hmjy.service.GetOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class GetOrderDetailController {
    @Autowired
    private CheckTokenService checkTokenService;
    @Autowired
    private GetOrderDetailService getOrderDetailService;
    @Autowired
    private GetOrderListService getOrderListService;
    @RequestMapping(value = "OrderDetail", method = RequestMethod.GET)
    public void setGetOrderDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderId = request.getParameter("id");
        String token = request.getParameter("token");
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = null;
        try {
            checkTokenService.checkToken(token);
            List<Map> orderDetail = getOrderDetailService.getOrderDetail(orderId);
            Object orderList = getOrderListService.getOrderList(token);
            map1 = new HashMap<>();
            map1.put("orderInfo",orderList);
            map1.put("data",map);
            map.put("goods",orderDetail);
            map1.put("code",0);
        } catch (UnsupportedEncodingException e) {
            map.put("code",500);
        }
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(JSONObject.toJSON(map1));
    }
}
