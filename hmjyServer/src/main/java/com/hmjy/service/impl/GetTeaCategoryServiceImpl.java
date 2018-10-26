package com.hmjy.service.impl;

import com.hmjy.mapper.TeaCategoryMapper;
import com.hmjy.pojo.TeaCategory;
import com.hmjy.service.GetTeaCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetTeaCategoryServiceImpl implements GetTeaCategoryService {
    @Autowired
    private TeaCategoryMapper teaCategoryMapper;
    @Override
    public List<TeaCategory> getTeaCategoryService() {
        List<TeaCategory> categories = teaCategoryMapper.getTeaCategory();
        return categories;
    }
}
