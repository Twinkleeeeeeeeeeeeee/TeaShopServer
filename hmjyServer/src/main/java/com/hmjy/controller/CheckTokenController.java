package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.service.CheckTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CheckTokenController {

    @Autowired
    private CheckTokenService checkTokenService;

    @RequestMapping(value = "CheckToken" , method = RequestMethod.GET)
    public void CheckToken(HttpServletRequest request, HttpServletResponse response){
        Map data = new HashMap();
        String token = request.getParameter("token");
        try {
            checkTokenService.checkToken(token);
            data.put("code",0);
        }catch (Exception e){
            data.put("code",404);
        }
        Object jsonData = JSONObject.toJSON(data);
        try {
            response.getWriter().print(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
