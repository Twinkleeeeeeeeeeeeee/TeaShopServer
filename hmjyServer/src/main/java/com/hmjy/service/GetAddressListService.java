package com.hmjy.service;

import com.hmjy.pojo.Address;

import java.util.List;

public interface GetAddressListService {
    List<Address> getAddressList(String userId);
}
