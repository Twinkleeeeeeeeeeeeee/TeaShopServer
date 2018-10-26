package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.service.CancleOrderService;
import com.hmjy.service.CheckTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CancleOrderController {
    @Autowired
    private CancleOrderService cancleOrderService;
    @Autowired
    private CheckTokenService checkTokenService;

    @RequestMapping(value = "cancleOrder", method = RequestMethod.GET)
    public void CancleOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String orderId = request.getParameter("orderId");
        String token = request.getParameter("token");
        try {
            checkTokenService.checkToken(token);
            cancleOrderService.cancleOrder(orderId);
            map.put("code", 0);
        } catch (UnsupportedEncodingException e) {
            map.put("code", 500);
        }
        response.getWriter().print(JSONObject.toJSON(map));

    }
}
