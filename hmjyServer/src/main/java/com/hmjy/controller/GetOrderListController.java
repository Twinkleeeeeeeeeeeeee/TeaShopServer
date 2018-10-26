package com.hmjy.controller;

import com.hmjy.service.GetOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class GetOrderListController {
    @Autowired
    private GetOrderListService getOrderListService;
    @RequestMapping(value = "OrderList",method = RequestMethod.GET)
    public void getOrderList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getParameter("token");
        Object orderList = getOrderListService.getOrderList(token);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(orderList);
    }

}
