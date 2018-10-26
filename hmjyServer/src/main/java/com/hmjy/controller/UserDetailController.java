package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.service.CheckTokenService;
import com.hmjy.service.UserApiInfoService;
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
public class UserDetailController {
    @Autowired
    private UserApiInfoService apiInfoService;
    @Autowired
    private CheckTokenService checkTokenService;
    @RequestMapping(value = "userDetail",method = RequestMethod.GET)
    public void userDetail(HttpServletRequest request, HttpServletResponse response){
        Map map = new HashMap();
        String token = request.getParameter("token");
        try {
            checkTokenService.checkToken(token);
            map.put("code",0);
        } catch (UnsupportedEncodingException e) {
           map.put("code",500);
           return;
        }
        String name = (String) apiInfoService.getUserApiInfo().get("nickName");
        String phoneNumber = (String) apiInfoService.getUserApiInfo().get("phoneNumber");
        map.put("mobile",phoneNumber);
        map.put("data",name);
        Object js = JSONObject.toJSON(map);
        try {
            response.getWriter().print(js);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

