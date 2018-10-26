package com.hmjy.service.impl;


import com.hmjy.pojo.UserInfo;
import com.hmjy.service.DecodeUserService;
import com.hmjy.util.DecodeUserInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DecodeUserServiceImpl implements DecodeUserService {


    @Override
    public Map decodeUserService(String encryptedData, String iv, String code) {
        return new DecodeUserInfo().decodeUserInfo(encryptedData, iv, code);
    }

    @Override
    public UserInfo decodeUser(String encryptedData, String iv, String code) {
        return new DecodeUserInfo().decodeUser(encryptedData, iv, code);
    }
}
