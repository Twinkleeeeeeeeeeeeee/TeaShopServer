package com.hmjy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hmjy.mapper.RegisterUserMapper;
import com.hmjy.service.UserAuthenticationService;
import com.hmjy.util.TokenProccessor;
import com.hmjy.util.WxRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    @Autowired
    private RegisterUserMapper registerUserMapper;

    @Override
    public Object UserAuthentication(String code) {
        JSONObject json = WxRequest.wxResponse(code);
        //用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        String isOpenId = registerUserMapper.isGetOpenId(openid);
        String sessionKey = (String) json.get("session_key");
        Map data = new HashMap();
        if (isOpenId == null || isOpenId.equals("")) {
            data.put("code", 1000);
        } else {
            Long uid = registerUserMapper.getUid(openid);
            data.put("code", 0);

            String token = TokenProccessor.getInstance().createToken(openid);
            data.put("uid", uid);
            data.put("token", token);
            data.put("sessionKey", sessionKey);
        }
        Object js = JSONObject.toJSON(data);
        return js;
    }
}
