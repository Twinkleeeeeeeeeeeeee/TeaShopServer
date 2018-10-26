package com.hmjy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.hmjy.mapper.UserAddressMapper;
import com.hmjy.pojo.Address;
import com.hmjy.service.CheckTokenService;
import com.hmjy.service.GetUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class GetUserAddressServiceImpl implements GetUserAddressService {
    private String userId;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private CheckTokenService checkTokenService;
    @Override
    public Object getUserAddress(String token) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            Map<String, Claim> Claim = checkTokenService.checkToken(token);
            userId = Claim.get("openId").asString();
            Address userAddress = userAddressMapper.getUserAddress(userId);
            map.put("data",userAddress);
            map.put("code",0);
        } catch (UnsupportedEncodingException e) {
            map.put("code",500);
        }
        return JSONObject.toJSON(map);
    }
}
