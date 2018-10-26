package com.hmjy.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.hmjy.pojo.Address;
import com.hmjy.service.CheckTokenService;
import com.hmjy.service.InsertUserAddressService;
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
public class InsertUserAddressController {
    @Autowired
    private InsertUserAddressService userAddressService;
    @Autowired
    private CheckTokenService checkTokenService;

    @RequestMapping(value = "InsertUserAddress", method = RequestMethod.GET)
    public void InsertUserAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> map = new HashMap<>();
        Address userAddress = new Address();
        String token = request.getParameter("token");
        String provinceId = request.getParameter("provinceId");
        String cityId = request.getParameter("cityId");
        String districtId = request.getParameter("districtId");
        String linkMan = request.getParameter("linkMan");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String code = request.getParameter("code");
        String isDefault = request.getParameter("isDefault");
        try {
            Map<String, Claim> claim = checkTokenService.checkToken(token);
            String userId = claim.get("openId").asString();
            userAddress.setUserId(userId);
            userAddress.setProvinceId(provinceId);
            userAddress.setCityId(cityId);
            userAddress.setDistrictId(districtId);
            userAddress.setLinkMan(linkMan);
            userAddress.setAddress(address);
            userAddress.setMobile(mobile);
            userAddress.setCode(code);
            userAddress.setIsDefault(isDefault);
            userAddressService.insertUserAddress(userAddress);
            map.put("code",0);
        } catch (UnsupportedEncodingException e) {
            map.put("code", 500);
        }
        response.getWriter().print(JSONObject.toJSON(map));
    }
}
