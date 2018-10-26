package com.hmjy.service;

import com.hmjy.pojo.UserInfo;

import java.util.Map;

public interface DecodeUserService {
     Map decodeUserService(String encryptedData, String iv, String code);
     UserInfo decodeUser(String encryptedData, String iv, String code);
}
