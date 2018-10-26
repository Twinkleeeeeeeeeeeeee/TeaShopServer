package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.service.BindPhoneService;
import com.hmjy.service.CheckTokenService;

import com.hmjy.util.WxRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

@Controller
public class BindPhoneController {

    @Autowired
    private BindPhoneService bindPhoneService;
    @Autowired
    private CheckTokenService checkToken;
 
 
    @RequestMapping(value = "bindPhone", method = RequestMethod.GET)
    public void BindPhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map map = new HashMap();
        String token = request.getParameter("token");
        String code = request.getParameter("code");
        JSONObject jsonObject = WxRequest.wxResponse(code);
        String session_key = (String) jsonObject.get("session_key");
        String openId = (String) jsonObject.get("openid");
        Map data = new HashMap();
        try {
            checkToken.checkToken(token);
            data.put("code", 0);
        } catch (Exception e) {
            data.put("code", 404);
        }
        String iv = request.getParameter("iv");
        String encrypData = request.getParameter("encryptedData");        
        bindPhoneService.bindPhone(session_key,iv,encrypData,openId);
        map.put("code",0);
        Object res = JSONObject.toJSON(map);
        response.getWriter().print(res);
    }
}
