package com.hmjy.controller;

import com.hmjy.service.GetUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserAddressController {
    @Autowired
    private GetUserAddressService getUserAddressService;
    @RequestMapping(value = "userAddress",method = RequestMethod.GET)
    public void GetUserAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String token = request.getParameter("token");
        Object userAddress = getUserAddressService.getUserAddress(token);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(userAddress);
    }
}
