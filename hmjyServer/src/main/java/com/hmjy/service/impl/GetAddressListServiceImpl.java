package com.hmjy.service.impl;

import com.hmjy.mapper.UserAddressMapper;
import com.hmjy.pojo.Address;
import com.hmjy.service.GetAddressListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Twinkle~
 * @Description:获取用户收获地址列表
 * @Date: Create In 上午11:39 2018/9/17
 */
@Service
public class GetAddressListServiceImpl implements GetAddressListService {
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public List<Address> getAddressList(String userId) {
        return userAddressMapper.getAddressList(userId);
    }
}
