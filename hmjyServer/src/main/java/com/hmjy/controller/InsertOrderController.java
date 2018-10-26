package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.service.InsertOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class InsertOrderController {
    @Autowired
    private InsertOrderService orderService;
    @RequestMapping(value = "parseOrder",method = RequestMethod.GET)
    public void InsertOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Date date = new Date();
        Map<String,Object> map = new HashMap<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String orderId = dateFormat.format(date);
        String goodsJsonStr = request.getParameter("goodsJsonStr");
        orderService.InsertOrder(goodsJsonStr,orderId);
        map.put("orderId",orderId);
        Object json = JSONObject.toJSON(map);
        response.getWriter().print(json);
    }
}
