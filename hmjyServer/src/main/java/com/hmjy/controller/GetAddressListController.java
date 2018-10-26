package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.hmjy.pojo.Address;
import com.hmjy.service.CheckTokenService;
import com.hmjy.service.GetAddressListService;
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

/**
 * @author: Twinkle~
 * @Description:获取收货地址Controlller
 * @Date: Create In 上午11:47 2018/9/17
 */
@Controller
public class GetAddressListController {
    @Autowired
    private GetAddressListService getAddressListService;
    @Autowired
    private CheckTokenService checkTokenService;
    @RequestMapping(value = "addressList",method = RequestMethod.GET)
    public void getAddressList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getParameter("token");
        Map<String,Object> map = new HashMap<>();
        try {
            Map<String, Claim> claim = checkTokenService.checkToken(token);
            String openId = claim.get("openId").asString();
            List<Address> addressList = getAddressListService.getAddressList(openId);
            response.setCharacterEncoding("utf-8");
            map.put("data",addressList);
            map.put("code",0);
            response.getWriter().print(JSONObject.toJSON(map));
        } catch (UnsupportedEncodingException e) {
            map.put("code",700);
        }
    }
}
