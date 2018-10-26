package com.hmjy.service.impl;

import com.hmjy.mapper.UserAddressMapper;
import com.hmjy.pojo.Address;
import com.hmjy.service.InsertUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertUserAddressServiceImpl implements InsertUserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public void insertUserAddress(Address address) {
        userAddressMapper.insertUserAddress(address);
    }
}
