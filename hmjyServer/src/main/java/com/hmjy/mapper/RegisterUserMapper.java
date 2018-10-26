package com.hmjy.mapper;

import com.hmjy.pojo.UserInfo;
import com.hmjy.pojo.UserPhone;

public interface RegisterUserMapper {
    void add(UserInfo userInfo);

    Long getUid(String code);

    String isGetOpenId(String openId);

    void addPhone(UserPhone userPhone);
}
