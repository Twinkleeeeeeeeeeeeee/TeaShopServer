package com.hmjy.mapper;

import com.hmjy.pojo.Address;

import java.util.List;

public interface UserAddressMapper {
    Address getUserAddress(String userId);
    void insertUserAddress(Address address);
    List<Address> getAddressList(String userId);
}
