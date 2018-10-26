package com.hmjy.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hmjy.mapper.RegisterUserMapper;
import com.hmjy.service.BindPhoneService;
import com.hmjy.util.AESDecodePhone;
import com.hmjy.pojo.UserPhone;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BindPhoneServiceImpl implements BindPhoneService {
    @Autowired
    private RegisterUserMapper registerUserMapper;
    @Override
    public void bindPhone(String key, String iv, String encData,String openId) throws Exception {

        UserPhone userPhone = new UserPhone();
        byte[] encrypData = Base64.decodeBase64(encData);
        byte[] ivData = Base64.decodeBase64(iv);
        byte[] sessionKey = Base64.decodeBase64(key);
        byte[] jxData = AESDecodePhone.decrypt(sessionKey, ivData, encrypData);
        JSONObject total = JSONArray.parseObject(new String(jxData));
        String phoneNumber = (String) total.get("phoneNumber");
        String countryCode = (String) total.get("countryCode");
        System.out.println(phoneNumber + "," + countryCode);
        userPhone.setPhoneNumber(phoneNumber);
        userPhone.setUserOpenId(openId);
        userPhone.setCountryCode(countryCode);
        registerUserMapper.addPhone(userPhone);
    }
}
