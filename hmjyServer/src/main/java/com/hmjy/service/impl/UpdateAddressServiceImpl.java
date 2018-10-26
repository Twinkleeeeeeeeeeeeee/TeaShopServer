package com.hmjy.service.impl;

import com.hmjy.mapper.AddressUpdateMapper;
import com.hmjy.service.UpdateAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAddressServiceImpl implements UpdateAddressService {
    @Autowired
    private AddressUpdateMapper addressUpdateMapper;

    @Override
    public void updateAddress(String id) {
        addressUpdateMapper.updateAddress(id);
        addressUpdateMapper.updateAddressF(id);
    }
}
