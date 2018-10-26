package com.hmjy.service;

public interface BindPhoneService {
    void bindPhone(String key, String iv, String encData,String openId) throws Exception;
}
