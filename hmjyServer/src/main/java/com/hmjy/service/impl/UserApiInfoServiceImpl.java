package com.hmjy.service.impl;

import com.hmjy.mapper.GetUserInfoMapper;
import com.hmjy.service.UserApiInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserApiInfoServiceImpl implements UserApiInfoService {
    @Autowired
    private GetUserInfoMapper getUserInfoMapper;

    public Map<String, Object> getUserApiInfo() {
        Map<String, Object> userApiInfo = getUserInfoMapper.getUserApiInfo();
        return userApiInfo;
    }
}
